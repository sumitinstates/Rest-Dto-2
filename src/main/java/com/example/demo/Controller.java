package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	EmployeeService es;
	
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public List<Employee2> getAllEmployee(){
		List<Employee2> allEmployee = es.findAll();
		return allEmployee;
	}
	
	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET,produces = {"application/json", "application/xml"} )
	public Optional<Employee2> getEmployeeById(@PathVariable Long id) {
		Optional<Employee2> findByID = es.findByID(id);
		return findByID;
	}
	
	@RequestMapping(value = "/saveAllEmployee", method = RequestMethod.POST, produces = {"application/json", "application/xml"} )
	public ResponseEntity<List<Employee2>> saveAllEmployee(@RequestBody List<Employee2> e){
		
		Employee2 employee = new Employee2();
		ArrayList<Employee2> al = new ArrayList<Employee2>();
		
		for(int i =0; i<e.size(); i++) 
		{
			Employee2 employee2 = e.get(i);
			boolean existByID = es.existByID(employee2.getId());
			
			if(!existByID) 
			{
				Employee2 findByFirstNameAndLastName = es.findByFirstNameAndLastName(employee2.getFirstName(), employee2.getLastName());
				
				if(findByFirstNameAndLastName==null) 
				{
					es.save(employee2);
				}
				else 
				{
					employee.setId(employee2.getId());
					employee.setFirstName(employee2.getFirstName() + "Already exist");
					employee.setLastName(employee2.getLastName() + "Already exist");	
				}
			}
			  al.add(employee2);	   
		}
		
		return new  ResponseEntity<List<Employee2>>(al,HttpStatus.OK);		
	}
	
    @RequestMapping( value = "/save/{id}", method = RequestMethod.POST, produces = {"application/json","application/xml"})
	public Employee2 saveEmployeeByID(@PathVariable Long id, @RequestBody Employee2 e){
		if(!es.existByID(id)) 
		{
			Employee2 saveEmployee = es.save(e);
			return saveEmployee;
		}
		return null;
	}
    
    @RequestMapping(value = "/findTop3", method = RequestMethod.GET, produces = "application/json")
    public List<Employee2> findTop3ByOrderBySalaryDesc(){
    	List<Employee2> findTop3ByOrderBySalaryDesc = es.findTop3ByOrderBySalaryDesc();
    	return findTop3ByOrderBySalaryDesc;
    }
}

