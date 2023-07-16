package com.demo.Reposity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.Entity.Employee;

public interface Repository extends CrudRepository<Employee, Integer>{

	
	
}
