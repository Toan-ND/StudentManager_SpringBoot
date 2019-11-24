package com.example.phonemanager.service;

import com.example.phonemanager.model.Classroom;
import com.example.phonemanager.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> findAll(Pageable pageable);

    Student findById(Long id);

    void save(Student student);

    void delete(Long id);

    Iterable<Student> findAllByClassroom(Classroom classroom);

    Page<Student> findAllByClassroomContaining(String classroom, Pageable pageable);

    Page<Student> findAllByOrderByFirstnameDesc(String firstName, Pageable pageable);

    Page<Student> findAllByOrderByLastnameAsc(String lastName, Pageable pageable);
}
