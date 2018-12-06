package trabalho.poo.controller;

import java.util.Calendar;

public class Alocado {
	
	private int    codFunc;
	private int    codAtiv;
	private String funcao;
	private String dataIni;
	private String dataFim;
	
	
	public Alocado(int codFunc, int codAtiv, String funcao) {
		this.codFunc = codFunc;
		this.codAtiv = codAtiv;
		this.funcao  = funcao;
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
	
	

}
