package com.jogadavelha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jogadavelha.model.Play;

@Repository
public interface PlayRepository extends JpaRepository<Play, Integer> {
	
}
