package com.priyanshu.q_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Address;
import com.priyanshu.q_01.repository.AddressRepo;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public ResponseEntity<Address> addAddress(Address address) {
        return new ResponseEntity<>(addressRepo.save(address), HttpStatus.CREATED);
    }

    public Address getAddress(int addressId) {
        return addressRepo.findById(addressId).orElse(null);
    }

    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public List<Address> getAddressEndsWith(String city) {
        return addressRepo.findByCityEndsWith(city);
    }

    public ResponseEntity<Address> updateAddress(int addressId, Address address) {
        Optional<Address> existing = addressRepo.findById(addressId);

        if (existing.isPresent()) {
            address.setAddressId(addressId);
            addressRepo.save(address);
            return ResponseEntity.ok(address);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> deleteAddress(int addressId) {
        if (!addressRepo.existsById(addressId))
            return new ResponseEntity<>("Address not found", HttpStatus.NOT_FOUND);

        addressRepo.deleteById(addressId);
        return ResponseEntity.ok("Address deleted Successfully");
    }

}