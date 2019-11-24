package com.example.phonemanager.service;

import com.example.phonemanager.model.Classroom;

public interface ClassroomService {
    Iterable<Classroom> findAll();

    Classroom findbyId(Long id);

    void save(Classroom classroom);

    void delete(Long id);
}
