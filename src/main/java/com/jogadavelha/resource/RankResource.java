package com.jogadavelha.resource;

import java.util.ArrayList;
import java.util.List;

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
import com.jogadavelha.model.Rank;
import com.jogadavelha.model.dto.RankDTO;
import com.jogadavelha.repository.RankRepository;

@RestController
@RequestMapping("/api")
public class RankResource {
	
	@Autowired
	RankRepository rankRepository;
	
	// Get All ranks
	@GetMapping("/ranks")
	public List<Rank> getAllranks() {
	    return rankRepository.findAll();
	}
	
	// Create a new Rank
	@PostMapping("/ranks")
	public Rank createRank(@Valid @RequestBody Rank rank) {
	    return rankRepository.save(rank);
	}
	
	// Get a Single Rank
	@GetMapping("/ranks/{id}")
	public Rank getRankById(@PathVariable(value = "id") Integer rankId) {
	    return rankRepository.findById(rankId)
	            .orElseThrow(() -> new ResourceNotFoundException("Rank", "id", rankId));
	}
	
	@GetMapping("/ranksList")
	public List<RankDTO> listRank() {
		List<Object[]> listRank = rankRepository.listRank();
		ArrayList<RankDTO> ranks = new ArrayList<>();
		listRank.forEach( r -> {
			ranks.add(new RankDTO(r));
		});
		return ranks;
	}
	
	// Update a Rank
	@PutMapping("/ranks/{id}")
	public Rank updateRank(@PathVariable(value = "id") Integer rankId,
	                                        @Valid @RequestBody Rank rankDetails) {

	    Rank rank = rankRepository.findById(rankId)
	            .orElseThrow(() -> new ResourceNotFoundException("Rank", "id", rankId));

	    rank.setPunctuation(rankDetails.getPunctuation());

	    Rank updatedRank = rankRepository.save(rank);
	    return updatedRank;
	}
	
	// Delete a Rank
	@DeleteMapping("/ranks/{id}")
	public ResponseEntity<?> deleteRank(@PathVariable(value = "id") Integer rankId) {
	    Rank rank = rankRepository.findById(rankId)
	            .orElseThrow(() -> new ResourceNotFoundException("Rank", "id", rankId));

	    rankRepository.delete(rank);

	    return ResponseEntity.ok().build();
	}

}
