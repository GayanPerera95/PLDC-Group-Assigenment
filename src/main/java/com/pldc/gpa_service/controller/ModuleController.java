package com.pldc.gpa_service.controller;

import com.pldc.gpa_service.model.Degree;
import com.pldc.gpa_service.model.Module;
import com.pldc.gpa_service.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @PostMapping("/get-modules-by-degree")
    List<Module> getModulesByDegree(@RequestBody Degree degree) {
        return moduleService.getModulesByDegree(degree);
    }
}
