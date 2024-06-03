package com.example.orderTracking.Repository;

import com.example.orderTracking.Entity.OrderItem;
import com.example.orderTracking.Entity.OrderItemId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,OrderItemId>{
   // List<OrderItem> findByIdOrderItemIdOrderOrderIdAndIdOrderItemIdProductProId(int orderId,int proId);
   // List<OrderItem> findByIdOrderItemIdOrderOrderIdAndIdOrderItemIdProductProId(int orderId, int productId);
}
