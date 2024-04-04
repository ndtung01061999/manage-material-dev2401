package com.vn.devmaster.services.controller;

import com.vn.devmaster.services.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Demo1Controller {

    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("name", "Duy Tùng");
        return "index";
    }

    @GetMapping("/show-student")
    public String showStudent(Model model) {
        Student student = new Student();
        student.setName("Tùng");
        student.setAddress("Hà Nội");
        model.addAttribute("student", student);
        return "index";
    }

    @GetMapping("/show-student-avg/{}")
    public String showStudentAvg(@PathVariable int id, Model model) {
        return "index";
    }

}
