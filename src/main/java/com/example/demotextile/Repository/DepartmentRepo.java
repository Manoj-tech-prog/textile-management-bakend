package com.example.demotextile.Repository;

import com.example.demotextile.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {
}
