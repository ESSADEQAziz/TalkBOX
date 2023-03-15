import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tstatus_DAO {
    public static String Find_Status(int user_id)  {
        Connection connection=DBconnection.getConnection();
        String qury="select status from tstatus where status_userid=?;";
        try {
            PreparedStatement statement=connection.prepareStatement(qury);
            statement.setInt(1,user_id);
            ResultSet result=statement.executeQuery();

            while (result.next()){
                return result.getString(1);
            }
           return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static boolean Update_Status(int user_id,String new_status){
        Connection connection=DBconnection.getConnection();
        String qury="update tstatus set status=? where status_userid=?;";
        boolean bool=false;
        try {
            PreparedStatement statement= connection.prepareStatement(qury);
            statement.setString(1,new_status);
            statement.setInt(2,user_id);
            statement.execute();
            bool= true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bool;
    }

}
