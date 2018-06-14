package com.example.mysqls.service2;

import com.example.mysqls.entity2.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository2 extends JpaRepository<Girl,Integer> {
}
