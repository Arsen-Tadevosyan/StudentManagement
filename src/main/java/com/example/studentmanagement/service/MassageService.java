package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Massage;

import java.util.List;

public interface MassageService {

    Massage save(Massage massage);

   List<Massage> findByToId(int id);
}
