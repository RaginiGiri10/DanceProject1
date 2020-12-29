package com.raginigiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raginigiri.entity.Student_Panel_Entity;

@Repository
public interface Student_Panel_Repository extends JpaRepository<Student_Panel_Entity, Integer> {

}
