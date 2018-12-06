package trabalho.poo.model;

import java.util.*;

import trabalho.poo.controller.Projeto;

import java.sql.*;
import java.sql.Date;

public class RepositorioProjeto
{	public static int incluir (Connection conn, Projeto projeto) 
		throws SQLException
	{	

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO PROJETO (COD, CPF, DATA_INICIO, VALOR) " +
	   			 "VALUES (?, ?, ?, ?)");
			pstmt.setInt    (1, projeto.getCod());
			pstmt.setString	(2, projeto.getCpf());	
			pstmt.setString (3, projeto.getDataIni());
			pstmt.setDouble (4, projeto.getValor());
			

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("PROJETO_COD_PK") != -1)
//				{	throw new Excecao(1, "Código já existente.");
//				}
//				
//				else
//				{	System.out.println('\n' + "Erro na inclusão de um Projeto.");
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

	public static boolean alterar (Connection conn, int cod, String cpf, String inicio, String fim, double valor) 
		throws SQLException
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
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("PROJETO_COD_PK") != -1)
//				{	throw new Excecao(1, "Código já existente.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na inclusão de um Projeto.");
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
	{	Projeto e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT COD, CPF, DATA_INICIO, VALOR FROM PROJETO " +
	 			 "WHERE COD = ?"); 

			pstmt.setInt(1, cod);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Projeto(rs.getInt("COD"),
					              rs.getString("CPF"),
								  rs.getString("DATA_INICIO"),
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