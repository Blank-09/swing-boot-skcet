package com.priyanshu.q_02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.priyanshu.q_02.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer> {

    @Query("SELECT m FROM Medicine m WHERE m.expiryDate <= CURRENT_DATE")
    List<Medicine> findExpiredMedicines();

    List<Medicine> findByBrand(String brand);

}