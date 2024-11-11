package com.javaguides.banking_app.service.impl;

import com.javaguides.banking_app.Entity.Account;
import com.javaguides.banking_app.dto.Accountdto;
import com.javaguides.banking_app.mapper.Accountmapper;
import com.javaguides.banking_app.repository.AccountRepository;
import com.javaguides.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceimpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceimpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto createaccount(Accountdto accountdto) {
        Account account = Accountmapper.mapToAccount(accountdto);
        Account savedaccount=accountRepository.save(account);

        return Accountmapper.mapToAccountdto(savedaccount);
    }

    @Override
    public Accountdto getAccountByid(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account doesnot exist"));

        return Accountmapper.mapToAccountdto(account);
    }

    @Override
    public Accountdto deposit(Long id, double amount) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account doesnot exist"));
        double total=account.getBalence()+amount;
        account.setBalence(total);
        Account savedAccount =accountRepository.save(account);

        return Accountmapper.mapToAccountdto(savedAccount);
    }
    @Override
    public Accountdto withdraw(Long id, double amount) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account doesnot exist"));
        double total=account.getBalence()-amount;
        account.setBalence(total);
        Account savedAccount =accountRepository.save(account);

        return Accountmapper.mapToAccountdto(savedAccount);
    }

    @Override
    public List<Accountdto> getAllAccounts() {
        List<Account> accounts= accountRepository.findAll();
        return accounts.stream().map((account)-> Accountmapper.mapToAccountdto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAcoount(Long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account Does Not Exists"));
        accountRepository.deleteById(id);

    }

}
