package com.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senforage.entities.Responsables;

@Repository
public interface IResponsables extends JpaRepository<Responsables, Integer>{
	
	@Query("SELECT u FROM Responsables u WHERE u.email=:email AND u.password=:password")
	public Responsables getResponsablesByEmailAndPassword(@Param("email") String email,@Param("password") String password);

}
