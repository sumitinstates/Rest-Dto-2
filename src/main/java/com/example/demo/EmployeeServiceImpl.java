package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee2 findByFirstNameAndLastName(String firstName, String lastName) {

		Employee2 findByFirstNameAndLastName = employeeDao.findByFirstNameAndLastName(firstName, lastName);
		return findByFirstNameAndLastName;
	}

	@Override
	public List<Employee2> findAll() {
		List<Employee2> findAll = employeeDao.findAll();
		return findAll;
	}

	@Override
	public boolean existByID(Long id) {
		boolean existsById = employeeDao.existsById(id);
		return existsById;
	}

	@Override
	public Employee2 save(Employee2 e) {
		Employee2 employee2 = employeeDao.save(e);
		return employee2;
	}

	@Override
	public Optional<Employee2> findByID(Long id) {
		Optional<Employee2> findById = employeeDao.findById(id);
		return findById;
	}

	@Override
	public Employee2 saveSingleEmployee(Long id, Employee2 e) {
		Employee2 employee2 = employeeDao.save(e);
		return employee2;
	}

	@Override
	public List<Employee2> findTop3ByOrderBySalaryDesc() {
		List<Employee2> findTop3ByOrderBySalaryDesc = employeeDao.findTop3ByOrderBySalaryDesc();
		return findTop3ByOrderBySalaryDesc;
	}

}
