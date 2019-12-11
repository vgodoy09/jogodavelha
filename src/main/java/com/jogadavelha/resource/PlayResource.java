package com.jogadavelha.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogadavelha.exception.ResourceNotFoundException;
import com.jogadavelha.model.Play;
import com.jogadavelha.model.Rank;
import com.jogadavelha.model.User;
import com.jogadavelha.model.jogodavelha.JogoOnline;
import com.jogadavelha.repository.PlayRepository;
import com.jogadavelha.repository.RankRepository;
import com.jogadavelha.repository.UserRepository;
import com.jogadavelha.utils.CheckInstanceObject;

@RestController
@RequestMapping("/api")
public class PlayResource {
	
	@Autowired
	private PlayRepository playRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RankRepository rankRepository;
	
	public List<JogoOnline> list = new ArrayList<JogoOnline>();
	
	// Get All plays
	@GetMapping("/plays")
	public List<Play> getAllplays() {
	    return playRepository.findAll();
	}
	
	// Create a new Play
	@PostMapping("/plays")
	public Play createPlay(@Valid @RequestBody Play play) {
	    return playRepository.save(play);
	}
	
	// Get a Single Play
	@GetMapping("/plays/{id}")
	public Play getPlayById(@PathVariable(value = "id") Integer playId) {
	    return playRepository.findById(playId)
	            .orElseThrow(() -> new ResourceNotFoundException("Play", "id", playId));
	}
	
	// Update a Play
	@PutMapping("/plays/{id}")
	public Play updatePlay(@PathVariable(value = "id") Integer playId,
	                                        @Valid @RequestBody Play playDetails) {

	    Play play = playRepository.findById(playId)
	            .orElseThrow(() -> new ResourceNotFoundException("Play", "id", playId));

	    play.setName(playDetails.getName());

	    Play updatedPlay = playRepository.save(play);
	    return updatedPlay;
	}
	
	// Delete a Play
	@DeleteMapping("/plays/{id}")
	public ResponseEntity<?> deletePlay(@PathVariable(value = "id") Integer playId) {
	    Play play = playRepository.findById(playId)
	            .orElseThrow(() -> new ResourceNotFoundException("Play", "id", playId));

	    playRepository.delete(play);

	    return ResponseEntity.ok().build();
	}
	
	@PostMapping("/play/{linha}/{coluna}")
	public JogoOnline play(@PathVariable(value = "linha") int linha, @PathVariable(value = "coluna") int coluna, @Valid @RequestBody JogoOnline jogoOnline) {
		if(CheckInstanceObject.IsNull(jogoOnline))
			return null;
		jogoOnline.Jogar(linha, coluna);
		Integer verificaGanhador = jogoOnline.verificaGanhador();
		if(!CheckInstanceObject.IsNull(verificaGanhador)) {
			String message = "";
			if(verificaGanhador == 3) {
				message = "Tabuleiro Completo. Jogo empatado";
				
				User user = (User) jogoOnline.getJogador1();
				Integer uId = userRepository.getUser(user.getLogin());
				Rank rank = new Rank();
				rank.setUser_id(uId);
				rank.setPunctuation(1);
				rank.setPlay_id(1);
				
				rankRepository.save(rank);
				
				User user2 = (User) jogoOnline.getJogador2();
				Integer uId2 = userRepository.getUser(user2.getLogin());
				Rank rank2 = new Rank();
				rank2.setUser_id(uId2);
				rank2.setPunctuation(1);
				rank2.setPlay_id(1);
				rankRepository.save(rank2);
				
			} else if(verificaGanhador == 1) {
				User user = (User) jogoOnline.getJogador1();
				Integer uId = userRepository.getUser(user.getLogin());
				message = "Jogador "+user.getLogin()+" ganhou!";
				
				Rank rank = new Rank();
				rank.setUser_id(uId);
				rank.setPunctuation(3);
				rank.setPlay_id(1);
				
				rankRepository.save(rank);
				
//				User user2 = (User) jogoOnline.getJogador2();
//				Integer uId2 = userRepository.getUser(user2.getLogin());
//				Rank rank2 = new Rank();
//				rank2.setUser_id(uId2);
//				rank2.setPunctuation(-2);
//				rank2.setPlay_id(1);
//				rankRepository.save(rank2);
				
			} else if(verificaGanhador == 2) {
				User user = (User) jogoOnline.getJogador2();
				message = "Jogador "+user.getLogin()+" ganhou!";
				Integer uId = userRepository.getUser(user.getLogin());
				Rank rank = new Rank();
				rank.setUser_id(uId);
				rank.setPunctuation(3);
				rank.setPlay_id(1);
				
				rankRepository.save(rank);
				
//				User user1 = (User) jogoOnline.getJogador1();
//				Integer uId1 = userRepository.getUser(user1.getLogin());
//				Rank rank1 = new Rank();
//				rank1.setUser_id(uId1);
//				rank1.setPunctuation(-2);
//				rank1.setPlay_id(1);
//				rankRepository.save(rank1);
			}
			jogoOnline.setMessage(message);
		}
		
		updateJogo(jogoOnline);
		
		return jogoOnline;
	}
	
	@GetMapping("/addplay")
	public List<JogoOnline> addplay() {
		JogoOnline jogoOnline = new JogoOnline();
		jogoOnline.setId(list.size() + 1);
		list.add(jogoOnline);
		return list;
	}
	
//	@PostMapping("/updateplay")
//	public JogoOnline updateplay(@Valid @RequestBody JogoOnline jogoOnline) {
//		Optional<JogoOnline> findFirst = list.stream().filter(j -> j.getId().equals(jogoOnline.getId())).findFirst();
//		JogoOnline j = null;
//		if(!CheckInstanceObject.IsNull(findFirst) && findFirst.isPresent()) {
//			j = findFirst.get();
//			list.remove(j);
//			list.add(jogoOnline);
//		}
//		return jogoOnline;
//	}
//	
	@PostMapping("/updatedplay")
	public JogoOnline updatedplay(@Valid @RequestBody JogoOnline jogoOnline) {
		Optional<JogoOnline> findFirst = list.stream().filter(j -> j.getId().equals(jogoOnline.getId())).findFirst();
		if(!CheckInstanceObject.IsNull(findFirst) && findFirst.isPresent()) 
			return findFirst.get();
		return jogoOnline;
	}
	
	@GetMapping("/listplay")
	public List<JogoOnline> listplay() {
		return list;
	}
	
	@PostMapping("/player/{number}/{login}")
	public JogoOnline addplayer(@PathVariable(value = "number") int number, @PathVariable(value = "login") String login, @Valid @RequestBody JogoOnline jogoOnline) {
		if(CheckInstanceObject.IsNull(jogoOnline))
			jogoOnline = new JogoOnline();
		
		if(number == 1) {
			User user = new User(1);
	        user.setId(1);
	        user.setLogin(login);
			jogoOnline.setJogador1(user);
		} else {
			User user = new User(2);
			user.setId(2);
			user.setLogin(login);
			jogoOnline.setJogador2(user);
		}
		updateJogo(jogoOnline);
		
		return jogoOnline;
	}
	
	@PostMapping("/updateOnlyJogo")
	public JogoOnline update(@Valid @RequestBody JogoOnline jogoOnline) {
		updateJogo(jogoOnline);
		return jogoOnline;
	}

	private void updateJogo(JogoOnline jogoOnline) {
		JogoOnline jo = jogoOnline;
		Optional<JogoOnline> findFirst = list.stream().filter(j -> j.getId().equals(jo.getId())).findFirst();
		JogoOnline j = null;
		if(!CheckInstanceObject.IsNull(findFirst) && findFirst.isPresent()) {
			j = findFirst.get();
			list.remove(j);
			list.add(jogoOnline);
		}
	}
	
	

}
