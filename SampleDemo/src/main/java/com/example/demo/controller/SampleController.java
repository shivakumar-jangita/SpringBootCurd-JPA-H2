package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class SampleController {

	@Autowired
	EmployeeService service;

	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getAllEmployeeData() {
		List<EmployeeEntity> list = service.getAllEmployees();
		return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmpById(@PathVariable("id") Long id )
	{
		EmployeeEntity entity=service.getEmployeeById(id);
		
		return new ResponseEntity<EmployeeEntity>(entity,new HttpHeaders(),HttpStatus.OK);
	}
	 @PostMapping
	    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
	                                                   {
	        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
	        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/{id}")
	 public HttpStatus deleteById(@PathVariable("id") Long id)
	 {
		 service.deleteById(id);
		return HttpStatus.FORBIDDEN;
		 
	 }
}
