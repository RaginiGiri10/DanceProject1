package com.raginigiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raginigiri.entity.Login_Entity;

@Repository
public interface Login_Repository extends JpaRepository<Login_Entity, Integer> {

}
