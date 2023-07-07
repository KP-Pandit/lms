package com.demo;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.repository.CrudRepository;

import com.demo.Entity.Employee;
import com.demo.Reposity.Repository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext cotext = SpringApplication.run(Application.class, args);                     
		Repository repository=cotext.getBean(Repository.class);
		
		// save one object
		Employee employee=new Employee();
		employee.setId(1);
		employee.setEmail("krishna02@gmail,com");
		employee.setName("kp");
		Employee employee2= repository.save(employee);
		System.out.println(employee2);
		
		
		// to save multiple objects
		Employee emp=new  Employee();
		emp.setId(23);;
		emp.setEmail("vimal@gmail.com");
		emp.setName("vimal");
		
		Employee emp1=new  Employee();
		emp1.setId(45);;
		emp1.setEmail("rityu@gmail.com");
		emp1.setName("ritu");
		
		List< Employee> el=List.of(emp,emp1);
		
		
		
		
		Iterable iterable=repository.saveAll(el);
		iterable.forEach(i->System.out.println(i));
		
		// if you want to find the object from db 
	Optional<Employee> empo	=repository.findById(1);
	System.out.println(empo);
	
		// if you want to find all object from db
	
	List<Employee> emplo=(List<Employee>) repository.findAll();
       emplo.stream().forEach(i->System.out.println(i.getEmail()));
       // just to delete record by id
       repository.deleteById(252);
		
		
	}

}
