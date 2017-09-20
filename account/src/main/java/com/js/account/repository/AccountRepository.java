package com.js.account.repository;

import com.js.account.domain.Account;
import com.js.account.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountRepository {

    public Account getAccountById(Integer id) {
        List<Account> data = JsonUtil.readData();
        Optional<Account> tmpAcc = data.stream().filter(account -> account.getId() != null && account.getId().equals(id)).findFirst();

        return tmpAcc.isPresent() ? tmpAcc.get() : null;
    }

    public List<Account> getAll() {
        return JsonUtil.readData();
    }

    public Integer createAccount(Account account) {
        List<Account> data = JsonUtil.readData();
        // Find the last Id
        int biggestId = 0;
        for(Account tmp : data){
            if(tmp.getId() > biggestId){
                biggestId = tmp.getId();
            }
        }
        account.setId(++biggestId);
        data.add(account);
        JsonUtil.saveData(data);
        return null;
    }

    /**
     * To demonstrate Java 8 function I ignored case that account Id is not existed.
     * @param account
     */
    public void updateAccount(Account account) {
        List<Account> data = JsonUtil.readData();
        data = data.stream().map(tmp ->
                tmp.getId().equals(account.getId()) ? account : tmp
        ).collect(Collectors.toList());
        JsonUtil.saveData(data);
    }
}
