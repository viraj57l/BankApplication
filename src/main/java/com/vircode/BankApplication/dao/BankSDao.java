package com.vircode.BankApplication.dao;

import com.vircode.BankApplication.entity.BankServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankSDao extends JpaRepository<BankServices,Integer> {

    @Query("select s from BankServices s where s.bank.id =:bankId")
    List<BankServices> findByBankId(@Param("bankId") Integer bankId);
}
