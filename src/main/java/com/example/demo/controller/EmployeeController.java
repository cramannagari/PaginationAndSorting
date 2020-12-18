package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/getPages")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			  @RequestParam(defaultValue = "id") String sortBy) {
		
		List<EmployeeEntity> list = service.getAllEmployees(pageNo, pageSize,sortBy);
		
		System.out.println("pageNo=="+pageNo+" pageSize=="+pageSize);

		return new ResponseEntity<List<EmployeeEntity>>(list, HttpStatus.OK);
	}
}
