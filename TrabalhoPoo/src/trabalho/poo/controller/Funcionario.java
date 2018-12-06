package trabalho.poo.controller;


public class Funcionario {
	
	private String func;
    private String nome;
    private String telefone;
    private String endereco;

    public Funcionario(String func ,String nome, String telefone, String endereco) {
    	this.func = func;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    public String getFunc() {
		return func;
	}


	public void setFunc(String func) {
		this.func = func;
	}


	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}