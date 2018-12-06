package trabalho.poo.controller;

public class GerenciaDeProjeto {

	private Funcionario funcionario;
	private Projeto projeto;
	
	
	public GerenciaDeProjeto(int projCod, int funcCod) {
		super();
		this.projeto.setCod(projCod);
	}
	


	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	
	
}
