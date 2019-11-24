package com.example.phonemanager.controller;

import com.example.phonemanager.model.Classroom;
import com.example.phonemanager.model.Student;
import com.example.phonemanager.service.ClassroomService;
import com.example.phonemanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassroomService classroomService;

    @ModelAttribute("classrooms")
    public Iterable<Classroom> classrooms() {
        return classroomService.findAll();
    }

    @GetMapping("/students")
    public ModelAndView listStudent(@RequestParam(name = "s") Optional<String> s, Pageable pageable){
        Page<Student> students;
        if (s.isPresent()){
            students = studentService.findAllByClassroomContaining(s.get(), pageable);
        }else {
            students = studentService.findAll(pageable);
        }
        ModelAndView modelAndView =  new ModelAndView("student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create-student")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView =  new ModelAndView(("student/create"));
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView createStudent(@ModelAttribute Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "create student successfully!");
        return modelAndView;
    }


    @GetMapping("/edit-student/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        Student student =  studentService.findById(id);
        ModelAndView modelAndView =  new ModelAndView("student/edit");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/edit-student")
    public ModelAndView update(@ModelAttribute Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Update student successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-student/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        Student student =  studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("student/delete");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@ModelAttribute Student student){
        studentService.delete(student.getId());
        return "redirect:/students";
    }
}

