package com.SmartCity.covoiturage.controller;


import com.SmartCity.covoiturage.model.Admin;
import com.SmartCity.covoiturage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {


    @Autowired
    AdminService adminService;

    @CrossOrigin
    @GetMapping("/admins")
    public List<Admin> findAllAdmins(){
        return adminService.getAdmins();
    }
    @CrossOrigin
    @GetMapping("/admins/{id}")
    public Admin findAdiminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }

    @CrossOrigin
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @CrossOrigin
    @PutMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

    @CrossOrigin
    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id){
        return  adminService.deleteAdmin(id);
    }

}
