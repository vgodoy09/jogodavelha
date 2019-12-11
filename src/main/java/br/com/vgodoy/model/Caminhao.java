package br.com.vgodoy.model;

public class Caminhao extends Automovel{
	
	private boolean tacografo;

	public Caminhao(int potencia, int velocidadeMaxima, int marchaMaxima, int torque, String nome) {
		super(potencia, velocidadeMaxima, marchaMaxima, nome);
	}

	public boolean isTacografo() {
		return tacografo;
	}

	public void setTacografo(boolean tacografo) {
		this.tacografo = tacografo;
	}

	@Override
	public String toString() {
		return "Caminhao [tacografo=" + tacografo + ", potencia=" + potencia + ", velocidade=" + velocidade
				+ ", velocidadeAntiga=" + velocidadeAntiga + ", velocidadeMaxima=" + velocidadeMaxima + ", marcha="
				+ marcha + ", marchaAntiga=" + marchaAntiga + ", marchaMaxima=" + marchaMaxima + ", nome=" + nome
				+ ", torque=" + torque + "]";
	}

}
