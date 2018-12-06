package trabalho.poo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static String DRIVER = "TrabalhoPoo/TrabalhoPoo/libs/portgres";
	private static String URL 	 = "bancopoo.postgresql.dbaas.com.br";
	private static String USER	 = "bancopoo";
	private static String PASSWD = "unilasalle1";
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWD);
		}catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
		
	}

}
