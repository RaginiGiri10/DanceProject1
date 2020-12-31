package com.raginigiri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raginigiri.entity.Login_Entity;
import com.raginigiri.repository.Login_Repository;
import com.raginigiri.util.Response;

@Service
public class Login_Service {

	@Autowired
	private Login_Repository login_Repository;

	public Response savePassword(Login_Entity entity) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Response response = new Response();

		if (entity.getPassword() != null && entity.getUsername() != null) {
			String encodedPw = bCryptPasswordEncoder.encode(entity.getPassword());
			String username = entity.getUsername();

			Login_Entity login_Entity = new Login_Entity();
			login_Entity.setUsername(username);
			login_Entity.setPassword(encodedPw);
			login_Repository.save(login_Entity);
			response.setStatus("00");
			response.setMessage("Data has been saved");

		} else {

			response.setStatus("01");
			response.setMessage("Data has been not saved");
		}

		return response;

	}

	// 1224==1224
	// sum.equals(sums)
	public Response checkLogin(String username, String password) {
		Response response = new Response();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode(password);

		Login_Entity gettingLoginDetails = login_Repository.gettingLoginDetails(username);
		if (gettingLoginDetails != null) {
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
