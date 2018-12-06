package trabalho.poo.controller;

public class Clientes {
	
    private String CPF;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
  
    
    public Clientes(String CPF, String nome, String endereco, String telefone, String email){
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
       
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) throws ExcecaoClientes {
            this.CPF = CPF;
        
        System.out.println("CPF atualizado com sucesso");
        }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}