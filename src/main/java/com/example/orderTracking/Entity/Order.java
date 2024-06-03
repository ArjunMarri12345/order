package com.example.orderTracking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;



@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  orderId;

    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private Status status;


    private LocalDate deleveryDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="id.order")
    @JsonIgnore
    private List<OrderItem> product;

    public Order() {
    }

    

   



    public int getOrderId() {
        return orderId;
    }







    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }







    public LocalDate getOrderDate() {
        return orderDate;
    }







    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }







    public Customer getCustomer() {
        return customer;
    }







    public void setCustomer(Customer customer) {
        this.customer = customer;
    }







    public Status getStatus() {
        return status;
    }







    public void setStatus(Status status) {
        this.status = status;
    }







    public LocalDate getDeleveryDate() {
        return deleveryDate;
    }







    public void setDeleveryDate(LocalDate deleveryDate) {
        this.deleveryDate = deleveryDate;
    }







    public List<OrderItem> getProduct() {
        return product;
    }







    public void setProduct(List<OrderItem> product) {
        this.product = product;
    }







    public Order(LocalDate orderDate, Customer customer, Status status, LocalDate deleveryDate) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.status = status;
        this.deleveryDate = deleveryDate;
    }







    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", status="
                + status + ", deleveryDate=" + deleveryDate + "]";
    }

    

}

//id,  order date, customer id, status