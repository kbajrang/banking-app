package com.javaguides.banking_app.service;

import com.javaguides.banking_app.dto.Accountdto;

import java.util.List;

public interface AccountService {
    Accountdto createaccount(Accountdto account);
    Accountdto getAccountByid(Long id);
    Accountdto deposit(Long id, double amount);
    Accountdto withdraw(Long id,double amount);
    List<Accountdto> getAllAccounts();
    void deleteAcoount(Long id);

    }

