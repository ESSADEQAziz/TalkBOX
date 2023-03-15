import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet("/Servlet_2")
public class Servlet_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user_exist", false);
        request.setAttribute("failure_creation",false);

        this.getServletContext().getRequestDispatcher("/JSPs/Create_Account.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        int age=Integer.parseInt(request.getParameter("age"));

        request.setAttribute("user_exist", false);
        request.setAttribute("failure_creation",false);
        boolean temp_bool=true;


        List<tuser> tusers=tuser_DAO.List_Users();
        for(tuser temp : tusers){
            if(temp.getUsername().equals(username)) {
                temp_bool=false;
                request.setAttribute("user_exist", true);
                request.setAttribute("failure_creation",false);
                this.getServletContext().getRequestDispatcher("/JSPs/Create_Account.jsp").forward(request, response);
            }
        }
        if (temp_bool){

            tuser new_user=new tuser();
            new_user.setAge(age);
            new_user.setUsername(username);
            new_user.setPassword(password);
            new_user.setEmail(email);
            new_user.setDate_creation(Date.valueOf(LocalDate.now()));
            new_user.setToken(0);
            new_user.setLast_connection(Time.valueOf(LocalTime.now()));

            if (tuser_DAO.Ajouter_user(new_user)){
                System.out.println("L'ajout d'utilisateur avec succes !");
                System.out.println("Veuillez activer votre compte !");

                Mail.EnvoieMail(new_user);

                request.setAttribute("user_exist", false);
                request.setAttribute("failure_creation",false);

                this.getServletContext().getRequestDispatcher("/JSPs/Login.jsp").forward(request,response);
            }else {
                System.out.println("L'ajout a echouee !");

                request.setAttribute("user_exist", false);
                request.setAttribute("failure_creation",true);

                this.getServletContext().getRequestDispatcher("/JSPs/Create_Account.jsp").forward(request,response);

            }
        }
    }
}
