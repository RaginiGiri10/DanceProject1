package com.raginigiri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raginigiri.entity.Admin_Panel_Entity;
import com.raginigiri.repository.Admin_Panel_Repository;
import com.raginigiri.util.DataNotFoundException;
import com.raginigiri.util.Response;

@Service
public class Admin_Panel_Service {
	@Autowired
	private Admin_Panel_Repository repository;

	public Response saveData(Admin_Panel_Entity entity) {
		Response response = new Response();
		if (entity != null) {
			repository.save(entity);
			response.setMessage("00");
			response.setMessage("The Data has been saved");
		} else {
			response.setMessage("00");
			response.setMessage("The Data has not been saved");
		}

		return response;
	}

	public Response deleteData(int id) {
		Response response = new Response();
		Optional<Admin_Panel_Entity> admin = repository.findById(id);
		if (admin.isPresent()) {
			repository.deleteById(id);
			response.setMessage("00");
			response.setMessage("The Data has been Deleted");
		} else {
			response.setMessage("00");
			response.setMessage("The Data has not been found");
		}

		return response;
	}

	public Admin_Panel_Entity getbyid(int id) throws DataNotFoundException {

		Optional<Admin_Panel_Entity> admin = repository.findById(id);
		if (admin.isPresent()) {
			return repository.findById(id).get();
		} else {
			throw new DataNotFoundException("Given id is not present");
		}

	}

	public List<Admin_Panel_Entity> getList() {

		return repository.findAll();
	}
}
