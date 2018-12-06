package trabalho.poo.model;

import java.util.*;

import trabalho.poo.controller.Clientes;

import java.sql.*;

public class RepositorioClientes
{	public int incluir (Connection conn, Clientes clientes) 
		throws SQLException
	{		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO CLIENTES (CPF, NOME, ENDERECO, TELEFONE, EMAIL) " +
	   			 "VALUES (?, ?, ?, ?)");
			pstmt.setString (1, clientes.getCPF());
			pstmt.setString	(2, clientes.getNome());	
			pstmt.setString (3, clientes.getEndereco());
			pstmt.setString	(4, clientes.getTelefone());
			pstmt.setString	(5, clientes.getEmail());

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("CLIENTES_CPF_PK") != -1)
//				{	throw new Excecao(1, "CPF já existente.");
//				}
//				else if (e.getMessage().toUpperCase().indexOf("CLIENTES_NOME_UN") != -1)
//				{	throw new Excecao(2, "Nome duplicado.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na inclusão de um Cliente.");
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

	public static boolean alterar (Connection conn, String cpf, String nome, String end, String tel, String email) 
		throws SQLException
	{		
		int n = 0;

		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("UPDATE CLIENTES SET NOME = ?, ENDERECO = ? , TELEFONE = ?, EMAIL = ? WHERE CPF = ?");
				
			pstmt.setString	(1, nome);	
			pstmt.setString	(2, end);	
			pstmt.setString	(2, tel);	
			pstmt.setString	(3, email);	
			pstmt.setString	(5, cpf);	
				
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	
//			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
//			{	
//				if (e.getMessage().toUpperCase().indexOf("CLIENTES_CPF_PK") != -1)
//				{	throw new Excecao(1, "CPF já existente!");
//				}
//				else if (e.getMessage().toUpperCase().indexOf("CLIENTES_NOME_UN") != -1)
//				{	throw new Excecao(2, "Nome duplicado.");
//				}
//				else
//				{	System.out.println('\n' + "Erro na alteração do Cliente.");
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
				("DELETE FROM CLIENTES WHERE CPF = ?");
			
			pstmt.setString (1, cpf);
			n = pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e)
		{	System.out.println ('\n' + "Erro na exclusão de um Cliente.");
			e.printStackTrace();
			System.exit(1);
		}	

		return n == 1;
	}

	public static Clientes recuperaUmCliente(Connection conn, String cpf)
	{	Clientes e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT NOME, ENDERECO,B TELEFONE FROM FUNCIONARIOS " +
	 			 "WHERE CPF = ?"); 

			pstmt.setString(1, cpf);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Clientes(rs.getString("CPF"),
					              rs.getString("NOME"), 
					              rs.getString("ENDERECO"), 
						          rs.getString("TELEFONE"),
						          rs.getString("EMAIL")
						          );
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