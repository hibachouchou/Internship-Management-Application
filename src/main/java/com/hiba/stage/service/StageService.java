package com.hiba.stage.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hiba.stage.entities.Etudiant;
import com.hiba.stage.entities.Stage;

public interface StageService {
	Stage saveStage(Stage s);
	Stage updateStage(Stage s);
	void deleteStage(Stage s);
	 void deleteStageById(Long id);
	 Stage getStage(Long id);
	List<Stage> getAllStages();
	Page<Stage> getAllStagesParPage(int page, int size);
	List<Stage> findByTypeStage(String keyword);
	List<Stage> findBynomEtudiant(String keyword);

}
