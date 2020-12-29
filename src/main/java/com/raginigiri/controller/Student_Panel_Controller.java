package com.raginigiri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raginigiri.entity.Student_Panel_Entity;
import com.raginigiri.service.Student_Panel_Service;
import com.raginigiri.util.DataNotFoundException;
import com.raginigiri.util.Response;

@RestController
public class Student_Panel_Controller {
	@Autowired
	private Student_Panel_Service service;

	@PostMapping("/danceProject/student_panel/saveData")
	public Response saveData(@RequestBody Student_Panel_Entity entity) {
		return service.saveData(entity);
	}

	@DeleteMapping("/danceProject/student_panel/deleteData/{id}")
	public Response deleteData(@PathVariable int id) throws DataNotFoundException {
		return service.deleteData(id);
	}

	@GetMapping("/danceProject/student_panel/getData/{id}")
	public Student_Panel_Entity getbyid(@PathVariable int id) throws DataNotFoundException {
		return service.getbyid(id);
	}

	@GetMapping("/danceProject/student_panel/getlist")
	public List<Student_Panel_Entity> getList() {
		return service.getList();
	}
}
