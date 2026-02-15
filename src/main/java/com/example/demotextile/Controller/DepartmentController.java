package com.example.demotextile.Controller;

import com.example.demotextile.Entity.DepartmentEntity;
import com.example.demotextile.Entity.TextileEntity;
import com.example.demotextile.Service.DepartmentService;
import com.example.demotextile.Service.TextileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentEntity> addDepartment(
            @RequestBody DepartmentEntity department) {
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentEntity> getDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.getDepartment(id));
    }

    @GetMapping("/department/{deptId}")
    public ResponseEntity<List<TextileEntity>> getByDepartment(
            @PathVariable Integer deptId, TextileService textileService) {

        return ResponseEntity.ok(
                textileService.getTextilesByDepartment(deptId)
        );
    }
}
