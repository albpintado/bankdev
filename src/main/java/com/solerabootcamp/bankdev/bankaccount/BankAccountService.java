package com.solerabootcamp.bankdev.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class BankAccountService {

    @Autowired
    private BankAccountRepository repo;

    public BankAccount getOne(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = this.repo.getOne(bankAccountDto.id);
        return bankAccount;
    }

    public int create(CreateBankAccountDto createBankAccountDto) {
        return createBankAccountDto.userId;
    }

    public List<BankAccount> delete(DeleteBankAccountDto deleteBankAccountDto) {
        List<BankAccount> bankAccountsFromRepo = this.repo.getBankAccounts();

        return bankAccountsFromRepo.stream().filter(bankAccount -> bankAccount.getId() != deleteBankAccountDto.id).toList();
    }
}
