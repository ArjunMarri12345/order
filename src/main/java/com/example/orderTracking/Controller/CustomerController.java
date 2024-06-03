package com.example.orderTracking.Controller;

import com.example.orderTracking.Entity.Customer;
import com.example.orderTracking.Repository.CustomerRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;





@RestController
@RequestMapping("/customer")
public class CustomerController {
	
    @Autowired
    CustomerRepo customerRepo;
    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){
    	try {
    	String mailString=customer.getEmail();
    	
    	if(mailString!=null) {
    		
    		customerRepo.save(customer);
    	}
    	else {
    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST," email canoot be null");
    	}}
    	catch(Exception e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"enter an email");
    	}
    }
    @GetMapping("/getAll")
    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }
    @DeleteMapping("/del/{id}")
    public void deleteCustomer(@PathVariable("id")int id) {
    	try {
    	List<Customer> customerid=customerRepo.findByCustomerId(id);
    	if(customerid!=null) {
    		customerRepo.deleteById(id);
    		}
    	else {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"enter an existing id");
    	}
    	
    }
    	catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id not present ");
		}
}}
