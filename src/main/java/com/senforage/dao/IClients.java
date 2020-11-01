package com.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senforage.entities.Clients;

@Repository
public interface IClients extends JpaRepository<Clients, Integer> {

}
