package com.priyanshu.q_02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_02.model.Medicine;
import com.priyanshu.q_02.repository.MedicineRepo;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;

    public ResponseEntity<Medicine> saveMedicine(Medicine medicine) {
        return new ResponseEntity<>(medicineRepo.save(medicine), HttpStatus.CREATED);
    }

    public ResponseEntity<Medicine> updateMedicine(int medicineId, Medicine medicine) {
        Optional<Medicine> existing = medicineRepo.findById(medicineId);

        System.out.println(existing);
        if (existing.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        medicine.setMedicineId(medicineId);
        return ResponseEntity.ok(medicineRepo.save(medicine));
    }

    public boolean deleteExpiredMedicine() {
        try {
            List<Medicine> expiredMedicines = medicineRepo.findExpiredMedicines();
            medicineRepo.deleteAll(expiredMedicines);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }

    public ResponseEntity<List<Medicine>> getByBrand(String brand) {
        List<Medicine> medicines = medicineRepo.findByBrand(brand);

        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(medicines);
    }

}