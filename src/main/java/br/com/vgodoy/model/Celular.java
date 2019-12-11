package br.com.vgodoy.model;

public class Celular {
	
	private int processador;
	private int memoria;
	private String modelo;
	private boolean ligado;
	
	
	public int getProcessador() {
		return processador;
	}
	public void setProcessador(int processador) {
		this.processador = processador;
	}
	public int getMemoria() {
		return memoria;
	}
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	
	public void ligar() {
		if(!isLigado())
			setLigado(true);
		else
			setLigado(false);
	}
}
