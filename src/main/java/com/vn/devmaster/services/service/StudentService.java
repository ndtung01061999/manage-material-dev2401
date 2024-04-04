package com.vn.devmaster.services.service;

import com.vn.devmaster.services.entities.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    static List<Student> students = new ArrayList<>();


    public List<Student> getAll() {
        if (students.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                Student student = new Student();
                student.setId(i);
                student.setName("Tung " + i);
                student.setAddress("HN " + i);
                students.add(student);
            }
        }
        return students;
    }

    public void addStudent(Student student) {
        student.setId(students.size());
        students.add(student);
    }

    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(new Student());
    }

    public void updateStudent(int id, Student student) {
        Student s = findById(id);
        s.setName(student.getName());
        s.setAddress(student.getAddress());
        students = students.stream().peek(item -> {
            if (item.getId() == id) item = s;
        }).collect(Collectors.toList());
    }
}
