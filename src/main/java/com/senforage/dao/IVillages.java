package com.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senforage.entities.Villages;

@Repository
public interface IVillages extends JpaRepository<Villages, Integer> {

}
