package com.js.account.domain;

public class AccountBuilder {

    private Integer id;

    private final String customerName;

    private final String currency;

    private Double amount;

    public AccountBuilder(String customerName, String currency) {
        this.customerName = customerName;
        this.currency = currency;
    }

    public AccountBuilder(Integer id, String customerName, String currency) {
        this.id = id;
        this.customerName = customerName;
        this.currency = currency;
        this.amount = 0.0;
    }

    public AccountBuilder withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Account build() {
        return new Account(this.id, this.customerName, this.currency, this.amount);
    }
}
