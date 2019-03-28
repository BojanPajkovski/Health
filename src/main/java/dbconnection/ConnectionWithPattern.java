package dbconnection;

import java.sql.*;

/**
 * Created by User on 20.09.2018.
 */
public class ConnectionWithPattern {

    private static ConnectionWithPattern instance;

    private static Connection conn = null ;
    private static PreparedStatement stmt = null;
    private static ResultSet rst = null;

    String dbUrl ="jdbc:mysql://localhost:3006/health?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String pass ="root";

    private ConnectionWithPattern() throws SQLException, ClassNotFoundException {



        conn = DriverManager.getConnection(dbUrl,user,pass);

    }
    static{

    try{

        instance = new ConnectionWithPattern();


    }

    catch(Exception e){

        e.printStackTrace();
    }
}
    public static Connection getConnectionWithPattern(){

        return conn;
    }

}
