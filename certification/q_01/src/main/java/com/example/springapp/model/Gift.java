package com.example.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Gift {

    @Id
    private int giftId;
    private String giftName;
    private String description;
    private String price;
    private String category;

}
