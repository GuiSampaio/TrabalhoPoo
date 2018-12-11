package trabalho.poo.model;

import java.util.*;

import trabalho.poo.controller.Clientes;
import trabalho.poo.controller.Funcionario;

import java.sql.*;

public class RepositorioFuncionarios
{	public int incluir (Connection conn, Funcionario funcionario) 
		throws SQLException
	{		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO FUNCIONARIOS (COD, FUNC, NOME, ENDERECO, TELEFONE) " +
	   			 "VALUES (?, ?, ?, ?, ?)");
		Random r = new Random();
		int cod = r.nextInt(50000);
			cod+=10;
			
			pstmt.setInt	(1, cod);
			pstmt.setString (2, funcionario.getFunc());
			pstmt.setString	(3, funcionario.getNome());	
			pstmt.setString (4, funcionario.getEndereco());
			pstmt.setString	(5, funcionario.getTelefone());

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("FUNCIONARIOS_COD_PK") != -1)
//				{	throw new Excecao(1, "CPF já existente.");
//				}
//				else if (e.getMessage().toUpperCase().indexOf("FUNCIONARIOS_NOME_UN") != -1)
//				{	throw new Excecao(2, "Nome duplicado.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na inclusão de um Funcionário.");
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

	public static boolean alterar (Connection conn, String cpf, String nome, String end, String tel) 
		throws SQLException
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE FUNCIONARIOS SET NOME = ?, ENDERECO = ? , TELEFONE = ? WHERE CPF = ?");
				
			pstmt.setString	(1, nome);	
			pstmt.setString	(2, end);	
			pstmt.setString	(3, tel);
			pstmt.setString	(4, cpf);	
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("FUNCIONARIOS_COD_PK") != -1)
//				{	throw new Excecao(1, "CPF já existente!");
//				}
//				else if (e.getMessage().toUpperCase().indexOf("FUNCIONARIOS_NOME_UN") != -1)
//				{	throw new Excecao(2, "Nome duplicado.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na alteração do Funcionário.");
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


	public static boolean exclui (Connection conn, String cpf) 
	// throws Excecao <== É muito comum o método exclui gerar alguma  
	//                    exceção, no entanto, neste caso em particular 
	//                    nenhuma exceção é gerada.
	{		
		int n = 0;
				
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("DELETE FROM FUNCIONARIOS WHERE CPF = ?");
			
			pstmt.setString (1, cpf);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de um Funcionário.");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static Funcionario recuperaUmFuncionario(Connection conn, String cpf)
	{	Funcionario e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT NOME, ENDERECO,B TELEFONE FROM FUNCIONARIOS " +
	 			 "WHERE CPF = ?"); 

			pstmt.setString(1, cpf);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Funcionario(
	 								
	 							  rs.getString("FUNC"),
					              rs.getString("NOME"), 
					              rs.getString("ENDERECO"), 
						          rs.getString("TELEFONE"));
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