package com.js.account.service;

import com.js.account.domain.Account;
import com.js.account.domain.AccountBuilder;
import com.js.account.dto.AccountDto;
import com.js.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(int id) {
        Account account = null;
        if (id > 0) {
            account = accountRepository.getAccountById(id);
        }
        return account;
    }

    public List<Account> getAll() {
        return accountRepository.getAll();
    }

    public Integer createAccount(AccountDto accountDto) {
        Integer accountId = null;
        if (accountDto != null) {
            AccountBuilder accountBuilder = new AccountBuilder(accountDto.getCustomerName(),
                    accountDto.getCurrency());
            if (accountDto.getAmount() != null) {
                accountBuilder.withAmount(accountDto.getAmount());
            }
            accountId = accountRepository.createAccount(accountBuilder.build());
        }
        return accountId;
    }

    public void updateAccount(AccountDto accountDto) {
        if (accountDto != null && accountDto.getId() != null) {
            AccountBuilder accountBuilder = new AccountBuilder(accountDto.getId(), accountDto.getCustomerName(),
                    accountDto.getCurrency());
            accountBuilder.withAmount(accountDto.getAmount());
            accountRepository.updateAccount(accountBuilder.build());
        }
    }
}
