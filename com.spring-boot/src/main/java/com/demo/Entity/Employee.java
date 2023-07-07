package com.demo.Entity;

import java.io.Serializable;
import java.util.Comparator;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Employee implements Serializable ,Comparator<Employee>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Employee() {
		super();
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getName().compareTo(o2.getName())!=0){
			return o1.getName().compareTo(o2.getName());
		}
		else {
			if(o1.getEmail().compareTo(o1.getEmail())!=0) {
				return o1.getEmail().compareTo(o2.getEmail());
				
			}
			else {
				return o1.getId()-o2.getId();
			}
		}
		
	}
	
}
