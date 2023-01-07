package com.hiba.stage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hiba.stage.entities.Etudiant;
import com.hiba.stage.entities.Stage;
import com.hiba.stage.repos.StageRepository;

@Service
public class StageServiceImp  implements StageService  {

	@Autowired
	StageRepository stageRepository;

	@Override
	public Stage saveStage(Stage s) {
		return stageRepository.save(s);

	}

	@Override
	public Stage updateStage(Stage s) {
		return stageRepository.save(s);

	}

	@Override
	public void deleteStage(Stage s) {
		stageRepository.delete(s);

		
	}

	@Override
	public void deleteStageById(Long id) {
		stageRepository.deleteById(id);
		
	}

	@Override
	public Stage getStage(Long id) {
		return stageRepository.findById(id).get();

	}

	@Override
	public List<Stage> getAllStages() {
		return stageRepository.findAll();

	}

	@Override
	public Page<Stage> getAllStagesParPage(int page, int size) {
		return stageRepository.findAll(PageRequest.of(page, size));

	}

	@Override
	public List<Stage> findByTypeStage(String keyword) {
		if(keyword!=null) {
		return stageRepository.findByTypeStage(keyword);
	}
		return (List<Stage>)stageRepository.findAll();
		}

	@Override
	public List<Stage> findBynomEtudiant(String keyword) {
		if(keyword!=null) {
			return stageRepository.findBynomEtudiant(keyword);
			}
			return (List<Stage>)stageRepository.findAll();
	}



	

}
