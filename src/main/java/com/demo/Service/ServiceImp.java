package com.demo.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.demo.Entity.Employee;
import com.demo.Reposity.PaginationRepository;
import com.demo.Reposity.Repository;

import lombok.AllArgsConstructor;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceImp implements Service{
	
	@Autowired
	private Repository repository;
	
	@Autowired
	 private PaginationRepository paginationRepository;

	@Override
	public Employee createEmployee(Employee e) {
		return repository.save(e);
		
	}
	
	
	@Override
	public Employee updateEmployee(Employee e) {
		Employee emp=repository.findById(e.getId()).get();
		emp.setId(e.getId());
		emp.setEmail(e.getEmail());
		emp.setName(e.getName());
		Employee empUpdated=repository.save(emp);
		return empUpdated;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) repository.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Employee> getEmpById(Integer id) {

	return 	repository.findById(id);
		
	}

	@Override
	public List<Employee> findPaginated(int pageSize, int pageNo) {
		org.springframework.data.domain.Pageable pageable=PageRequest.of(pageNo, pageSize);
		Page<Employee> page=paginationRepository.findAll(pageable);
		return page.toList();
	}
	

}
