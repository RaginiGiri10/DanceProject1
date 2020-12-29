package com.raginigiri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raginigiri.entity.Student_Panel_Entity;
import com.raginigiri.repository.Student_Panel_Repository;
import com.raginigiri.util.DataNotFoundException;
import com.raginigiri.util.Response;

@Service
public class Student_Panel_Service {
	@Autowired
	private Student_Panel_Repository repository;

	public Response saveData(Student_Panel_Entity entity) {
		Response response = new Response();
		if (entity != null) {
			repository.save(entity);
			response.setMessage("00");
			response.setMessage("Data has been saved");
		} else {
			response.setMessage("00");
			response.setMessage("Data has not been saved");
		}
		return response;

	}

	public Response deleteData(int id) throws DataNotFoundException {
		Response response = new Response();
		Optional<Student_Panel_Entity> admin = repository.findById(id);
		if (admin.isPresent()) {
			repository.deleteById(id);
			response.setMessage("00");
			response.setMessage("Data has been deleted");
		} else {
			throw new DataNotFoundException("Data has not been found");
		}
		return response;
	}

	public Student_Panel_Entity getbyid(int id) throws DataNotFoundException {
		Optional<Student_Panel_Entity> studentId = repository.findById(id);
		if (studentId.isPresent()) {
			return repository.findById(id).get();
		} else {
			throw new DataNotFoundException("Data has not been found");
		}

	}

	public List<Student_Panel_Entity> getList() {
		
		return repository.findAll();
	}
}
