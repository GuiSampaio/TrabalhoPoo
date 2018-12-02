import java.util.*;
import java.sql.*;

public class RepositorioAlocado
{	public static int incluir (Connection conn, int cod_func, int cod_ativ, String funcao) 
		throws Excecao
	{		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO ALOCADO (FUNC_COD, ATIV_COD, FUNCAO) " +
	   			 "VALUES (?, ?, ?)");
			pstmt.setInt (1, cod_func);
			pstmt.setInt (2, cod_ativ);	
			pstmt.setString (3, funcao );

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
			
			e.printStackTrace();
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("ALOCADO_FUNC_COD_FK") != -1)
//				{	throw new Excecao(1, "Codigo de Funcionário duplicado.");
//				}
//				else if (e.getMessage().toUpperCase().indexOf("ALOCADO_ATIV_COD_FK") != -1)
//				{	throw new Excecao(2, "Codigo de Atividade duplicado.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na inclusão de uma Alocação.");
//					e.printStackTrace();
//					System.exit(1);			
//				}
//			}
//			else
//			{	e.printStackTrace();
//				System.exit(1);
//			} 
		}

		return pk;
	}

	public static boolean alterar (Connection conn, int cod_func, int cod_ativ, String funcao) 
		throws Excecao
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE ALOCADO SET FUNCAO = ? WHERE FUNC_COD = ? AND ATIV_COD = ?");
				
			pstmt.setString	(1, nome);	
			pstmt.setInt	(2, cod_func);	
			pstmt.setInt	(3, cod_ativ);
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("ALOCADO_FUNC_COD_FK") != -1)
				{	throw new Excecao(1, "Codigo de Funcionário duplicado.");
				}
				else if (e.getMessage().toUpperCase().indexOf("ALOCADO_ATIV_COD_FK") != -1)
				{	throw new Excecao(2, "Codigo de Atividade duplicado.");
				}
				else
				{	System.out.println('\n' + "Erro na alteração de uma Alocação.");
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


	public static boolean exclui (Connection conn, int cod_func, int cod_ativ) 
	// throws Excecao <== É muito comum o método exclui gerar alguma  
	//                    exceção, no entanto, neste caso em particular 
	//                    nenhuma exceção é gerada.
	{		
		int n = 0;
				
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("DELETE FROM ALOCADO WHERE FUNC_COD = ? AND ATIV_COD = ?");
			
			pstmt.setInt (1, cod_func);
			pstmt.setInt (1, cod_ativ);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de uma Alocação.");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static Cliente recuperaUmaAlocacao(Connection conn, int cod_func, int cod_ativ)
	{	Empregado e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT FUNC_COD, ATIV_COD, FUNCAO FROM ALOCADO" +
	 			 "WHERE FUNC_COD = ? AND ATIV_COD = ?"); 

			pstmt.setInt(1, cod_func);
			pstmt.setInt(2, cod_ativ);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Empregado(rs.getInt("FUNC_COD"),
					              rs.getInt("ATIV_COD"), 
					              rs.getString("FUNCAO"));
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