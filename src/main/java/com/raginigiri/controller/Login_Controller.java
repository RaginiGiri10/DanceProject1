package com.raginigiri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raginigiri.entity.Login_Entity;
import com.raginigiri.service.Login_Service;
import com.raginigiri.util.Response;

@RestController
public class Login_Controller {
	@Autowired
	private Login_Service service;

	@PostMapping("/danceProject/login_panel/saveData")
	public Response saveData(@RequestBody Login_Entity entity) {
		return service.savePassword(entity);
	}

}