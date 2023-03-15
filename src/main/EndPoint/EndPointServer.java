import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

@ServerEndpoint(value="/ServerEndPoint",configurator=ServletAwareConfig.class)
public class EndPointServer {
    static Set<Session> sessions= Collections.synchronizedSet(new HashSet<>());

    //key is the id returned from webSocket session ,and the name reterned from the httpsession.
    static Map<String,String> sess_map=new HashMap<>();
    private EndpointConfig config;
    public final int TEMP_COMTACTS=1;
    public final int TEMP_MESSAGES=2;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.config = config;
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        sessions.add(session);
        sess_map.put(session.getId(),(String) httpSession.getAttribute("session_username"));
        try {
            List<tuser> users=tuser_DAO.List_Users();
            for (tuser temp : users){

                session.getBasicRemote().sendText(TEMP_COMTACTS+":"+temp.getUsername()+":"+
                        tstatus_DAO.Find_Status(temp.getUserid())+":"+
                        temp.getLast_connection()+":"+
                        user_image_DAO.find_image_name(temp.getUserid()));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Received message: " + message);

        // Pour diviser le message en deux , une pour le vrai messsage et l'autre pour les distinataires de ce message.
        String[] message_brut;
        String vrai_message;
        List<String> distinataires=new ArrayList<>();
        if (message.split(":").length <= 1){
            vrai_message =message;
        }else {
            message_brut=message.split(":");
            vrai_message=message_brut[0];

            if (message_brut[1].length() == 1 || message_brut[1].length() == 0){
                distinataires= List.of(message_brut[1]);
            }else {
                distinataires= List.of(message_brut[1].split(","));
            }
        }

        System.out.println("Vrai message est : "+vrai_message);
        System.out.println("Le nombre de distinataires est : "+distinataires.size());
        for (String temp:distinataires){
            System.out.println("contact : "+temp.toString());
        }

        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        System.out.println("UserName : "+httpSession.getAttribute("session_username"));


        try {
            for(Session temp: sessions){
                if (distinataires.contains(sess_map.get(temp.getId())) || get_value((String) httpSession.getAttribute("session_username")).equals(temp.getId())){
                    System.out.println(" ce contact existe dans les distinataires : "+httpSession.getAttribute("session_username") );
                    temp.getBasicRemote().sendText(TEMP_MESSAGES+":"+httpSession.getAttribute("session_username")+": "+vrai_message + "\n");

                }else {
                    System.out.println(" ce contact n'existe pas dans les distinataires : "+httpSession.getAttribute("session_username") );
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("Session Nr : "+ session.getId() +" closed !");
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        tuser user=tuser_DAO.Trouver_user((String) httpSession.getAttribute("session_username"));
        user.setLast_connection(Time.valueOf(LocalTime.now()));
        tuser_DAO.Modifier_user(user);
        sessions.remove(session);
    }

    // La methode pour avoir id de websocket session appartir de httpSession username .
    // On utilisons le map 'sess_map' qui contient la correspondance entre les deux session (WebSocket_sessiom et httpSession)
    public static String get_value(String http_sess_name) {
        for (Map.Entry<String, String> entry : sess_map.entrySet()) {
            if (entry.getValue().equals(http_sess_name)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
