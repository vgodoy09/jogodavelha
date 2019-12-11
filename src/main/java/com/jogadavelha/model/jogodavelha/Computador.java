package com.jogadavelha.model.jogodavelha;
public class Computador extends Jogador{
    
    public Computador(int jogador){
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){
        
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        
    }

	@Override
	public void Tentativa(Tabuleiro tabuleiro, int linha, int coluna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jogar(Tabuleiro tabuleiro, int linha, int coluna) {
		// TODO Auto-generated method stub
		
	}
}