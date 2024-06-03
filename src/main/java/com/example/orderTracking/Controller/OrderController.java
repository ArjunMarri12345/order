package com.example.orderTracking.Controller;

import com.example.orderTracking.Entity.Customer;
import com.example.orderTracking.Entity.Order;
import com.example.orderTracking.Entity.Status;
import com.example.orderTracking.Repository.CustomerRepo;
import com.example.orderTracking.Repository.OrderRepo;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;










@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/add")
    public void addOrder(@RequestParam("customerId") int customerId,@RequestBody Order order){
        Customer c = customerRepo.findById(customerId).get();
        order.setCustomer(c);
        orderRepo.save(order);
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }
    @DeleteMapping("delete/{id}")
    public void deleteorder(@PathVariable("id") int id){
        try{
        List<Order> o=orderRepo.findByOrderId(id);
        if(o!=null){
            orderRepo.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id not found");
        }
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id not found");
    }
    }
    @GetMapping("/orders/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable int customerId)
    {
    	Customer customer2=customerRepo.findById(customerId).orElse(null);
    	List<Order> orders1=orderRepo.findByCustomer(customer2);
    	return orders1;
    }
    @GetMapping("/{status}")
    public List<Order> getOrdersByStatus(@PathVariable Status status)
    {
    	List<Order> orders2=orderRepo.findByStatus(status);
    	return orders2;
    }
   @GetMapping("/getBydate/{orderDate}")
   public List<Order> getOrdersAfterGivenDate(LocalDate orderDate)
   {
   
	   List<Order> orders3=orderRepo.getOrderAfterGivenDate(orderDate);
	   return orders3;
   }
   @GetMapping("/getorders/{id}")
   public List<Order> getordersByOrderId (@PathVariable int id)
{
	List<Order> order4=orderRepo.findByOrderId(id);
	return order4;
	
}
}
