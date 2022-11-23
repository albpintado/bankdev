package com.solerabootcamp.bankdev.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank-account")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    @GetMapping()
    public BankAccount getOne(@RequestBody BankAccountDto bankAccountDto) {
        return this.service.getOne(bankAccountDto);
    }

    @PostMapping()
    public BankAccount create(@RequestBody CreateBankAccountDto createBankAccountDto) {
        return this.service.create(createBankAccountDto);
    }
}
