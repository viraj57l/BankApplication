package com.vircode.BankApplication.controller;


import com.vircode.BankApplication.dto.BankData;
import com.vircode.BankApplication.dto.ServicesData;
import com.vircode.BankApplication.entity.BankBranches;
import com.vircode.BankApplication.entity.Banks;
import com.vircode.BankApplication.service.BankService;
import com.vircode.BankApplication.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("bank")
public class BankController {

    @Autowired
    BankService bankService;

    @Autowired
    BranchService branchService;



   @GetMapping("allBanks")
   public ResponseEntity<List<BankData>> getAllBanks() {
       return bankService.getAllBanks();
   }

   

   @GetMapping("branches/{bankId}")
   public ResponseEntity<List<BankBranches>> getBranches(@PathVariable Integer bankId){
      List<BankBranches> branches=branchService.getAllBranches(bankId);
      if(branches.isEmpty()){
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(branches);
   }

   @GetMapping("{bankId}")
    public Optional<Banks> getBankById(@PathVariable Integer bankId){
       return bankService.getBankById(bankId);
   }

   @GetMapping("s/{bankId}")
    public String getServices(@PathVariable Integer bankId, Model model){
       
       List<ServicesData> servicesDataList = bankService.getServicesOfBank(bankId, model);

       Optional<Banks> banksOptional=bankService.getBankById(bankId);

       if(banksOptional.isPresent()){
           Banks bank = banksOptional.get();

           model.addAttribute("bankName",bank.getName());
       }
       else{
           model.addAttribute("bankName","Unknown Bank");
       }

       model.addAttribute("bankId", bankId);
       model.addAttribute("services", servicesDataList);
        return "services";
   }

   @GetMapping("b/{bankId}")
    public String getBranches(@PathVariable Integer bankId,Model model){
        List<BankBranches> bankBranchesList= branchService.getAllBranches(bankId);

        Optional<Banks> banksOptional=bankService.getBankById(bankId);
        if(banksOptional.isPresent()){
            Banks bank=banksOptional.get();
            model.addAttribute("bankName",bank.getName());
        }
        else{
            model.addAttribute("bankName","Unknown Bank");
        }
        model.addAttribute("branches",bankBranchesList);
        return "branches";
   }


}
