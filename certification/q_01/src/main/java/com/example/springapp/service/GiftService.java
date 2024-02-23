package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Gift;
import com.example.springapp.repository.GiftRepo;

@Service
public class GiftService {

    @Autowired
    private GiftRepo giftRepo;

    public ResponseEntity<Gift> saveGift(Gift gift) {
        Gift newGift = giftRepo.save(gift);
        return new ResponseEntity<>(newGift, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Gift>> getAllGifts() {
        return ResponseEntity.ok(giftRepo.findAll());
    }

    public ResponseEntity<Gift> getGiftById(int id) {
        Optional<Gift> gift = giftRepo.findById(id);

        if (gift.isPresent()) {
            return new ResponseEntity<>(gift.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}