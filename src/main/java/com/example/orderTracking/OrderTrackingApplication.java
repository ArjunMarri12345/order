package com.example.orderTracking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.orderTracking.Controller.OrderItemController;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = "Order tracking system", title = "My API", version = "2.0.2"))
public class OrderTrackingApplication implements CommandLineRunner {
	@Autowired
	OrderItemController orderItemController;

	public static void main(String[] args) {
		SpringApplication.run(OrderTrackingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("kfnug-----------------gfnxk--------------fa");
		//orderItemController.getOrderItemById(2, 1);
	}

}
