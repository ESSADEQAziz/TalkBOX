import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    public static void EnvoieMail(tuser user){

        String userName="aziz.xfor@gmail.com";
        String passWord="rhteyftlvicuwuef";

        //Etape 5.1 Creation de la session :
        Properties prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable", "true");

        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, passWord);
                    }
                });

        //Etape 5.2 La creation d'un message :
        Message message= new MimeMessage(session);
        try {

                message.setFrom(new InternetAddress("aziz.xfor@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
                message.setSubject("TalkBOX");
                message.setText("Your verification email is : "+
                "http://localhost:8080/App_2/Servlet_3_email_Verification"+
                "?username="+user.getUsername());


            //Etape 5.3 Envoie de message :
            Transport.send(message);
            System.out.println("Message Envoiee avec succee.");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
