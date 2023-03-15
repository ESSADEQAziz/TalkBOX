import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;

public class Update_Profile {
    public static boolean  Update_Username(String session_username, String new_username,String new_username_confirmation,String password1){
        tuser user=tuser_DAO.Trouver_user(session_username);
        if (user.getPassword().equals(password1) && new_username.equals(new_username_confirmation)){
            user.setUsername(new_username);
            return tuser_DAO.Modifier_user(user);
        }else {
            return false;
        }
    }
    public static boolean Update_Password(String session_username, String new_password,String new_password_confirmation,String password2){
        tuser user=tuser_DAO.Trouver_user(session_username);
        if(user.getPassword().equals(password2) && new_password.equals(new_password_confirmation)){
            user.setPassword(new_password);
            return tuser_DAO.Modifier_user(user);
        }else {
            return false;
        }
    }
    public static boolean Update_Status(String session_username, String new_status,String password4){
        tuser user=tuser_DAO.Trouver_user(session_username);
        if (user.getPassword().equals(password4)){
            return tstatus_DAO.Update_Status(user.getUserid(),new_status);
        }else {
            return false;
        }
    }
    public static boolean Update_image(String session_username, HttpServletRequest request,String password3){
        tuser user=tuser_DAO.Trouver_user(session_username);

        if (user.getPassword().equals(password3)){
            // A changer pour assurer la correspondance avec la host machine :
            final String CHEMIN_FICHIERS = "C:/Users/DELL/Desktop/ProjetsWeb/App_2/src/main/webapp/user_images/";

            // On récupère le champ du fichier
            Part part = null;
            try {
                part = request.getPart("image_file");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

            // On vérifie qu'on a bien reçu un fichier
            String nomFichier = Image_Methodes.getNomFichier(part);

            // Si user a deja une image on le change sinon on ajout le non d'image avec id du user

            if (user_image_DAO.find_image_name(user.getUserid()) == null){
                user_image_DAO.Add_image_name(user.getUserid(),nomFichier);
            }else {
                nomFichier=user_image_DAO.find_image_name(user.getUserid());
            }

            try {
                // On écrit définitivement le fichier sur le disque
                Image_Methodes.ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
                System.out.println("telechargement du photo avec succes !");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Erreur lors de telechargement du photo !");
            }

            return true;

        }else {
            return false;
        }

    }


}
