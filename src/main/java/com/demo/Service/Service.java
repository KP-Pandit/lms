package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.postgresql.util.LruCache.CreateAction;

import com.demo.Entity.Employee;

public interface Service {

	Employee createEmployee(Employee e);
	
	Optional<Employee> getEmpById(Integer id);
	
	Employee updateEmployee(Employee e);
	
	List<Employee> getAllEmployees();
	
	void deleteEmployee(Integer id);
	
	List<Employee> findPaginated(int pageSize, int pageNo);
}
