package com.demo.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Employee;
import com.demo.Service.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/cont")
public class ControllerApi {
	
	@Autowired
	private Service service;
	
	//@RequestMapping(method = RequestMethod.PUT,consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("insert")
	public ResponseEntity<Employee> createUser(@RequestBody Employee emp){
		System.out.println("Post method working ");
		Employee empl=service.createEmployee(emp);
			return ResponseEntity.ok().body(empl);
	
	}
	
	@GetMapping("/res")
	public ResponseEntity<String> test(){
		System.err.println("test method is called");
		return new ResponseEntity<>("hello it is from response entity",HttpStatus.OK);
	}
	
	@GetMapping("/page/{size}/{pageNo}")
	public List<Employee> getPagination(@PathVariable int size,@PathVariable int pageNo){
		return service.findPaginated(size, pageNo);
	}
}
