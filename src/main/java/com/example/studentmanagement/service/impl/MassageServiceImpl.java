package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.entity.Massage;
import com.example.studentmanagement.repository.MassageRepository;
import com.example.studentmanagement.service.MassageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MassageServiceImpl implements MassageService {

    private final MassageRepository massageRepository;

    @Override
    public Massage save(Massage massage) {
        return massageRepository.save(massage);
    }

    @Override
    public List<Massage> findByToId(int id) {
        return massageRepository.findByToId(id);
    }
}
