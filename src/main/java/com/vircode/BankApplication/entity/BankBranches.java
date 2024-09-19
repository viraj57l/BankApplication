package com.vircode.BankApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BankBranches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; 
    private String address;

    @ManyToOne
    @JoinColumn(name = "bank_id",nullable = false)
    @JsonBackReference
    private Banks bank;


}
