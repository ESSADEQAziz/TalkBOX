import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user_image_DAO {
    public static String find_image_name(int user_id){
        Connection connection=DBconnection.getConnection();
        String query="select image_name from user_image where user_id= ? ;";
        String result;
        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,user_id);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                result=resultSet.getString(1);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static Boolean Add_image_name(int user_id,String image_name){
        Connection connection=DBconnection.getConnection();
        String query="insert into user_image (image_name,user_id) values(?,?) ;";
        boolean bool=false;
        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,image_name);
            statement.setInt(2,user_id);
            statement.execute();
            bool=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bool;
    }

    public static Boolean Update_image_name(int user_id,String image_name){
        Connection connection=DBconnection.getConnection();
        String query="update user_image set image_name=? where user_id=? ;";
        boolean bool=false;
        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,image_name);
            statement.setInt(2,user_id);
            statement.execute();
            bool=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bool;
    }

}
