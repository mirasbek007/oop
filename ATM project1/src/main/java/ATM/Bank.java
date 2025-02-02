package ATM;

import java.util.*;

class Bank {
    private String name;
    private List<Account> accounts;
    private List<ATM> atms;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.atms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<ATM> getAtms() {
        return atms;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void addATM(ATM atm) {
        atms.add(atm);
    }
}

