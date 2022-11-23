package com.solerabootcamp.bankdev.bankaccount;

import com.solerabootcamp.bankdev.user.Data;
import com.solerabootcamp.bankdev.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BankAccountDataTests {

    private final BankAccountsData bankAccountsData = new BankAccountsData();

    @Test
    public void Data_WhenGetAfterCreation_ReturnsBankAccountsAndThirdIsExpected() {
        List<BankAccount> bankAccounts = this.bankAccountsData.getUsers();
        int usersCount = this.bankAccountsData.getCount();

        BankAccount thirdBankAccount = bankAccounts.stream().filter(streamUser -> streamUser.getId() == 3).findFirst().get();

        assertEquals(9, usersCount);
        assertEquals(3, thirdBankAccount.getId());
        assertEquals("Prueba 3", thirdBankAccount.getName());
    }
}
