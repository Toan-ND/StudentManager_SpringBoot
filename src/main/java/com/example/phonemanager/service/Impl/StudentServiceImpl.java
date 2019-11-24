package com.example.phonemanager.service.Impl;

import com.example.phonemanager.model.Classroom;
import com.example.phonemanager.model.Student;
import com.example.phonemanager.repository.StudentRepository;
import com.example.phonemanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findAllByClassroom(Classroom classroom) {
        return studentRepository.findAllByClassroom(classroom);
    }

    @Override
    public Page<Student> findAllByClassroomContaining(String classroom, Pageable pageable) {
        return studentRepository.findAllByClassroomContaining(classroom, pageable);
    }

    @Override
    public Page<Student> findAllByOrderByFirstnameDesc(String firstName, Pageable pageable) {
        return studentRepository.findAllByOrderByFirstnameDesc(firstName, pageable);
    }

    @Override
    public Page<Student> findAllByOrderByLastnameAsc(String lastName, Pageable pageable) {
        return studentRepository.findAllByOrderByLastnameAsc(lastName, pageable);
    }
}
