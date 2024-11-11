package com.javaguides.banking_app.controller;

import com.javaguides.banking_app.Entity.Account;
import com.javaguides.banking_app.dto.Accountdto;
import com.javaguides.banking_app.mapper.Accountmapper;
import com.javaguides.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return  new ResponseEntity<>(accountService.createaccount(accountdto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Accountdto> getAccountById(@PathVariable  Long id){
        Accountdto accountdto=accountService.getAccountByid(id);
        return  ResponseEntity.ok(accountdto);
    }
    @PutMapping("/{id}/deposit")
    public  ResponseEntity<Accountdto> deposit(@PathVariable  long id,
                                               @RequestBody  Map<String,Double> request){
        Double amount=request.get("amount");
        Accountdto accountdto=accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountdto);

    }

    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<Accountdto> withdraw(@PathVariable  long id,
                                               @RequestBody  Map<String,Double> request){
        Double amount=request.get("amount");
        Accountdto accountdto=accountService.withdraw(id,request.get("amount"));
        return ResponseEntity.ok(accountdto);

    }
    @GetMapping
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto>accounts=accountService.getAllAccounts();
        return  ResponseEntity.ok(accounts);

    }
    @DeleteMapping("/{id}")

    public  ResponseEntity<String> deleteAccount(@PathVariable  Long id){
        accountService.deleteAcoount(id);
        return  ResponseEntity.ok("Account is successfully deleted");
    }





}
