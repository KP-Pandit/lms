package com.demo.Reposity;

import org.springframework.data.repository.CrudRepository;

import com.demo.Entity.Employee;

public interface Repository extends CrudRepository<Employee, Integer>{

	Employee save(Employee employee);



	
	
}
