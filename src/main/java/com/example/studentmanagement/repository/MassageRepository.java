package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Massage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MassageRepository extends JpaRepository<Massage, Integer> {

    List<Massage> findByToId(int id);
}
