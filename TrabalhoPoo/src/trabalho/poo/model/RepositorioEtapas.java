package trabalho.poo.model;

import java.util.*;

import trabalho.poo.controller.Etapa;

import java.sql.*;

public class RepositorioEtapas
{	public static int incluir (Connection conn, int cod, int cod_proj, String inicio, String fim) 
		throws SQLException
	{	

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO ETAPAS (COD, PROJ_COD, DATA_INICIO, DATA_FIM) " +
	   			 "VALUES (?, ?, ?, ?)");
			pstmt.setInt (1, cod);
			pstmt.setInt	(2, cod_proj);	
			pstmt.setString (3, inicio);
			pstmt.setString (4, fim);

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("ETAPAS_COD_PK") != -1)
//				{	throw new Excecao(1, "Código já existente.");
//				}
//				
//				else
//				{	System.out.println('\n' + "Erro na inclusão de uma Etapa.");
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

	public static boolean alterar (Connection conn, int cod, int cod_proj, String inicio, String fim) 
		throws SQLException
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE ETAPAS SET DATA_INICIO = ?, DATA_FIM = ? WHERE COD = ? AND PROJ_COD = ?");
				
				
			pstmt.setString	(1, inicio);
			pstmt.setString	(2, fim);			
			pstmt.setInt	(3, cod);	
			pstmt.setInt	(4, cod_proj);	
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("ETAPAS_COD_PK") != -1)
//				{	throw new Excecao(1, "Código já existente.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na inclusão de uma Etapa.");
					e.printStackTrace();
//					System.exit(1);			
//				}
//			}
//			else
//			{	e.printStackTrace();
//				System.exit(1);
//			} 
		}

		return n == 1;
	}


	public static boolean excluir (Connection conn, int cod, int cod_proj) 
	// throws Excecao <== É muito comum o método exclui gerar alguma  
	//                    exceção, no entanto, neste caso em particular 
	//                    nenhuma exceção é gerada.
	{		
		int n = 0;
				
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("DELETE FROM ETAPAS WHERE COD = ? AND PROJ_COD = ?");
			
			pstmt.setInt (1, cod);
			pstmt.setInt (1, cod_proj);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de uma Etapa.");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static Etapa recuperaUmaEtapa(Connection conn, int cod, int cod_proj)
	{	Etapa e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT COD, PROJ_COD, DATA_INICIO, DATA_FIM FROM ETAPA " +
	 			 "WHERE COD = ? AND PROJ_COD = ?"); 

			pstmt.setInt(1, cod);
			pstmt.setInt(1, cod_proj);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Etapa(rs.getInt("COD"),
					              rs.getInt("PROJ_COD"),
								  rs.getString("DATA_INICIO"),
					              rs.getString("DATA_FIM"));
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