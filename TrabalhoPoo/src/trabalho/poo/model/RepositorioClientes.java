import java.util.*;
import java.sql.*;

public class RepositorioClientes
{	public static int incluir (Connection conn, String cpf, String nome, String end, String tel, String email) 
		throws Excecao
	{		
		try
		{	PreparedStatement pstmt = conn.prepareStatement 
				("INSERT INTO CLIENTES (CPF, NOME, ENDERECO, TELEFONE, EMAIL) " +
	   			 "VALUES (?, ?, ?, ?)");
			pstmt.setString (1, cpf);
			pstmt.setString	(2, nome);	
			pstmt.setString (3, end );
			pstmt.setString	(4, tel);
			pstmt.setString	(5, email);

			pstmt.executeUpdate();
			pstmt.close();
		} 
		catch(SQLException e)
		{	
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("CLIENTES_CPF_PK") != -1)
				{	throw new Excecao(1, "CPF já existente.");
				}
				else if (e.getMessage().toUpperCase().indexOf("CLIENTES_NOME_UN") != -1)
				{	throw new Excecao(2, "Nome duplicado.");
				}
				else
				{	System.out.println('\n' + "Erro na inclusão de um Cliente.");
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

	public static boolean alterar (Connection conn, String cpf, String nome, String end, String tel, String email) 
		throws Excecao
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
			if(e.getSQLState().equals(Constantes.VIOLACAO_INDICE_UNICO))
			{	
				if (e.getMessage().toUpperCase().indexOf("CLIENTES_CPF_PK") != -1)
				{	throw new Excecao(1, "CPF já existente!");
				}
				else if (e.getMessage().toUpperCase().indexOf("CLIENTES_NOME_UN") != -1)
				{	throw new Excecao(2, "Nome duplicado.");
				}
				else
				{	System.out.println('\n' + "Erro na alteração do Cliente.");
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

	public static Cliente recuperaUmCliente(Connection conn, String cpf)
	{	Empregado e = null;

		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT NOME, ENDERECO,B TELEFONE, EMAIL FROM CLIENTES " +
	 			 "WHERE CPF = ?"); 

			pstmt.setString(1, cpf);
			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Empregado(rs.getString("CPF"),
					              rs.getString("NOME"), 
					              rs.getString("ENDERECO"), 
						          rs.getString("TELEFONE")
								  rs.getString("EMAIL"));
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