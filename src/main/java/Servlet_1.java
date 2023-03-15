import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

       this.getServletContext().getRequestDispatcher("/JSPs/Login.jsp").forward(request,response);
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
