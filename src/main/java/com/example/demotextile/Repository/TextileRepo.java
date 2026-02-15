package com.example.demotextile.Repository;

import com.example.demotextile.Entity.TextileEntity;
import com.example.demotextile.Enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TextileRepo extends JpaRepository<TextileEntity,Integer> {
    List<TextileEntity> findByCustomer(String customer);
    long countByDepartment(Department department);

    long countByStatus(String status);

    List<TextileEntity> findByDepartment(Department department);

    long countByDateBetween(LocalDateTime start, LocalDateTime end);
    List<TextileEntity> findByDepartmentDeptId(Integer deptId);
}
