package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Address;
import com.priyanshu.q_01.service.AddressService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/{customerId}")
    public ResponseEntity<Address> addAddress(@PathVariable int customerId, @RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/{addressId}")
    public Address getAddress(@PathVariable int addressId) {
        return addressService.getAddress(addressId);
    }

    @GetMapping
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping("/endswith/{city}")
    public List<Address> getAddressEndsWith(@PathVariable String city) {
        return addressService.getAddressEndsWith(city);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable int addressId, @RequestBody Address address) {
        return addressService.updateAddress(addressId, address);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable int addressId) {
        return addressService.deleteAddress(addressId);
    }

}