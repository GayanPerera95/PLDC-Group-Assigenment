package com.pldc.gpa_service.service;

import com.pldc.gpa_service.model.Degree;
import com.pldc.gpa_service.model.Module;

import java.util.List;

public interface ModuleService {
    List<Module> getModulesByDegree(Degree degree);
}
