package com.jogadavelha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jogadavelha.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from \"user\" where login = ?1 and password = ?2", nativeQuery=true)
	public User logged(String login, String password);
	@Query(value="select id from \"user\" where login = ?1", nativeQuery=true)
	public Integer getUser(String login);
	
}
