package com.raginigiri.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raginigiri.entity.Change_Password_Entity;
import com.raginigiri.service.Change_Password_Service;

@RestController
public class Change_Password_Controller {
	@Autowired
	private Change_Password_Service service;

	@PostMapping("/danceProject/changepassword_panel/saveData")
	public String saveData(@RequestBody Change_Password_Entity entity) {
		String saveData = service.saveData(entity);
		return saveData;
	}

	@DeleteMapping("/danceProject/changepassword_panel/deleteData{id}")
	public String deleteData(@PathVariable int id) {
		return service.deleteData(id);
	}

	@GetMapping("/danceProject/changepassword_panel/getData{id}")
	public Optional<Change_Password_Entity> getbyid(@PathVariable int id) {
		return service.getbyid(id);
	}
}
