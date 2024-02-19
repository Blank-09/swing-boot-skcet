package com.priyanshu.q_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Medicine;
import com.priyanshu.q_01.repository.MedicineRepo;

@Service
public class MedicineService {

    @Autowired
    MedicineRepo medicineRepo;

    public List<Medicine> getAllMedicines() {
        return medicineRepo.findAll();
    }

    public Optional<Medicine> getMedicineById(int id) {
        return medicineRepo.findById(id);
    }

    public Medicine addMedicine(Medicine user) {
        return medicineRepo.save(user);
    }

}
