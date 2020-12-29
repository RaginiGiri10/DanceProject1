package com.raginigiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raginigiri.entity.Teacher_Panel_Entity;

@Repository
public interface Teacher_Panel_Repository extends JpaRepository<Teacher_Panel_Entity, Integer> {

}
