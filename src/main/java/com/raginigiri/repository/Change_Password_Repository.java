package com.raginigiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raginigiri.entity.Change_Password_Entity;
import com.raginigiri.entity.Login_Entity;

@Repository
public interface Change_Password_Repository extends JpaRepository<Change_Password_Entity, Integer> {

	@Query("from Login_Entity where username=?1")
	Login_Entity gettingLoginDetails(String username);

}

