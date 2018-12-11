package trabalho.poo.controller;

public class Projeto {
	
	   private int cod;
	   private String cpf;
	   private String dataIni;
	   private String dataFim;
	   private Double valor;
	   
	   
	    public Projeto(int cod, String cpf, String dataIni, Double valor){
	        this.cod = cod;
	        this.cpf = cpf;
	        this.dataIni = dataIni;
		    this.valor = valor;
	    }

		public int getCod() {
			return cod;
		}

		public void setCod(int cod) {
			this.cod = cod;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getDataIni() {
			return dataIni;
		}

		public void setDataIni(String dataIni) {
			this.dataIni = dataIni;
		}

		public String getDataFim() {
			return dataFim;
		}

		public void setDataFim(String dataFim) {
			this.dataFim = dataFim;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}
  
	    
	}