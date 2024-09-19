package com.vircode.BankApplication.dao;

import com.vircode.BankApplication.entity.BankBranches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchDao extends JpaRepository<BankBranches,Integer> {
    List<BankBranches> findByBank_Id(Integer bankId);


}
