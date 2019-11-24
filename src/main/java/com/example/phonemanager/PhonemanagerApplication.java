package com.example.phonemanager;

import com.example.phonemanager.service.ClassroomService;
import com.example.phonemanager.service.Impl.ClassroomServiceImpl;
import com.example.phonemanager.service.Impl.StudentServiceImpl;
import com.example.phonemanager.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhonemanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonemanagerApplication.class, args);
    }
@Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
}

@Bean
    public ClassroomService classroomService(){
        return new ClassroomServiceImpl();
}



}
