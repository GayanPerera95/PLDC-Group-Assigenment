package com.pldc.gpa_service.repository;

import com.pldc.gpa_service.model.Module;
import com.pldc.gpa_service.model.Result;
import com.pldc.gpa_service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> getResultByStudent(Student student);

    List<Result> getResultByModule(Module module);

    Result getResultByStudentAndModule(Student student, Module module);

    @Transactional
    void deleteResultByStudent(Student student);

    @Transactional
    void deleteResultByStudentAndModule(Student student, Module module);
}
