package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee2, Long> {
	
	public Employee2 findByFirstNameAndLastName(String firstName, String lastName);
	
    public List<Employee2> findTop3ByOrderBySalaryDesc();

}
