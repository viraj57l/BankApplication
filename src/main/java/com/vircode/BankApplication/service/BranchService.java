package com.vircode.BankApplication.service;

import com.vircode.BankApplication.dao.BranchDao;
import com.vircode.BankApplication.entity.BankBranches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchDao branchDao;

    public List<BankBranches> getAllBranches(Integer bankId) {
        return  branchDao.findByBank_Id(bankId);
    }


}
