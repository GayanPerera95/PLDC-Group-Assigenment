package com.pldc.gpa_service.service;

import com.pldc.gpa_service.model.Result;
import com.pldc.gpa_service.model.Student;
import com.pldc.gpa_service.model.Module;

import java.util.List;

public interface ResultService {
    List<Result> getResultsByStudent(Student student);

    List<Result> getResultsByModule(Module module);

    String editResult(Result result);

    String saveResults(List<Result> results);

    double calGpa(List<Result> results);

    double getGpa(Student student);
}
