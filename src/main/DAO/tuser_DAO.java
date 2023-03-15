import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class tuser_DAO {
    public static List<tuser> List_Users(){
        Connection connection=DBconnection.getConnection();
        List<tuser> users=new ArrayList<>();
        try {

            Statement statement=connection.createStatement();
            String query="Select * from tuser;";

            ResultSet result=statement.executeQuery(query);
            while (result.next()){
                tuser user=new tuser();
                user.setUserid(result.getInt(1));
                user.setUsername(result.getString(2));
                user.setPassword(result.getString(3));
                user.setEmail(result.getString(4));
                user.setAge(result.getInt(5));
                user.setDate_creation(result.getDate(6));
                user.setToken(result.getInt(7));
                user.setLast_connection(result.getTime(8));
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Ajouter_user(tuser user){
        Connection connection=DBconnection.getConnection();
        String query="insert into tuser(username,password,email,age,date_creation,token,last_connection) " +
                "VALUES(?,?,?,?,?,?,?);" ;
        boolean bool=false;
        try{
            PreparedStatement preStatement=connection.prepareStatement(query);
            preStatement.setString(1,user.getUsername());
            preStatement.setString(2,user.getPassword());
            preStatement.setString(3, user.getEmail());
            preStatement.setInt(4,user.getAge());
            preStatement.setDate(5,user.getDate_creation());
            preStatement.setInt(6,user.getToken());
            preStatement.setTime(7, Time.valueOf(LocalTime.now()));

            preStatement.executeUpdate();
            bool=true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bool;
    }

    public static boolean Modifier_user(tuser user){
        Connection connection=DBconnection.getConnection();
        String query="update tuser set username=? ,password=? ,email=? ,age=? ,date_creation=? ,token=? ,last_connection=? " +
                " where userid=? ; " ;
        boolean bool=false;
        try{
            PreparedStatement preStatement=connection.prepareStatement(query);
            preStatement.setString(1,user.getUsername());
            preStatement.setString(2,user.getPassword());
            preStatement.setString(3, user.getEmail());
            preStatement.setInt(4,user.getAge());
            preStatement.setDate(5,user.getDate_creation());
            preStatement.setInt(6,user.getToken());
            preStatement.setTime(7,user.getLast_connection());
            preStatement.setInt(8,user.getUserid());

            preStatement.executeUpdate();
            bool=true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bool;
    }

    public static boolean Supprimer_User(int userid){
        Connection connection=DBconnection.getConnection();
        String query="delete from tuser where userid=? ; " ;
        boolean bool=false;

        try{
            PreparedStatement preStatement=connection.prepareStatement(query);
            preStatement.setInt(1,userid);

            preStatement.executeUpdate();
            bool=true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bool;
    }
    public static tuser Trouver_user(String username){
        tuser new_user=new tuser();

        List<tuser> tusers=List_Users();
        for (tuser temp : tusers){
            if (temp.getUsername().equals(username)){
                new_user.setEmail(temp.getEmail());
                new_user.setUserid(temp.getUserid());
                new_user.setToken(temp.getToken());
                new_user.setAge(temp.getAge());
                new_user.setDate_creation(temp.getDate_creation());
                new_user.setPassword(temp.getPassword());
                new_user.setUsername(temp.getUsername());
                new_user.setLast_connection(temp.getLast_connection());
            }
        }
        return new_user;
    }
}
