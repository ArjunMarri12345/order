package com.example.orderTracking.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class OrderItem {
    
    @EmbeddedId
    private OrderItemId id=new OrderItemId();

    private int qty;

    private float price;

    

    public OrderItem() {
    }
    

    public OrderItem(OrderItemId id, int qty, float price) {
        this.id = id;
        this.qty = qty;
        this.price = price;
    }

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId orderItemId) {
        this.id = orderItemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public Order getOrder() {
        return getId().getOrder();
    }

    public void setOrder(Order order) {
        getId().setOrder(order);
    }

    public Product getProduct() {
        return getId().getProduct();
    }

    public void setProduct(Product product) {
        getId().setProduct(product);
    }

    

    @Override
    public String toString() {
        return "OrderItem [orderItemId=" + id + ", qty=" + qty + ", price=" + price + "]";
    }

    

    

    
}
