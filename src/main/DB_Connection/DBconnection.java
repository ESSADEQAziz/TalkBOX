import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/talkbox";
    private static final String user = "root";
    private static final String pass = "";
    private static Connection connection;


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Etablie au  base de donnees avec succes !!");

        } catch (SQLException e) {

            System.out.println("Pas de Connection avec la Base de Donnees !!");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}