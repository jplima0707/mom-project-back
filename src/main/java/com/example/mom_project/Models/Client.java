package com.example.mom_project.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.mom_project.Models.ValueObjects.Email;
import com.example.mom_project.Models.ValueObjects.PhoneNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "Clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true)
    private List<Purchase> purchases;

    @Column(nullable=false, length = 255)
    private String name;

    @Column(nullable = false, length = 15, name = "phone")
    @Embedded
    private PhoneNumber phone;

    @Column(length = 90, name = "email")
    @Embedded
    private Email email;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(length = 255)
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Client() {
    }

    public Client(String name, PhoneNumber phone, Email email, Date birthDate, String address, User user) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.purchases = new ArrayList<>(); 
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
}
