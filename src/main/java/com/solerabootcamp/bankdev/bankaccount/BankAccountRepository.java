package com.solerabootcamp.bankdev.bankaccount;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class BankAccountRepository {

    private BankAccountsData bankAccounts;

    public BankAccountRepository() {
        this.bankAccounts =  new BankAccountsData();
    }

    public List<BankAccount> getBankAccounts() {
        return this.bankAccounts.getBankAccounts();
    }

    public BankAccount getOne(int id) {
        BankAccount bankAccount = this.bankAccounts.getBankAccounts().stream().filter(streamBankAccount -> streamBankAccount.getId() == id).findFirst().get();
        return bankAccount;
    }

    public int getDataCount() {
        return this.bankAccounts.getCount();
    }

    public BankAccount create(CreateBankAccountDto createBankAccountDto) {
        BankAccount bankAccount = new BankAccount(getDataCount(), createBankAccountDto.userId, createBankAccountDto.name);
        this.bankAccounts.setUsers(Stream.concat(this.bankAccounts.getBankAccounts().stream(), Stream.of(bankAccount)).toList());
        return bankAccount;
    }
}
