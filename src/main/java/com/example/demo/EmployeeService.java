package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
	
	Employee2 findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Employee2> findAll();
	
	boolean existByID(Long id);
	
	Employee2 save(Employee2 e);
	
	Optional<Employee2> findByID(Long id);
	
	Employee2 saveSingleEmployee(Long id, Employee2 e);
	
	List<Employee2> findTop3ByOrderBySalaryDesc();

}
