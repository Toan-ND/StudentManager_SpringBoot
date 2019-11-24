package com.example.phonemanager.repository;

import com.example.phonemanager.model.Classroom;
import com.example.phonemanager.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Iterable<Student> findAllByClassroom(Classroom classroom);
    Page<Student> findAllByClassroomContaining(String classroom, Pageable pageable);

    Page <Student> findAllByOrderByFirstnameDesc(String firstName,Pageable pageable);
    Page <Student> findAllByOrderByLastnameAsc(String lastName, Pageable pageable);
}
