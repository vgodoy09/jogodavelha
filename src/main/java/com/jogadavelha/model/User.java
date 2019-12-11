package com.jogadavelha.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jogadavelha.model.jogodavelha.Jogador;
import com.jogadavelha.model.jogodavelha.Tabuleiro;

@Entity
@Table(name = "\"user\"")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User extends Jogador implements Externalizable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="login")
	private String login;
	@Column(name="password")
	private String password;
	
	public User() {}
	public User(int jogador) {
		super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Humano' criado!");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(login);
		out.writeObject(password);
	}

	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer) in.readObject();
		login = (String) in.readObject();
		password = (String) in.readObject();
	}
	
	
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		 Tentativa(tabuleiro);
	     tabuleiro.setPosicao(tentativa, jogador);
		
	}
	
	@Override
	public void Tentativa(Tabuleiro tabuleiro) {
	}

	@Override
	public void Tentativa(Tabuleiro tabuleiro, int linha, int coluna) {
//		do{
//            do{
                System.out.print("Linha: ");
                tentativa[0] = linha;
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Linha inválida. É 1, 2 ou 3");
                
//            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
//            do{
                System.out.print("Coluna: ");
                tentativa[1] = coluna;
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                
//            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local já foi marcado. Tente outro.");
//        }while( !checaTentativa(tentativa, tabuleiro) );
		
	}

	@Override
	public void jogar(Tabuleiro tabuleiro, int linha, int coluna) {
		Tentativa(tabuleiro, linha, coluna);
        tabuleiro.setPosicao(tentativa, jogador);
	}
	
	
}
