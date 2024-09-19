package com.vircode.BankApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Banks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BankBranches> branches;

    @OneToMany(mappedBy = "bank",cascade =CascadeType.ALL )
    @JsonManagedReference
    private List<BankServices> services;
}
