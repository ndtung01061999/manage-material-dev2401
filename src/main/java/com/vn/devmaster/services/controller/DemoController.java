package com.vn.devmaster.services.controller;

import com.vn.devmaster.services.entities.Student;
import com.vn.devmaster.services.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final StudentService studentService;

    @GetMapping("/view/students")
    public String showStudent(Model model) {
        List<Student> studentList = studentService.getAll();
        model.addAttribute("students", studentList);
        return "demo/student";
    }

    @GetMapping("/view/add-student")
    public String showAddStudent(Model model) {
        model.addAttribute("student", new Student());
        return "demo/add-student";
    }

    @PostMapping("/student")
    public String addStudent(
            @ModelAttribute("student")
                    Student student) {
        studentService.addStudent(student);
        return "redirect:/view/students";
    }

    @GetMapping("/view/update-student/{id}")
    public String showUpdateStudent(Model model,
                                    @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "demo/update-student";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable("id") int id,
                                @ModelAttribute("student") Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/view/students";
    }


}
