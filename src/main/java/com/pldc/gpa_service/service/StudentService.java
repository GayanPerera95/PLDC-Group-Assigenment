package com.pldc.gpa_service.service;

import com.pldc.gpa_service.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    String saveStudent(Student student);

    String login(Student student);

    Optional<Student> getStudent(int studentId);

    List<Student> getAllStudents();
}
