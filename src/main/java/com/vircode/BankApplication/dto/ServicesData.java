package com.vircode.BankApplication.dto;

public class ServicesData {
    private String serviceName;

    public ServicesData(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "ServicesData{" +
                "serviceName='" + serviceName  +
                '}';
    }
}
