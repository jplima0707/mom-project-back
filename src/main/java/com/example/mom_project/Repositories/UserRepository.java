package com.example.mom_project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mom_project.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
