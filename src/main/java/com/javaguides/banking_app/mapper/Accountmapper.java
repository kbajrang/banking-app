package com.javaguides.banking_app.mapper;

import com.javaguides.banking_app.Entity.Account;
import com.javaguides.banking_app.dto.Accountdto;

public class Accountmapper {
    public  static Account mapToAccount(Accountdto accountdto){
        Account account=new Account(
        accountdto.getId(),
        accountdto.getAccountholdernamed(),
        accountdto.getBalence()
        );
        return  account;
    }
    public  static  Accountdto mapToAccountdto(Account account){
        Accountdto accountdto=new Accountdto(
                account.getId(),
                account.getAccountholdername(),
                account.getBalence()
        );
        return  accountdto;
    }
}
