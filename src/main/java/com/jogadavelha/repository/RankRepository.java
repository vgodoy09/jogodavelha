package com.jogadavelha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jogadavelha.model.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Integer> {
	
	@Query(value=
			"SELECT ROW_NUMBER () OVER (ORDER BY tb.punctuation desc) id, * FROM ( " +
			"SELECT                                                                " +
			"	sum(punctuation) punctuation, u.login                              " +
			"FROM public.rank r                                                    " +
			"	inner join public.user u on u.id = r.user_id                       " +
			"where r.play_id = 1                                                   " +
			"group by u.login                                                      " +
			") as tb                                                               "
			, nativeQuery=true)
	public List<Object[]> listRank();
	
}
