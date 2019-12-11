package com.jogadavelha.model.jogodavelha;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jogadavelha.model.User;

@JsonDeserialize(as = User.class)
public abstract class Jogador {
    
    protected int[] tentativa = new int[2];
    protected int jogador;

    public Jogador() {}
    public Jogador(int jogador){
        this.jogador = jogador;
    }
    
    public abstract void jogar(Tabuleiro tabuleiro);
    public abstract void jogar(Tabuleiro tabuleiro, int linha, int coluna);
    
    public abstract void Tentativa(Tabuleiro tabuleiro);
    public abstract void Tentativa(Tabuleiro tabuleiro, int linha, int coluna);

    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
            
    }
	public int[] getTentativa() {
		return tentativa;
	}
	public void setTentativa(int[] tentativa) {
		this.tentativa = tentativa;
	}
	public int getJogador() {
		return jogador;
	}
	public void setJogador(int jogador) {
		this.jogador = jogador;
	}
}