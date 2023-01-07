package com.hiba.stage.service;
import java.util.List;

import org.springframework.data.domain.Page;


import com.hiba.stage.entities.Etudiant;

public interface EtudiantService {

	Etudiant saveEtudiant(Etudiant etudiant);
	Etudiant updateEtudiant(Etudiant etudiant);
	void deleteEtudiant(Long id);
	List<Etudiant> getAllEtudiants();
	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
	Etudiant getEtudiant(Long id);

}





