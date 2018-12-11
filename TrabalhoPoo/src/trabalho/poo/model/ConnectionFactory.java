package trabalho.poo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static String DRIVER = "postgresql-42.2.5";
	private static String URL 	 = "jdbc:postgresql://localhost:5432/POO";
	private static String USER	 = "postgres";
	private static String PASSWD = "teste";
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Tentando abrir conexão AAAAAAAAAAHHHHHHHHHHHHHH!!!!!!!!!");
			return DriverManager.getConnection(URL, USER, PASSWD); 
		}catch (ClassNotFoundException e) {
			System.out.println("Erro de conexão!!!!!!!!!!!!!!!!!!!!!!!!!!");
			throw new SQLException(e.getMessage());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
