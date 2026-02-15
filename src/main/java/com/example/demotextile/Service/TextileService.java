package com.example.demotextile.Service;

import com.example.demotextile.Entity.TextileEntity;
import com.example.demotextile.Enums.Department;
import com.example.demotextile.Repository.TextileRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TextileService {

    private final TextileRepo textileRepo;

    public TextileService(TextileRepo textileRepo) {
        this.textileRepo = textileRepo;
    }

    public TextileEntity addBatch(TextileEntity textileEntity){
        return textileRepo.save(textileEntity);
    }
    public TextileEntity getBatchById(Integer batchNo) {
        return textileRepo.findById(batchNo)
                .orElseThrow(() -> new RuntimeException("Batch not found with id: " + batchNo));
    }
    public TextileEntity updateBatch(Integer id, TextileEntity textile) {

        TextileEntity existing = textileRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        existing.setColor(textile.getColor());
        existing.setCustomer(textile.getCustomer());
        existing.setWeight(textile.getWeight());
        existing.setDepartment(textile.getDepartment());

        return textileRepo.save(existing);
    }
    public void deleteBatch(Integer id) {
        if (!textileRepo.existsById(id)) {
            throw new RuntimeException("Batch not found");
        }
        textileRepo.deleteById(id);
    }
    public List<TextileEntity> getByCustomer(String customer) {
        return textileRepo.findByCustomer(customer);
    }

    public TextileEntity moveDepartment(Integer batchNo, Department department, String status) {

        TextileEntity batch = textileRepo.findById(batchNo)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        batch.setDepartment(department);
        batch.setStatus(status);

        return textileRepo.save(batch);
    }

    // Count by department
    public long countByDepartment(Department department) {
        return textileRepo.countByDepartment(department);
    }

    // Count by status
    public long countByStatus(String status) {
        return textileRepo.countByStatus(status);
    }

    // Get batches by department
    public List<TextileEntity> getByDepartment(Department department) {
        return textileRepo.findByDepartment(department);
    }

    // Today production count
    public long todayCount() {
        LocalDateTime start = LocalDate.now().atStartOfDay();
        LocalDateTime end = LocalDate.now().atTime(23, 59, 59);
        return textileRepo.countByDateBetween(start, end);
    }
    public List<TextileEntity> getTextilesByDepartment(Integer deptId) {
        return textileRepo.findByDepartmentDeptId(deptId);
    }


}
