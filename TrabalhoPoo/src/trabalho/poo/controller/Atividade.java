package trabalho.poo.controller;

import java.util.Calendar;

public class Atividade {
	
	private int codAtividade;
	private int codEtapa;
	private String dataIni;
	private String dataFim;
	
	
	public Atividade(int codAtividade, int codEtapa, String dataIni, String dataFim) {
		super();
		this.codAtividade = codAtividade;
		this.codEtapa = codEtapa;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
	}
	
	
	public int getCodAtividade() {
		return codAtividade;
	}
	public void setCodAtividade(int codAtividade) {
		this.codAtividade = codAtividade;
	}
	public int getCodEtapa() {
		return codEtapa;
	}
	public void setCodEtapa(int codEtapa) {
		this.codEtapa = codEtapa;
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
