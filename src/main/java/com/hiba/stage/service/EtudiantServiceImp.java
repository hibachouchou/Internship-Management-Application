package com.hiba.stage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hiba.stage.entities.Etudiant;
import com.hiba.stage.repos.EtudiantRepository;

@Service
public class EtudiantServiceImp implements EtudiantService {
	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public Etudiant saveEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);

	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public void deleteEtudiant(Long id) {
		 etudiantRepository.deleteById(id);
		
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
		return etudiantRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

}
