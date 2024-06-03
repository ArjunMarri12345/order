package com.example.orderTracking.Repository;

import com.example.orderTracking.Entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>  {
	List<Customer> findByCustomerId(int id);
    
}
