package com.solerabootcamp.bankdev.bankaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTests {

    @InjectMocks
    private BankAccountService service = new BankAccountService();

    @Mock
    private BankAccountRepository repo;

    @Test
    public void BankAccountService_WhenCreate_CreatesBankAccountAndLinksItToUser() {
        CreateBankAccountDto createBankAccountDto = new CreateBankAccountDto();
        createBankAccountDto.name = "Cuenta 1";
        createBankAccountDto.userId = 1;

        BankAccount bankAccount = new BankAccount(0, createBankAccountDto.userId, createBankAccountDto.name);

        BankAccount actualResult = this.service.create(createBankAccountDto);
        assertEquals(bankAccount, actualResult);
    }

    @Test
    public void BankAccountService_WhenDelete_ReturnsBankAccountsListWithoutDeleted() {
        DeleteBankAccountDto deleteBankAccountDto = new DeleteBankAccountDto();
        deleteBankAccountDto.id = 0;

        List<BankAccount> bankAccounts;

        BankAccount bankAccount1 = new BankAccount(0, 2, "Cuenta 1");
        BankAccount bankAccount2 = new BankAccount(1, 2, "Cuenta 2");
        BankAccount bankAccount3 = new BankAccount(2, 3, "Cuenta 3");
        BankAccount bankAccount4 = new BankAccount(3, 4, "Cuenta 4");
        BankAccount bankAccount5 = new BankAccount(4, 5, "Cuenta 5");

        bankAccounts = new ArrayList<>();

        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);
        bankAccounts.add(bankAccount4);
        bankAccounts.add(bankAccount5);

        Mockito.when(this.repo.getBankAccounts()).thenReturn(bankAccounts);

        List<BankAccount> actualBankAccounts = this.service.delete(deleteBankAccountDto);

        assertEquals(4, actualBankAccounts.size());
    }
}
