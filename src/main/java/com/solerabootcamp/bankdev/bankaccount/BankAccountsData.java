package com.solerabootcamp.bankdev.bankaccount;

import com.solerabootcamp.bankdev.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class BankAccountsData {
    private List<BankAccount> bankAccounts;

    private int count;

    public BankAccountsData() {
        List<String> names = Arrays.asList("Solera", "Luis", "Miguel", "Pedro", "Juan", "Alejandro", "Andrea", "Paola", "Moises");

        BankAccount bankAccount1 = new BankAccount(1, 1, "Cuenta 1");
        BankAccount bankAccount2 = new BankAccount(2, 2, "Cuenta 2");
        BankAccount bankAccount3 = new BankAccount(3, 3, "Cuenta 3");
        BankAccount bankAccount4 = new BankAccount(4, 4, "Cuenta 4");
        BankAccount bankAccount5 = new BankAccount(5, 5, "Cuenta 5");

        this.bankAccounts = new ArrayList<>();

        this.bankAccounts.add(bankAccount1);
        this.bankAccounts.add(bankAccount2);
        this.bankAccounts.add(bankAccount3);
        this.bankAccounts.add(bankAccount4);
        this.bankAccounts.add(bankAccount5);

        this.count = names.size();
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setUsers(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
        this.count = (int) bankAccounts.size();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
