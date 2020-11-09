package com.senforage.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Villages implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVillage;
	
	@Column
	private String nomVillage;

	
	@OneToMany(mappedBy="village", fetch =FetchType.LAZY,targetEntity=Clients.class, cascade=CascadeType.ALL)
	private Collection<Clients>clients;

	public Villages() {
		super();
	}

	public Villages(int idVillage, String nomVillage) {
		super();
		this.idVillage = idVillage;
		this.nomVillage = nomVillage;
	}

	public int getIdVillage() {
		return idVillage;
	}

	public void setIdVillage(int idVillage) {
		this.idVillage = idVillage;
	}

	public String getNomVillage() {
		return nomVillage;
	}

	public void setNomVillage(String nomVillage) {
		this.nomVillage = nomVillage;
	}
	

}
