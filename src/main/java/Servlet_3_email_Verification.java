import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet_3_email_Verification")
public class Servlet_3_email_Verification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        tuser new_user=tuser_DAO.Trouver_user(username);
        new_user.setToken(1);
        if(tuser_DAO.Modifier_user(new_user)){
            System.out.println("Le compte a ete activer avec succes !!");
        }else {
            System.out.println("Erreur lors de l'activation de compte !");
        }

        this.getServletContext().getRequestDispatcher("/JSPs/verification_mark.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
