package com.jogadavelha.model.jogodavelha;

import com.jogadavelha.model.User;

public class JogoDaVelhaOnline {

    public static void main(String[] args) {
        JogoOnline jogoOnline = new JogoOnline();
        User user = new User(1);
        user.setId(1);
        user.setLogin("victor.godoy");
        user.setPassword("x8pdkv19");
        
        User user2 = new User(2);
        user2.setId(2);
        user2.setLogin("denis.oliveira");
        user2.setPassword("12345678");
        
        jogoOnline.setJogador1(user);
        jogoOnline.setJogador2(user2);
        
        jogoOnline.Jogar(1, 3);
        
//        if(jogoOnline.verificaGanhador())
//        	jogoOnline.Jogar(1, 1);
//        
//        if(jogoOnline.verificaGanhador())
//        	jogoOnline.Jogar(3, 1);
//        
//        if(jogoOnline.verificaGanhador())
//        	jogoOnline.Jogar(2, 2);
//        
//        if(jogoOnline.verificaGanhador())
//        	jogoOnline.Jogar(3, 3);
//        
//        if(jogoOnline.verificaGanhador())
//        	jogoOnline.Jogar(3, 2);
//        
//        if(jogoOnline.verificaGanhador())
//        	jogoOnline.Jogar(2, 3);
//        
//        if(jogoOnline.verificaGanhador())
//        	jogoOnline.Jogar(1, 2);
    }
    
    
}