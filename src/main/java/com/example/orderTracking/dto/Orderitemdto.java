package com.example.orderTracking.dto;

import java.util.List;

import com.example.orderTracking.Entity.Product;

public class Orderitemdto {
	private String productName;
    private int quantity;
    private double price;
    
	public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void Orderitemdto(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public void Orderitemdto() {
 
}
}

