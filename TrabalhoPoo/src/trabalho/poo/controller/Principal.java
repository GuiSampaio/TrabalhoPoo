package trabalho.poo.controller;

import corejava.*;
	
public class Principal {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Clientes umCliente;
        int opcao = 0;   
       final int TAM = 10;
		ListaDeObjetos<Clientes>  listaDeClientes = new ListaDeObjetos<Clientes>(TAM);
   
   boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "==============================================================");
			System.out.println('\n' + "O que voc� deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um Cliente");
			System.out.println("2. Alterar Dados do Cliente");
			System.out.println("3. Cadastrar Projeto");
			System.out.println("4. -FAZER-");
			System.out.println("5. -FAZER-");
			System.out.println("6. -FAZER-");
						
		opcao = Console.readInt("\nDigite um n�mero entre 1 e 6:");
                
                switch (opcao){
                    case 1:
                  String nome = Console.readLine("Insira seu nome:\n");                     
                     
                  String cpf = Console.readLine("Insira seu CPF:\n");
                     
                  String telefone = Console.readLine("Insira telefone:\n");
                     
                  String email = Console.readLine("Insira seu email:\n");
                     
                  String endereco = Console.readLine("Insira seu Endere�o\n");   

                     try{
                    	 
                    	 umCliente = new Clientes(cpf, nome, endereco, telefone);    
                    	 listaDeClientes.adicionar(umCliente);
                     
                     }
                     catch(Exception e){
                   
                         System.out.println(e.getMessage());
                         
                     }       
                    case 2:
                    	int resposta = Console.readInt('\n' + "Digite o CPF do Cliente que voc� deseja alterar: ");
						
    					umCliente = listaDeClientes.recuperar(resposta);
    					
                    	System.out.println('\n' + "==============================================================");
            			System.out.println('\n' + "O que voc� deseja fazer?");
            			System.out.println('\n' + "1. Alterar CPF");
            			System.out.println("2. Alterar Nome");
            			System.out.println("3. Alterar Endereco");
            			System.out.println("4. Alterar Telefone");
            			System.out.println("5. Alterar E-mail");
                    int resp = Console.readInt("Insira sua op��o");
                
                    switch(resposta){
                    case 1: 
                    { String novoNome = Console.readLine("Insira o novo nome\n");
                      umCliente.setNome(novoNome);
                      System.out.println('\n' + "Altera��o de nome efetuada com sucesso!");						
					 break;
                    }
                    case 2:
                    	int novoCPF = Console.readInt("Insira o novo CPF\n");
                    	try {
                    	umCliente.setCPF(novoCPF);
                          	}
                    	catch(ExcecaoClientes e)
							{	System.out.println(e.getMessage());
							}
                    	
                    case 3:
                    { String novoEnd = Console.readLine("Insira o novo endere�o\n");
                    umCliente.setEndereco(novoEnd);
                    System.out.println('\n' + "Altera��o de endere�o efetuada com sucesso!");						
					 break;
                  }
                    case 4:
                    { int novoTel = Console.readInt("Insira o novo Telefone\n");
                    umCliente.setTelefone(novoTel);
                    System.out.println('\n' + "Altera��o de Telefone efetuada com sucesso!");						
					 break;
                  }
                    case 5:
                    { String novoEmail = Console.readLine("Insira o novo email\n");
                    umCliente.setEmail(novoEmail);
                    System.out.println('\n' + "Altera��o de E-mail efetuada com sucesso!");						
					 break;
                  }
                    	}
                    }
                
                
                }
		}
   }
