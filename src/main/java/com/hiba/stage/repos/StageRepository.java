package com.hiba.stage.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hiba.stage.entities.Etudiant;
import com.hiba.stage.entities.Stage;

public interface StageRepository extends JpaRepository<Stage, Long> {
	
	

	@Query("select s from Stage s where s.typeStage like %:keyword% ")
	List<Stage> findByTypeStage(@Param("keyword")String keyword);
	@Query("select s from Etudiant e  ,Stage s  where s.etudiant=e.idEtud and e.nom_completEtud like %:keyword% ")
	List<Stage> findBynomEtudiant(@Param("keyword")String keyword); 
	
}