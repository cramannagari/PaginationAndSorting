package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by("id").descending());

		Page<EmployeeEntity> pagedResult = repository.findAll(paging);

		System.out.println("pagedResult=="+pagedResult.toString());
		
		
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}
}
