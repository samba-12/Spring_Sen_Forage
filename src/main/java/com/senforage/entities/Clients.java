package com.senforage.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Clients implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	@Column
	private String prenom;
	@Column
	private String nom;
	@Column
	private String adresse;
	@Column
	private String telephone;

	@ManyToOne
	@JoinColumn (name="Villageid")
	private Villages village = new Villages();

	public Clients() {
		super();
	}
	public Clients(int idClient, String prenom, String nom, String adresse, String telephone, Villages village) {
		super();
		this.idClient = idClient;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Villages getVillage() {
		return village;
	}
	public void setVillage(Villages village) {
		this.village = village;
	}

	

	

}
