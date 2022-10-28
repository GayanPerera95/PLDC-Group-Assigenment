package com.pldc.gpa_service.repository;

import com.pldc.gpa_service.model.Degree;
import com.pldc.gpa_service.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
    List<Module> getModuleByDegree(Degree degree);
}
