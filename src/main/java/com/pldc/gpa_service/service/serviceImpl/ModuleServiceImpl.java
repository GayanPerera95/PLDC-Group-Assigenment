package com.pldc.gpa_service.service.serviceImpl;

import com.pldc.gpa_service.model.Degree;
import com.pldc.gpa_service.model.Module;
import com.pldc.gpa_service.repository.ModuleRepository;
import com.pldc.gpa_service.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;


    @Override
    public List<Module> getModulesByDegree(Degree degree) {

        List<Module> modules = null;

        try{
            modules = moduleRepository.getModuleByDegree(degree);
        }catch (Exception e) {
            System.out.println(e);
        }

        return modules;
    }
}
