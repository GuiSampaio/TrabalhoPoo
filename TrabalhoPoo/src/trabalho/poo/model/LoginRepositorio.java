package trabalho.poo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginRepositorio {
	
	public int login(Connection conn, String cpf)throws SQLException {
		int tipo = 0;
		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("SELECT COD FROM LOGIN_PESSOA WHERE CPF = ?");
		
			pstmt.setString(1, cpf);
			ResultSet rs = pstmt.executeQuery();
		if (rs.next())
 		{	
			tipo = rs.getInt("COD");
 		}
				           
			pstmt.close();
			
		} 
		catch(SQLException e)
		{	
			e.printStackTrace();
		}
		
		
		return tipo;
	}
	public void cadastrarPessoa(Connection conn, int cod, String cpf) throws SQLException {
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO LOGIN_PESSOA (COD, CPF) " +
	   			 "VALUES (?, ?)");
			pstmt.setInt (1, cod);
			pstmt.setString(2, cpf);	
			

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
