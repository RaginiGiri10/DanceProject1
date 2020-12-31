package com.raginigiri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raginigiri.entity.Change_Password_Entity;
import com.raginigiri.entity.Login_Entity;
import com.raginigiri.repository.Change_Password_Repository;
import com.raginigiri.util.Response;

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

	public Response changePassword(String username, String password) {
		Response response = new Response();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode(password);

		Login_Entity gettingLoginDetails = repository.gettingLoginDetails(username);
		if (encode.equals(gettingLoginDetails.getPassword())) {
			if (username != null) {
				response.setStatus("00");
				response.setMessage("You are verified");
			} else {
				response.setStatus("01");
				response.setMessage("Credentials are not valid");
			}
		}
		return response;

	}
}