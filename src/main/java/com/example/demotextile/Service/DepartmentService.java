package com.example.demotextile.Service;

import com.example.demotextile.Entity.DepartmentEntity;
import com.example.demotextile.Repository.DepartmentRepo;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public DepartmentEntity addDepartment(DepartmentEntity dept) {
        return departmentRepo.save(dept);
    }

    public DepartmentEntity getDepartment(Integer id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
