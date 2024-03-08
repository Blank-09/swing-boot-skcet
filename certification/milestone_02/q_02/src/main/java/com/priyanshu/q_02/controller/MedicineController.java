package com.priyanshu.q_02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_02.model.Medicine;
import com.priyanshu.q_02.service.MedicineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable int medicineId, @RequestBody Medicine medicine) {
        return medicineService.updateMedicine(medicineId, medicine);
    }

    @DeleteMapping("/expired")
    public ResponseEntity<String> postMethodName() {
        boolean isDeleted = medicineService.deleteExpiredMedicine();

        if (!isDeleted) {
            return new ResponseEntity<>("No medicine found in expired state", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Deleted Successfully");
    }

    @GetMapping
    public List<Medicine> getAll() {
        return medicineService.getAll();
    }

    @GetMapping("/bybrand/{brand}")
    public ResponseEntity<List<Medicine>> getByBrand(@PathVariable String brand) {
        return medicineService.getByBrand(brand);
    }

}