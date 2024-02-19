package com.priyanshu.q_01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Medicine;
import com.priyanshu.q_01.service.MedicineService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @PostMapping("/medicine")
    @ResponseStatus(HttpStatus.CREATED)
    public Medicine getAllMedicine(@RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }

    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> getMethodName() {
        List<Medicine> list = medicineService.getAllMedicines();

        if (list.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<Medicine>(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/medicine/{medicineId}")
    public ResponseEntity<Medicine> getMethodName(@PathVariable int medicineId) {
        Optional<Medicine> medicine = medicineService.getMedicineById(medicineId);

        if (medicine.isPresent()) {
            return new ResponseEntity<>(medicine.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
