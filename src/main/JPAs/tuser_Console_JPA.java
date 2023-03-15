import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class tuser_Console_JPA {
    public static List<tuser> List_Users(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App_2");
        EntityManager entityManager = emf.createEntityManager();

        TypedQuery<tuser> q = entityManager.createQuery( "select c from tuser c ", tuser.class );
        List<tuser> tusers ;

        tusers = q.getResultList();
        if (tusers == null){
            System.out.println("la methode List_Users n'arrive pas remplire la liste.");
            return tusers;
        }else {
            System.out.println("Remplire List_Users avec succes .");
            return tusers;
        }
    }


    public static boolean Ajouter_User(tuser user){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App_2");
        EntityManager entityManager = emf.createEntityManager();
        Boolean bool=false;

        try{
            entityManager.persist(user);
            bool=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    }

    public static tuser Find_User(int userid){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App_2");
        EntityManager entityManager = emf.createEntityManager();

        tuser user = entityManager.find(tuser.class,userid);
        if (user == null){
            System.out.println("Erreur lors de recherche d'un user dans la methode Find_User. ");
            return null;
        }else {
            return user;
        }
    }

    public static boolean Modifier_User(int userid, String username, String password, String email, int age, LocalDate date_creation, int token){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App_2");
        EntityManager entityManager = emf.createEntityManager();
        Boolean bool=false;

        try{
            tuser user=entityManager.find(tuser.class,userid);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setAge(age);
            user.setDate_creation(Date.valueOf(date_creation));
            user.setToken(token);

            //entityManager.merge(user);

            bool=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    }
    public static boolean Remove_User(int userid){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App_2");
        EntityManager entityManager = emf.createEntityManager();
        Boolean bool=false;

        try{
            tuser user=entityManager.find(tuser.class,userid);
            System.out.println(user.getUsername());
            entityManager.remove(user);
            bool=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    }

}
