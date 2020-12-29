package com.raginigiri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raginigiri.entity.Admin_Panel_Entity;
import com.raginigiri.service.Admin_Panel_Service;
import com.raginigiri.util.Response;

@RestController
public class Admin_Panel_Controller {
	@Autowired
	private Admin_Panel_Service service;

	@PostMapping("/admin_panel/saveData")
	public Response saveData(@RequestBody Admin_Panel_Entity entity) {
		return service.saveData(entity);
		
	}

	@DeleteMapping("/danceProject/admin_panel/deleteData/{id}")
	public Response deleteData(@PathVariable int id) {
		return service.deleteData(id);
	}

	@GetMapping("/danceProject/admin_panel/getData/{id}")
	public Admin_Panel_Entity getbyid(@PathVariable int id) {
		return service.getbyid(id);
	}

}
