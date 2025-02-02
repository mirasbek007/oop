package ATM;

class Account {
    private String accountNumber;
    private String pinCode;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, String pinCode, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
        this.balance = balance;
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void replenishAccount(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdrawFromAccount(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

