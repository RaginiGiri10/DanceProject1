package com.raginigiri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raginigiri.entity.Change_Password_Entity;
import com.raginigiri.repository.Change_Password_Repository;

@Service
public class Change_Password_Service {
	@Autowired
	private Change_Password_Repository repository;

	public String saveData(Change_Password_Entity entity) {
		repository.save(entity);
		return "Data has been saved";
	}

	public String deleteData(int id) {
		repository.deleteById(id);
		return "Data has been deleted";
	}

	public Optional<Change_Password_Entity> getbyid(int id) {
		Optional<Change_Password_Entity> data = repository.findById(id);
		return data;
	}

}
