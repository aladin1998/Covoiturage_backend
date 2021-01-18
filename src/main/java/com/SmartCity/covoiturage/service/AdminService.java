package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.Admin;
import com.SmartCity.covoiturage.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private adminRepository  adminR;

    public Admin saveAdmin(Admin admin){
       return adminR.save(admin);
    }
   public List<Admin> saveAdmins(List<Admin> admins){
        return adminR.saveAll(admins);  }

        public List<Admin> getAdmins(){
        return adminR.findAll();
        }

        public Admin getAdminById(Long id){
        return adminR.findById(id).orElse(null);
        }

    public Admin updateAdmin(Admin admin) {
          Admin existingAdmin=adminR.findById(admin.getIdAdmin()).orElse(null);
          return adminR.save(existingAdmin);
    }

    public String deleteAdmin(Long id){
       adminR.deleteById(id);
        return "admin supprimé";
    }
}
