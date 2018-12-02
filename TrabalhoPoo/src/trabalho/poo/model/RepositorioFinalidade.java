import java.util.*;
import java.sql.*;

public class RepositorioFinalidade
{	public static int incluir (Connection conn, int cod_cargo, int cod_func, Date inicio, Date fim) 
		throws Excecao
	{		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO FINALIDADE (CARGO_COD, FUNC_COD, DATA_INICIO, DATA_FIM) " +
	   			 "VALUES (?, ?,  ?, ?, ?)");
			pstmt.setInt (1, cod_cargo);
			pstmt.setInt (2, cod_func);
			pstmt.setString (3, inicio);
			pstmt.setString (4, fim);
	

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("FINALIDADE_CARGO_COD_FK") != -1)
				{	throw new Excecao(1, "Codigo de Cargo duplicado.");
				}
				else if (e.getMessage().toUpperCase().indexOf("FINALIDADE_FUNC_COD_FK") != -1)
				{	throw new Excecao(2, "Codigo de Funcionario duplicado.");
				}
				else
				{	System.out.println('\n' + "Erro na inclusão de uma Finalidade(Cargo/Funcionario).");
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

	public static boolean alterar (Connection conn, int cod_cargo, int cod_func, Date inicio, Date fim) 
		throws Excecao
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE FINALIDADE SET DATA_INICIO = ?, DATA_FIM = ? WHERE CARGO_COD = ? AND FUNC_COD = ?");
			
			pstmt.setString	(1, inicio);	
			pstmt.setString	(2, fim);
			pstmt.setInt	(3, cod_cargo);
			pstmt.setInt	(4, cod_func);	
			
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("FINALIDADE_CARGO_COD_FK") != -1)
				{	throw new Excecao(1, "Codigo de Cargo duplicado.");
				}
				else if (e.getMessage().toUpperCase().indexOf("FINALIDADE_FUNC_COD_FK") != -1)
				{	throw new Excecao(2, "Codigo de Funcionario duplicado.");
				}
				else
				{	System.out.println('\n' + "Erro na inclusão de uma Finalidade(Cargo/Funcionario).");
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


	public static boolean exclui (Connection conn, int cod_cargo, int cod_func) 
	// throws Excecao <== É muito comum o método exclui gerar alguma  
	//                    exceção, no entanto, neste caso em particular 
	//                    nenhuma exceção é gerada.
	{		
		int n = 0;
				
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("DELETE FROM FINALIDADE WHERE CARGO_COD = ? AND FUNC_COD = ?");
			
			pstmt.setInt (1, cod_cargo);
			pstmt.setInt (1, cod_func);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de uma Finalidade(Cargo/Funcionario).");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static Cliente recuperaUmaFinalidade(Connection conn, int cod_cargo, int cod_func)
	{	Empregado e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT CARGO_COD, FUNC_COD, DATA_INICIO, DATA_FIM FROM FINALIDADE " +
	 			 "WHERE CARGO_COD = ? AND FUNC_COD = ?"); 

			pstmt.setInt(1, cod_cargo);
			pstmt.setInt(1, cod_func);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Empregado(rs.getInt("CARGO_COD"),
					              rs.getInt("FUNC_COD"),
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