package com.example.mom_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mom_project.Models.User;
@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
   
}
