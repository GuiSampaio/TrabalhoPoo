package trabalho.poo.model;

import java.util.*;

import trabalho.poo.controller.Clientes;
import trabalho.poo.controller.Funcionario;
import trabalho.poo.controller.GerenciaDeProjeto;

import java.sql.*;

public class RepositorioGerencia
{	public static int incluir (Connection conn, int cod_proj, int cod_func) 
		throws SQLException
	{		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO GERENCIA (PROJ_COD, FUNC_COD) " +
	   			 "VALUES (?, ?)");
			pstmt.setInt (1, cod_proj);
			pstmt.setInt (2, cod_func);	

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("GERENCIA_PROJ_COD_FK") != -1)
//				{	throw new Excecao(1, "Codigo de Projeto duplicado.");
//				}
//				else if (e.getMessage().toUpperCase().indexOf("GERENCIA_FUNC_COD_FK") != -1)
//				{	throw new Excecao(2, "Codigo de Funcionario duplicado.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na inclusão de uma Gerencia.");
					e.printStackTrace();
//					System.exit(1);			
//				}
//			}
//			else
//			{	e.printStackTrace();
//				System.exit(1);
//			} 
		}

		return 0;
	}

	public static boolean alterar (Connection conn, int cod_proj, int cod_func) 
		throws SQLException
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE GERENCIA SET PROJ_COD = ? WHERE FUNC_COD = ? ");
				
			pstmt.setInt	(1, cod_proj);	
			pstmt.setInt	(2, cod_func);
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("GERENCIA_PROJ_COD_FK") != -1)
//				{	throw new Excecao(1, "Codigo de Projeto duplicado.");
//				}
//				
//				else
//				{	System.out.println('\n' + "Erro na alteração de uma Gerencia.");
					e.printStackTrace();
//					System.exit(1);			
//				}
//			}
//			else
//			{	e.printStackTrace();
//				System.exit(1);
//			} 
//		}
	 }

		return n == 1;
	}


	public static boolean exclui (Connection conn, int cod_proj, int cod_func) 
	// throws Excecao <== É muito comum o método exclui gerar alguma  
	//                    exceção, no entanto, neste caso em particular 
	//                    nenhuma exceção é gerada.
	{		
		int n = 0;
				
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("DELETE FROM GERENCIA WHERE PROJ_COD = ? AND FUNC_COD = ?");
			
			pstmt.setInt (1, cod_proj);
			pstmt.setInt (1, cod_func);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de uma Gerencia.");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static GerenciaDeProjeto recuperaUmaGerencia(Connection conn, int cod_proj, int cod_func)
	{	GerenciaDeProjeto e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT PROJ_COD, FUNC_COD FROM GERENCIA " +
	 			 "WHERE PROJ_COD = ? AND FUNC_COD = ?"); 

			pstmt.setInt(1, cod_proj);
			pstmt.setInt(1, cod_func);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new GerenciaDeProjeto(rs.getInt("PROJ_COD"), rs.getInt("FUNC_COD"));
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