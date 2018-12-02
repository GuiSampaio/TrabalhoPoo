import java.util.*;
import java.sql.*;

public class RepositorioCargo
{	public static int incluir (Connection conn, int cod, String nome, String desc) 
		throws Excecao
	{		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO CARGO (COD, NOME, DESCRICAO) " +
	   			 "VALUES (?, ?,  ?)");
			pstmt.setInt (1, cod);
			pstmt.setString (2, nome);
			pstmt.setString (3, desc);	
	

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("CARGO_COD_PK") != -1)
				{	throw new Excecao(1, "Codigo de Cargo duplicado.");
				}
				else
				{	System.out.println('\n' + "Erro na inclusão de um Cargo.");
					e.printStackTrace();
					System.exit(1);			
				}
			}
			else
			{	e.printStackTrace();
				System.exit(1);
			} 
		}

		return pk;
	}

	public static boolean alterar (Connection conn, int cod, String nome, String desc) 
		throws Excecao
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE CARGO SET NOME = ?, DESCRICAO = ? WHERE COD = ? ");
			
			pstmt.setString	(1, nome);	
			pstmt.setString	(2, desc);
			pstmt.setInt	(3, cod);	
			
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("CARGO_COD_PK") != -1)
				{	throw new Excecao(1, "Codigo de Cargo duplicado.");
				}
				
				else
				{	System.out.println('\n' + "Erro na alteração de um Cargo.");
					e.printStackTrace();
					System.exit(1);			
				}
			}
			else
			{	e.printStackTrace();
				System.exit(1);
			} 
		}

		return n == 1;
	}


	public static boolean exclui (Connection conn, int cod) 
	// throws Excecao <== É muito comum o método exclui gerar alguma  
	//                    exceção, no entanto, neste caso em particular 
	//                    nenhuma exceção é gerada.
	{		
		int n = 0;
				
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("DELETE FROM CARGO WHERE COD = ?");
			
			pstmt.setInt (1, cod);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de uma Cargo.");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static Cliente recuperaUmCargo(Connection conn, int cod)
	{	Empregado e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT NOME, DESCRICAO, COD FROM CARGO " +
	 			 "WHERE COD = ? "); 

			pstmt.setInt(1, cod);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Empregado(rs.getString("NOME"),
							 	  rs.getString("DESCRICAO"),
					              rs.getInt("COD"));
	 		}
	 		pstmt.close();
		}	
		catch (SQLException ex)
		{	ex.printStackTrace();
			System.exit(1);
		}

		return e;
	}

	
}