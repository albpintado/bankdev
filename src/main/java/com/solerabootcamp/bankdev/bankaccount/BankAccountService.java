package com.solerabootcamp.bankdev.bankaccount;

import com.solerabootcamp.bankdev.user.UpdateUserDto;
import com.solerabootcamp.bankdev.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class BankAccountService {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private UserService userService;

    public BankAccount getOne(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = this.repo.getOne(bankAccountDto.id);
        return bankAccount;
    }

    public BankAccount create(CreateBankAccountDto createBankAccountDto) {
        BankAccount bankAccount = this.repo.create(createBankAccountDto);
        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.id = createBankAccountDto.userId;
        updateUserDto.bankAccountId = bankAccount.getId();
        this.userService.update(updateUserDto);

        return bankAccount;
    }

    public List<BankAccount> delete(DeleteBankAccountDto deleteBankAccountDto) {
        List<BankAccount> bankAccountsFromRepo = this.repo.getBankAccounts();

        return bankAccountsFromRepo.stream().filter(bankAccount -> bankAccount.getId() != deleteBankAccountDto.id).toList();
    }
}
