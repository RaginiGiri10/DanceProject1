package com.raginigiri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raginigiri.entity.Teacher_Panel_Entity;
import com.raginigiri.repository.Teacher_Panel_Repository;
import com.raginigiri.util.Response;

@Service
public class Teacher_Panel_Service {
	@Autowired
	private Teacher_Panel_Repository repository;

	public Response saveData(Teacher_Panel_Entity entity) {
		Response response = new Response();
		if (entity != null) {
			repository.save(entity);
			response.setMessage("00");
			response.setMessage("Data has been saved");
		} else {
			response.setMessage("00");
			response.setMessage("Data has not been found");
		}
		return response;
	}

	public Response deleteData(int id) {
		Response response = new Response();
		Optional<Teacher_Panel_Entity> admin = repository.findById(id);
		if (admin.isPresent()) {
			repository.deleteById(id);
			response.setMessage("00");
			response.setMessage("Data has been deleted");
		} else {
			response.setMessage("00");
			response.setMessage("Data has not been deleted");
		}
		return response;
	}

	public Teacher_Panel_Entity getbyid(int id) {
		Teacher_Panel_Entity teacher_Panel_Entity = new Teacher_Panel_Entity();
		Response response = new Response();

		Optional<Teacher_Panel_Entity> admin = repository.findById(id);
		if (admin.isPresent()) {
			response.setMessage("00");
			response.setMessage("Data has been found");
		} else {
			response.setMessage("00");
			response.setMessage("Data has not been found");

		}
		return teacher_Panel_Entity;
	}

	public List<Teacher_Panel_Entity> getList() {
		return repository.findAll();
	}
}
