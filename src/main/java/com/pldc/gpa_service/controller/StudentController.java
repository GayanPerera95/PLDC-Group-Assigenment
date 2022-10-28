package com.pldc.gpa_service.controller;

import com.pldc.gpa_service.model.Student;
import com.pldc.gpa_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    String saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/login")
    String login(@RequestBody Student student) {
        return studentService.login(student);
    }

    @GetMapping("/get-student/{id}")
    Optional<Student> getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/get-all")
    List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
