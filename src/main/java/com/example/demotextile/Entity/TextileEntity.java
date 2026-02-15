package com.example.demotextile.Entity;

import com.example.demotextile.Enums.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TextileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer batchNo;
    private String color;
    private String customer;
    private Integer weight;
    @CreationTimestamp
    private LocalDateTime date;
    @PreUpdate
    public void onUpdate() {
        this.date = LocalDateTime.now();
    }
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private DepartmentEntity depart;

    @Enumerated(EnumType.STRING)
    private Department department;


    private String status; // PENDING, IN_PROGRESS, COMPLETED

}
