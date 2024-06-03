package com.example.orderTracking.Repository;

import com.example.orderTracking.Entity.Customer;
import com.example.orderTracking.Entity.Order;
import com.example.orderTracking.Entity.Status;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    List<Order> findByOrderId(int id);
    List<Order> findByCustomer(Customer customer);
    List<Order> findByStatus(Status status);
    @Query("select o from Order o where o.orderDate>:date")
    List<Order> getOrderAfterGivenDate(@Param(value="date")LocalDate orderDate);
// List<Order> findByOrderDate(LocalDate date);
    
}