package br.com.vgodoy.model;

public class Carro extends Automovel {


	public Carro(int potencia, int velocidadeMaxima, int marchaMaxima, String nome) {
		super(potencia, velocidadeMaxima, marchaMaxima, nome);
	}
	
	@Override
	public String toString() {
		return "Carro [potencia=" + potencia + ", velocidade=" + velocidade + ", velocidadeAntiga=" + velocidadeAntiga
				+ ", velocidadeMaxima=" + velocidadeMaxima + ", marcha=" + marcha + ", marchaAntiga=" + marchaAntiga
				+ ", marchaMaxima=" + marchaMaxima + ", nome=" + nome + ", torque=" + torque + "]";
	}
}
