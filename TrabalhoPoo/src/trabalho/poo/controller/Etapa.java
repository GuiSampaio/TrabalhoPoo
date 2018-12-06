package trabalho.poo.controller;

import java.util.Calendar;

public class Etapa {
	
	private int cod;
	private int projCod;
	private String dataIni; 
	private String dataFim;
	
	public Etapa(int cod, int projCod, String dataIni, String dataFim) {
		super();
		this.cod = cod;
		this.projCod = projCod;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getProjCod() {
		return projCod;
	}

	public void setProjCod(int projCod) {
		this.projCod = projCod;
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
