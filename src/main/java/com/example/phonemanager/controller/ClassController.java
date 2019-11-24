package com.example.phonemanager.controller;

import com.example.phonemanager.model.Classroom;
import com.example.phonemanager.model.Student;
import com.example.phonemanager.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ClassController {
    @Autowired
    ClassroomService classroomService;

    @GetMapping("/class")
    public ModelAndView listClass() {
        Iterable<Classroom> classrooms = classroomService.findAll();
        ModelAndView modelAndView = new ModelAndView("class/list");
        modelAndView.addObject("class", classrooms);
        return modelAndView;
    }

    @GetMapping("/create-class")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView(("class/create"));
        modelAndView.addObject("class", new Classroom());
        return modelAndView;
    }

    @PostMapping("/create-class")
    public ModelAndView createStudent(@ModelAttribute Classroom classroom) {
        classroomService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("class/create");
        modelAndView.addObject("class", new Classroom());
        modelAndView.addObject("message", "create new classroom successfully!");
        return modelAndView;
    }


    @GetMapping("/edit-class/{id}")
    public ModelAndView editClass(@PathVariable Long id) {
        Classroom classroom = classroomService.findbyId(id);
        ModelAndView modelAndView = new ModelAndView("class/edit");
        modelAndView.addObject("class", classroom);
        return modelAndView;
    }

    @PostMapping("/edit-class")
    public ModelAndView update(@ModelAttribute Classroom classroom) {
        classroomService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("class/edit");
        modelAndView.addObject("class", classroom);
        modelAndView.addObject("message", "Update class successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-class/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Classroom classroom = classroomService.findbyId(id);
        ModelAndView modelAndView = new ModelAndView("class/delete");
        modelAndView.addObject("class", classroom);
        return modelAndView;
    }

    @PostMapping("/delete-class")
    public String deleteClass(@ModelAttribute Classroom classroom) {
        classroomService.delete(classroom.getId());
        return "redirect:/class";
    }


}
