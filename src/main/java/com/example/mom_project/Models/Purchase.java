package com.example.mom_project.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Purchases")
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    @Column(nullable = false)
    private double value;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(length = 20)
    private String paymentMethod;

    protected Purchase() {
    }

    public Purchase(Client client, double value, Date createdDate, String paymentMethod) {
        this.client = client;
        this.cars = new ArrayList<Car>();
        this.value = value;
        this.createdDate = createdDate;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }   

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }   

    public Date getCreatedDate() {
        return createdDate;
    }  

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }   

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
