package com.pldc.gpa_service.service.serviceImpl;

import com.pldc.gpa_service.model.Result;
import com.pldc.gpa_service.model.Student;
import com.pldc.gpa_service.model.Module;
import com.pldc.gpa_service.repository.ResultRepository;
import com.pldc.gpa_service.service.ResultService;
import com.pldc.gpa_service.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public List<Result> getResultsByStudent(Student student) {

        List<Result> results = null;
        try {
            results = resultRepository.getResultByStudent(student);
        }catch (Exception e) {
            System.out.println(e);
        }
        return results;

    }

    @Override
    public List<Result> getResultsByModule(Module module) {

        List<Result> results = null;
        try {
            results = resultRepository.getResultByModule(module);
        }catch (Exception e) {
            System.out.println(e);
        }
        return results;
    }

    @Override
    public String editResult(Result result) {

        String returnString;
        try{
            Result dbResult = resultRepository.getResultByStudentAndModule(result.getStudent(), result.getModule());

            dbResult.setGrade(result.getGrade());

            resultRepository.save(dbResult);

            returnString = "success";

        }catch (Exception e) {
            System.out.println(e);
            returnString = "failed";
        }
        return returnString;
    }

    @Override
    public String saveResults(List<Result> results) {

        String returnString;
        try{
            for (Result result: results){
                resultRepository.deleteResultByStudent(result.getStudent());
            }
            resultRepository.saveAll(results);
            returnString = "success";
        }catch(Exception e) {
            returnString = e.toString();
        }
        return returnString;

    }

    @Override
    public double calGpa(List<Result> results) {
        double gpa;
        List<Result> nonEmptyResults = new ArrayList<>();

        for (Result result : results) {
            System.out.println(result.getGrade());
            if (!(result.getGrade().equals("absent"))) {
                nonEmptyResults.add(result);
            }
        }

        try{
            gpa = Util.calculateGpa(nonEmptyResults);
        }catch (Exception e) {
            System.out.println(e);
            gpa = 0;
        }

        try{
            for (Result result: nonEmptyResults){
                resultRepository.deleteResultByStudentAndModule(result.getStudent(), result.getModule());
            }
            resultRepository.saveAll(nonEmptyResults);
        }catch(Exception e) {
            System.out.println(e);
        }

        return gpa;
    }

    @Override
    public double getGpa(Student student) {
        List<Result> results = resultRepository.getResultByStudent(student);
        double gpa = Util.calculateGpa(results);
        return gpa;
    }

}
