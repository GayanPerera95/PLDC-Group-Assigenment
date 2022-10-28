package com.pldc.gpa_service.controller;

import com.pldc.gpa_service.model.Result;
import com.pldc.gpa_service.model.Student;
import com.pldc.gpa_service.model.Module;
import com.pldc.gpa_service.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/result")
public class ResultController {

    @Autowired
    ResultService resultService;

    @PostMapping("/get-results-by-student")
    List<Result> getResultsByStudent(@RequestBody Student student) {
        return resultService.getResultsByStudent(student);
    }

    @PostMapping("/get-results-by-module")
    List<Result> getResultsByModule(@RequestBody Module module) {
        return resultService.getResultsByModule(module);
    }

    @PutMapping("/edit")
    String editResults(@RequestBody Result result) {
        return resultService.editResult(result);
    }

    @PostMapping("/save")
    String saveResults(@RequestBody List<Result> results) {
        return resultService.saveResults(results);
    }

    @PostMapping("/cal-gpa")
    double calGpa(@RequestBody List<Result> results) {
        return resultService.calGpa(results);
    }

    @PostMapping("/get-gpa")
    double getGpa(@RequestBody Student student) {
        return resultService.getGpa(student);
    }
}
