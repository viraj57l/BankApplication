package com.vircode.BankApplication.dao;

import com.vircode.BankApplication.entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDao extends JpaRepository<Banks,Integer> {

}
