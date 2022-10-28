package com.pldc.gpa_service.controller;

import com.pldc.gpa_service.model.Admin;
import com.pldc.gpa_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "/login")
    String login(@RequestBody Admin admin) {
        System.out.println(admin.toString());
        return adminService.login(admin);
    }
}
