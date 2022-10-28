package com.pldc.gpa_service.service.serviceImpl;

import com.pldc.gpa_service.model.Admin;
import com.pldc.gpa_service.repository.AdminRepository;
import com.pldc.gpa_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;


    @Override
    public String login(Admin admin) {

        String returnString;
        try{
            Admin dbAdmin = adminRepository.findAdminByUsername(admin.getUsername());

            if (dbAdmin == null) {
              returnString = "not exists";
            }else if (dbAdmin != null && dbAdmin.getPassword().equals(admin.getPassword())){
                returnString = "success";
            }else {
                returnString = "password incorrect";
            }
        }catch (Exception e) {
            returnString = e.toString();
        }
        return returnString;
    }
}
