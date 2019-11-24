package com.example.phonemanager.service.Impl;

import com.example.phonemanager.model.Classroom;
import com.example.phonemanager.repository.ClassroomRepository;
import com.example.phonemanager.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom findbyId(Long id) {
        return classroomRepository.findById(id).get();
    }

    @Override
    public void save(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public void delete(Long id) {
        classroomRepository.deleteById(id);
    }
}
