import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Servlet_4")
public class Servlet_4_Update_infos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error_update_username",false);
        request.setAttribute("succes_update_username",false);

        request.setAttribute("error_update_password",false);
        request.setAttribute("succes_update_password",false);

        request.setAttribute("error_update_status",false);
        request.setAttribute("succes_update_status",false);

        request.setAttribute("error_update_image",false);
        request.setAttribute("succes_update_image",false);

        this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filter_number= request.getParameter("filter_number");
        HttpSession session=request.getSession();
        request.setAttribute("error_update_username",false);
        request.setAttribute("succes_update_username",false);
        String session_username= (String) session.getAttribute("session_username");

        switch (filter_number){
            case "1":
                String new_username =request.getParameter("new_username");
                String new_username_confirmation=request.getParameter("new_username_confirmation");
                String password1=request.getParameter("password1");

                if (Update_Profile.Update_Username(session_username,new_username,new_username_confirmation,password1)){
                    request.setAttribute("succes_update_username",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }else {
                    request.setAttribute("error_update_username",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }


                break;
            case "2":
                String new_password=request.getParameter("new_password");
                String new_password_confirmation=request.getParameter("new_password_confirmation");
                String password2=request.getParameter("password2");
                if (Update_Profile.Update_Password(session_username,new_password,new_password_confirmation,password2)){
                    request.setAttribute("succes_update_password",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }else {
                    request.setAttribute("error_update_password",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }

                break;
            case "3":
                String password3=request.getParameter("password3");
                if (Update_Profile.Update_image(session_username,request,password3)){
                    request.setAttribute("succes_update_image",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }else {
                    request.setAttribute("error_update_image",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }

                break;
            case "4":
                String new_statue=request.getParameter("new_statue");
                String password4=request.getParameter("password4");

                if (Update_Profile.Update_Status(session_username,new_statue,password4)){
                    request.setAttribute("succes_update_status",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }else {
                    request.setAttribute("error_update_status",true);
                    this.getServletContext().getRequestDispatcher("/JSPs/change_infos.jsp").forward(request,response);
                }
                break;
        }
    }


}
