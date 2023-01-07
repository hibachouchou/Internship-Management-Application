package com.hiba.stage.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
@Entity
public class Stage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStage;
	@NotNull
	private String typeStage ;
	@NotNull
	private String societe ;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date datedebStage;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date datefinStage;
	@NotNull
	@ManyToOne
	private Etudiant etudiant;
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Stage() {
		super();
		}

	public Stage(Long idStage,String typeStage,String societe,Date datedebStage,Date datefinStage) {
		super();
		this.idStage = idStage;
		this.typeStage = typeStage;
		this.societe = societe;
		this.datedebStage =datedebStage;
		this.datefinStage=datefinStage;
		}

	public Long getIdStage() {
		return idStage;
	}

	public void setIdStage(Long idStage) {
		this.idStage = idStage;
	}

	public String getTypeStage() {
		return typeStage;
	}

	public void setTypeStage(String typeStage) {
		this.typeStage = typeStage;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public Date getDatedebStage() {
		return datedebStage;
	}

	public void setDatedebStage(Date datedebStage) {
		this.datedebStage = datedebStage;
	}

	public Date getDatefinStage() {
		return datefinStage;
	}

	public void setDatefinStage(Date datefinStage) {
		this.datefinStage = datefinStage;
	}

	@Override
	public String toString() {
		return "Stage [idStage=" + idStage + ", typeStage=" + typeStage + ", societe=" + societe + ", datedebStage="
				+ datedebStage + ", datefinStage=" + datefinStage + "]";
	}


}
