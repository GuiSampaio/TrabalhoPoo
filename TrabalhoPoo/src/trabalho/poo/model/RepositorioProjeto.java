import java.util.*;
import java.sql.*;

public class RepositorioProjeto
{	public static int incluir (Connection conn, int cod, String cpf, Date inicio, Date fim, double valor) 
		throws Excecao
	{	

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO PROJETO (COD, CPF, DATA_INICIO, DATA_FIM, VALOR) " +
	   			 "VALUES (?, ?, ?, ?)");
			pstmt.setInt (1, cod);
			pstmt.setString	(2, cpf);	
			pstmt.setString (3, inicio);
			pstmt.setString (4, fim);
			pstmt.setDouble	(5, valor);	

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("PROJETO_COD_PK") != -1)
				{	throw new Excecao(1, "Código já existente.");
				}
				
				else
				{	System.out.println('\n' + "Erro na inclusão de um Projeto.");
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

	public static boolean alterar (Connection conn, int cod, String cpf, Date inicio, Date fim, double valor) 
		throws Excecao
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE PROJETO SET CPF = ?, DATA_INICIO = ?, DATA_FIM = ?, VALOR = ? WHERE COD = ?");
				
			pstmt.setString	(1, cpf);	
			pstmt.setString	(2, inicio);
			pstmt.setString	(2, fim);			
			pstmt.setDouble	(3, valor);	
			pstmt.setInt	(4, cod);	
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("PROJETO_COD_PK") != -1)
				{	throw new Excecao(1, "Código já existente.");
				}
				else
				{	System.out.println('\n' + "Erro na inclusão de um Projeto.");
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


	public static boolean excluir (Connection conn, int cod) 
	// throws Excecao <== É muito comum o método exclui gerar alguma  
	//                    exceção, no entanto, neste caso em particular 
	//                    nenhuma exceção é gerada.
	{		
		int n = 0;
				
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("DELETE FROM PROJETO WHERE COD = ?");
			
			pstmt.setInt (1, cod);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de um Projeto.");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static Projeto recuperaUmProjeto(Connection conn, int cod)
	{	Empregado e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT COD, CPF, DATA_INICIO, DATA_FIM, VALOR FROM PROJETO " +
	 			 "WHERE COD = ?"); 

			pstmt.setInt(1, cod);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Empregado(rs.getInt("COD"),
					              rs.getString("CPF"),
								  rs.getString("DATA_INICIO"),
					              rs.getString("DATA_FIM"), 
						          rs.getDouble("VALOR"));
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