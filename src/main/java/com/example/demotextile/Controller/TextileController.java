package com.example.demotextile.Controller;

import com.example.demotextile.Entity.TextileEntity;
import com.example.demotextile.Enums.Department;
import com.example.demotextile.Service.TextileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;

import java.util.List;

@RestController
@RequestMapping("/api/textile")
public class TextileController {
    private final TextileService textileService;

    public TextileController(TextileService textileService) {
        this.textileService = textileService;
    }

    @PostMapping("/batch")
    public ResponseEntity<TextileEntity> addBatch(@RequestBody TextileEntity textile){
        TextileEntity addText = textileService.addBatch(textile);
        return ResponseEntity.ok(addText);

    }
    @GetMapping("/batch/{id}")
    public ResponseEntity<TextileEntity> getBatchById(@PathVariable Integer id) {
        TextileEntity batch = textileService.getBatchById(id);
        return ResponseEntity.ok(batch);
    }

    @PutMapping("/batch/{id}")
    public ResponseEntity<TextileEntity> updateBatch(
            @PathVariable Integer id,
            @RequestBody TextileEntity textile) {

        TextileEntity updated = textileService.updateBatch(id, textile);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/batch/{id}")
    public ResponseEntity<String> deleteBatch(@PathVariable Integer id) {
        textileService.deleteBatch(id);
        return ResponseEntity.ok("Batch deleted successfully");
    }

    @GetMapping("/batch/customer/{customer}")
    public ResponseEntity<List<TextileEntity>> getByCustomer(
            @PathVariable String customer) {

        return ResponseEntity.ok(textileService.getByCustomer(customer));
    }

    @PutMapping("/batch/{id}/department")
    public ResponseEntity<TextileEntity> moveDepartment(
            @PathVariable Integer id,
            @RequestParam Department department,
            @RequestParam String status) {

        return ResponseEntity.ok(
                textileService.moveDepartment(id, department, status)
        );
    }


    // Count by department
    @GetMapping("/department/{department}")
    public ResponseEntity<Long> countByDepartment(
            @PathVariable Department department) {

        return ResponseEntity.ok(
                textileService.countByDepartment(department)
        );
    }

    // Count by status
    @GetMapping("/status/{status}")
    public ResponseEntity<Long> countByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                textileService.countByStatus(status)
        );
    }

    // List batches by department
    @GetMapping("/department/{department}/batches")
    public ResponseEntity<List<TextileEntity>> getByDepartment(
            @PathVariable Department department) {

        return ResponseEntity.ok(
                textileService.getByDepartment(department)
        );
    }

    // Today production
    @GetMapping("/today")
    public ResponseEntity<Long> todayProduction() {
        return ResponseEntity.ok(
                textileService.todayCount()
        );
    }


}
