package com.jogadavelha.model.jogodavelha;

public class JogoOnline {
    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    private Integer id;
    private String message;

    
    public JogoOnline(){
        tabuleiro = new Tabuleiro();
    }
    
    public boolean Jogar(int linha, int coluna){
        System.out.println("----------------------");
        System.out.println("\nRodada "+rodada);
        System.out.println("É a vez do jogador " + vez() );
        
        if(vez()==1)
            jogador1.jogar(tabuleiro, linha, coluna);
        else
            jogador2.jogar(tabuleiro, linha, coluna);
        
        vez++;
        rodada++;

        return true;
    }
    
    public Integer verificaGanhador() {
    	if(ganhou() == 0 ) { 
    		if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return 3;
//                return "Tabuleiro Completo. Jogo empatado";
            }
    		return null;
    	} else {
    		String message = "";
    		Integer retorno = null;
	    	if(ganhou() == -1 ) {
	    		message = "Jogador 1 ganhou!";
	    		retorno = 1;
	    	} else { 
	           message = "Jogador 2 ganhou!";
	           retorno = 2;
	    	}
	        System.out.println(message);
	    	return retorno;
    	}
    	
    }
    
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public int getVez() {
		return vez;
	}

	public void setVez(int vez) {
		this.vez = vez;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}