package com.demo.Reposity;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.Entity.Employee;

public interface PaginationRepository extends PagingAndSortingRepository<Employee, Integer> {

}
