package com.example.mysqls.service;

import com.example.mysqls.entity.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Boy,Integer>{
}
