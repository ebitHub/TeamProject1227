package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.NameEntity;
import com.example.demo.mapper.PresentMapper;

@Service
public class PresentService {
	private final PresentMapper presentMapper;

    public PresentService(PresentMapper presentMapper) {
        this.presentMapper = presentMapper;
    }

    public List<NameEntity> getPresentCounts() {
        return presentMapper.getPresentCounts();
    }

}
