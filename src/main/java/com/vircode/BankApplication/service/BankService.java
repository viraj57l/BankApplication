package com.vircode.BankApplication.service;

import com.vircode.BankApplication.dao.BankDao;
import com.vircode.BankApplication.dao.BankSDao;
import com.vircode.BankApplication.dto.BankData;
import com.vircode.BankApplication.dto.ServicesData;
import com.vircode.BankApplication.entity.BankServices;
import com.vircode.BankApplication.entity.Banks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankService {

    @Autowired
    BankDao bankDao;

    @Autowired
    BankSDao bankSDao;

    public ResponseEntity<List<BankData>> getAllBanks(){
        try{
            List<Banks> banks=bankDao.findAll();
            List<BankData> bankDataList=banks.stream()
                    .map(b -> new BankData(b.getName()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(bankDataList);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public Optional<Banks> getBankById(Integer bankId){
        return bankDao.findById(bankId);
    }


    public List<ServicesData> getServicesOfBank(Integer bankId, Model model) {

            List<BankServices> services =bankSDao.findByBankId(bankId);
            List<ServicesData> servicesDataList=services.stream()
                    .map(s ->new ServicesData(s.getServiceName()))
                    .collect(Collectors.toList());
            model.addAttribute("bankId",bankId);
            model.addAttribute("services",servicesDataList);

        return servicesDataList;
    }
}
