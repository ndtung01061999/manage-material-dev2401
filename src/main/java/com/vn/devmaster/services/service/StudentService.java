package com.vn.devmaster.services.service;

import com.vn.devmaster.services.entities.Student;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    public static void main(String[] args) throws ParseException {
        String date = "2024-04-16T19:15";

        SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm");
        Date lFromDate1 = datetimeFormatter1.parse(date);
        System.out.println("gpsdate :" + lFromDate1);
        Timestamp fromTS1 = new Timestamp(lFromDate1.getTime());
        System.out.println(fromTS1);
//        String dateStr = "2020-08-17T10:11:16.908732";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, format);
        System.out.println("date time:" + dateTime);

    }
}
