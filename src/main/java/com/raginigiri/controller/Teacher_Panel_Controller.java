package com.raginigiri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raginigiri.entity.Teacher_Panel_Entity;
import com.raginigiri.service.Teacher_Panel_Service;
import com.raginigiri.util.Response;

@RestController
public class Teacher_Panel_Controller {
	@Autowired
	private Teacher_Panel_Service service;

	@PostMapping("/saveData")
	public Response saveData(@RequestBody Teacher_Panel_Entity entity) {
		return service.saveData(entity);

	}

	@DeleteMapping("/danceProject/teacher_panel/deleteData/{id}")
	public Response deleteData(@PathVariable int id) {
		return service.deleteData(id);
	}

	@GetMapping("/danceProject/teacher_panel/getData/{id}")
	public Teacher_Panel_Entity getbyid(@PathVariable int id) {
		return service.getbyid(id);
	}

	@GetMapping("/danceProject/teacher_panel/getlist")
	public List<Teacher_Panel_Entity> getList() {
		return service.getList();
	}
}
