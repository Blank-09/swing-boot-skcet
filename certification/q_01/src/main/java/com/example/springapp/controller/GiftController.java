package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Gift;
import com.example.springapp.service.GiftService;

@RestController
public class GiftController {

    @Autowired
    private GiftService giftService;

    @PostMapping("/api/gift")
    public ResponseEntity<Gift> addGift(@RequestBody Gift gift) {
        return giftService.saveGift(gift);
    }

    @GetMapping("/api/gift")
    public ResponseEntity<List<Gift>> getAllGifts() {
        return giftService.getAllGifts();
    }

    @GetMapping("/api/gift/{giftId}")
    public ResponseEntity<Gift> getGiftById(@PathVariable int giftId) {
        return giftService.getGiftById(giftId);
    }

}
