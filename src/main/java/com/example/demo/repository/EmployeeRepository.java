package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long> {

	public Page<EmployeeEntity> findAll();

}
