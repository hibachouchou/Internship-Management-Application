package com.hiba.stage.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtud;
	@NotNull
	private String nom_completEtud;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@NotNull
	private Date dateNaiss ;
	@NotNull
	private String groupe;
	@NotNull
	private String departement;
	@NotNull
	private String email ;
	@NotNull
	private Long num_tel;
	@JsonIgnore
	@OneToMany(mappedBy = "etudiant")
	private List<Stage> stages;

	public Etudiant(String nom_completEtud,Date dateNaiss ,String groupe,String departement ,String email,Long num_tel,List<Stage> stages) 
	{
	super();
	this.nom_completEtud=nom_completEtud;
	this.dateNaiss=dateNaiss;
	this.groupe=groupe;
	this.departement=departement;
	this.stages=stages;
	this.email=email;
	this.num_tel=num_tel;
	
	}
	public Long getIdEtud() {
		return idEtud;
	}
	public void setIdEtud(Long idEtud) {
		this.idEtud = idEtud;
	}
	public String getNomCompletEtud() {
		return nom_completEtud;
	}
	public void setNomCompletEtud(String nom_completEtud) {
		this.nom_completEtud = nom_completEtud;
	}
	
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public List<Stage> getStages() {
		return stages;
	}
	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumTel() {
		return num_tel;
	}
	public void setNumTel(Long num_tel) {
		this.num_tel=num_tel;
	}
}
