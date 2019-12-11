package br.com.vgodoy.model;

public class CarroAutomatico extends Automovel {

	private boolean pilotoAutomatico;

	public CarroAutomatico(int potencia, int velocidadeMaxima, int marchaMaxima, String nome, boolean pilotoAutomatico) {
		super(potencia, velocidadeMaxima, marchaMaxima, nome);
		this.pilotoAutomatico = pilotoAutomatico;
	}
	
	@Override
	public void trocarDeMarcha() {
		if(this.marcha > 0) {
			if(this.marcha < this.marchaMaxima) {
				this.marchaAntiga = this.marcha;
				if(this.velocidade >= this.velocidadeAntiga) {
					double porcentagem = calculoPorcentagemParaTrocaDeMarcha();
					if(porcentagem >= this.torque) {
						this.marcha++;
						this.torque+=2;
					}
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
	
	@Override
	public void acelerar() {
		if(pilotoAutomatico) {
			trocarDeMarcha();
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
		} else {
			super.acelerar();
		}
	}

	@Override
	public void frear() {
		if(this.pilotoAutomatico) {
			this.velocidade = this.velocidade/2;
			trocarDeMarcha();
			if(this.velocidade < 0)
				this.velocidade = 0;
		} else {
			super.frear();
		}
	}

	@Override
	public String toString() {
		return "CarroAutomatico [pilotoAutomatico=" + pilotoAutomatico + ", potencia=" + potencia + ", velocidade="
				+ velocidade + ", velocidadeAntiga=" + velocidadeAntiga + ", velocidadeMaxima=" + velocidadeMaxima
				+ ", marcha=" + marcha + ", marchaAntiga=" + marchaAntiga + ", marchaMaxima=" + marchaMaxima + ", nome="
				+ nome + ", torque=" + torque + "]";
	}

}
