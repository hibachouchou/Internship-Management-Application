package com.hiba.stage.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiba.stage.entities.Etudiant;



public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
