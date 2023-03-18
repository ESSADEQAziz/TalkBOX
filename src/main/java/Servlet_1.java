import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet("/Servlet_1")
public class Servlet_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("failure_authentification",false);
        request.setAttribute("account_active",true);
        request.setAttribute("failure_creation",true);

        // Si user n'a pas depasser 1 heure apres son log out , on fait login automatiquement par les cookies.
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {

            String username=new String();
            String password=new String();
            int temp=0;

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookie_username")) {
                    username=cookie.getValue();
                    temp++;
                }
                if (cookie.getName().equals("cookie_password")){
                    password=cookie.getValue();
                    temp++;
                }
            }
            if (temp == 2){
                try {
                    username=Cookies_Methods.decrypt(username);
                    password=Cookies_Methods.decrypt(password);

                    HttpSession session=request.getSession();
                    session.setAttribute("session_username",username);

                    request.setAttribute("failure_authentification",false);
                    request.setAttribute("account_active",true);
                    request.setAttribute("failure_creation",true);

                    Cookie cookie_username=new Cookie("cookie_username",Cookies_Methods.encrypt(username));
                    Cookie cookie_password=new Cookie("cookie_password",Cookies_Methods.encrypt(password));

                    cookie_username.setMaxAge(3600); cookie_password.setMaxAge(3600); // unite en seconde

                    this.getServletContext().getRequestDispatcher("/JSPs/scene_messaging.jsp").forward(request,response);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else {
                this.getServletContext().getRequestDispatcher("/JSPs/Login.jsp").forward(request,response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        List<tuser> tusers=tuser_DAO.List_Users();
        for (tuser temp : tusers){
            if (temp.getUsername().equals(username) && temp.getPassword().equals(password)){
                if (temp.getToken()!=1){

                    request.setAttribute("account_active",false);
                    request.setAttribute("failure_creation",true);
                    request.setAttribute("failure_authentification",false);

                    this.getServletContext().getRequestDispatcher("/JSPs/Login.jsp").forward(request,response);
                }else {
                    HttpSession session=request.getSession();
                    session.setAttribute("session_userid",temp.getUserid());
                    session.setAttribute("session_username",username);

                    request.setAttribute("failure_authentification",false);
                    request.setAttribute("account_active",true);
                    request.setAttribute("failure_creation",true);

                    //
                    try {
                        Cookie cookie_username=new Cookie("cookie_username",Cookies_Methods.encrypt(username));
                        Cookie cookie_password=new Cookie("cookie_password",Cookies_Methods.encrypt(password));

                        cookie_username.setMaxAge(3600); cookie_password.setMaxAge(3600); // unite en seconde
                        response.addCookie(cookie_username);
                        response.addCookie(cookie_password);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


                    this.getServletContext().getRequestDispatcher("/JSPs/scene_messaging.jsp").forward(request,response);
                }
            }
        }
        request.setAttribute("failure_authentification",true);
        request.setAttribute("account_active",true);
        request.setAttribute("failure_creation",true);

        this.getServletContext().getRequestDispatcher("/JSPs/Login.jsp").forward(request,response);

    }
}
