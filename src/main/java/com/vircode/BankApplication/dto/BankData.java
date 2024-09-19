package com.vircode.BankApplication.dto;

// so this class is specifically made for only name  output
//  if the dao prints the whole id and names too.
// made separate class to, /banks/allBanks

public class BankData {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankData(String name) {
        this.name = name;
    }
}
