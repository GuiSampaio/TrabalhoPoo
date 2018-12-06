package trabalho.poo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static String DRIVER = "/TrabalhoPoo/libs/postgresql-42.2.5";
	private static String URL 	 = "bancopoo.postgresql.dbaas.com.br";
	private static String USER	 = "bancopoo";
	private static String PASSWD = "unilasalle1";
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName(DRIVER);
			System.out.println("Tentando abrir conexão AAAAAAAAAAHHHHHHHHHHHHHH!!!!!!!!!");
			return DriverManager.getConnection(URL, USER, PASSWD); 
		}catch (ClassNotFoundException e) {
			System.out.println("Erro de conexão!!!!!!!!!!!!!!!!!!!!!!!!!!");
			throw new SQLException(e.getMessage());
		}
		
	}

}
