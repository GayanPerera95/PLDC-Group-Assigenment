package com.pldc.gpa_service.service.serviceImpl;

import com.pldc.gpa_service.model.Student;
import com.pldc.gpa_service.repository.StudentRepository;
import com.pldc.gpa_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) {

        String returnString;

        try{
            studentRepository.save(student);
            returnString = "success";
        }catch (Exception e) {
            System.out.println(e);
            returnString = e.toString();
        }

        return returnString;
    }

    @Override
    public String login(Student student) {

        String returnString;
        Student dbStudent = null;
        try{
            dbStudent = studentRepository.getById(student.getStudentId());

            if (dbStudent == null) {
                returnString = "not exists";
            }else if (dbStudent != null && dbStudent.getPassword().equals(student.getPassword())){
                returnString = "success";
            }else {
                returnString = "password incorrect";
            }
        }catch (Exception e) {
            returnString = "not exists";
        }
        return returnString;
    }

    @Override
    public Optional<Student> getStudent(int studentId) {
        try {
            return studentRepository.findById(studentId);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
