package com.pldc.gpa_service.repository;

import com.pldc.gpa_service.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminByUsername(String username);
}
