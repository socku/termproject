package com.login;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DataConnect {
	
	private DataConnect() {
		
	}
	

//    public static String hostName = "localhost";
//    public static String portNumber = "3306";
//    public static String databaseName = "termtest";
//    public static String userName = "root";
//    public static String password = "";
    private static String user = System.getenv("ICSI518_USER");
 private static String port = System.getenv("ICSI518_PORT");
 private static String db = System.getenv("ICSI518_DB");
  private static String url="jdbc:mysql://"+System.getenv("ICSI518_SERVER")+":"+port+"/"+db;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + user + ":" + port + "/" + db);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
