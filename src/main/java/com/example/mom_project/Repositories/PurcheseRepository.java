package com.example.mom_project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mom_project.Models.Purchase;

public interface PurcheseRepository extends JpaRepository<Purchase,Long> {
    
}
