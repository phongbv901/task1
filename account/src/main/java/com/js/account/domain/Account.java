package com.js.account.domain;

public class Account {

    private Integer id;

    private String customerName;

    private String currency;

    private Double amount;

    public Account() {
    }

    public  Account(Integer id, String customerName, String currency, Double amount) {
        this.id = id;
        this.customerName = customerName;
        this.currency = currency;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
