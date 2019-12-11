package br.com.vgodoy.model;

public class Automovel {
	protected int potencia;
	protected int velocidade = 0;
	protected int velocidadeAntiga = 0;
	protected int velocidadeMaxima;
	protected int marcha;
	protected int marchaAntiga;
	protected int marchaMaxima;
	protected String nome;
	protected double torque = 6;
	
	public Automovel(int potencia, int velocidadeMaxima, int marchaMaxima, String nome) {
		this.potencia = potencia;
		this.velocidadeMaxima = velocidadeMaxima;
		this.marchaMaxima = marchaMaxima;
		this.nome = nome;
	}

	public void trocarDeMarcha() {
		if(this.marcha > 0) {
			if(this.marcha < this.marchaMaxima) {
				this.marchaAntiga = this.marcha;
				if(this.velocidade >= this.velocidadeAntiga) {
					this.marcha++;
					this.torque+=2;
				} else if(this.velocidade < this.velocidadeAntiga) { //reduzida
					this.marcha = this.marcha/2;
					this.torque = this.torque/2;
					this.velocidadeAntiga = this.velocidade;
				}
			}
		} else {
			this.marcha++;
		}
	}
	
	protected double calculoPorcentagemParaTrocaDeMarcha() {
		int resultado = this.velocidade;
		double percentual = 10.0  / 100.0;
		double porcentagem = resultado > 0 ? resultado * percentual : 1;
		return porcentagem;
	}
	
	public void acelerar() {
		if(this.marcha > 0) {
			double porcentagem = calculoPorcentagemParaTrocaDeMarcha();
			if(porcentagem <= torque || this.marcha > this.marchaAntiga || this.marcha == this.marchaMaxima) {
				
				this.marchaAntiga = this.marcha;
				this.velocidadeAntiga = this.velocidade;
				
				this.velocidade += this.potencia;
				
				if(this.velocidade > this.velocidadeMaxima)
					this.velocidade = this.velocidadeMaxima;
			}
		} else {
			this.velocidade = 0;
		}
	}

	public void frear() {
		this.velocidade = this.velocidade/2;
		if(this.velocidade < 0)
			this.velocidade = 0;
	}
	
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}
	public void setVelocidadeMaxima(int velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMarcha() {
		return marcha;
	}

	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}

	public int getMarchaMaxima() {
		return marchaMaxima;
	}

	public void setMarchaMaxima(int marchaMaxima) {
		this.marchaMaxima = marchaMaxima;
	}

	public int getVelocidadeAntiga() {
		return velocidadeAntiga;
	}

	public void setVelocidadeAntiga(int velocidadeAntiga) {
		this.velocidadeAntiga = velocidadeAntiga;
	}
}
