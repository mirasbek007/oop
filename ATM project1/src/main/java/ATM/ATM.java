package ATM;

class ATM {
    private String atmId;
    private String address;
    private Bank bank;

    public ATM(String atmId, String address, Bank bank) {
        this.atmId = atmId;
        this.address = address;
        this.bank = bank;
    }

    public String getAtmId() {
        return atmId;
    }

    public String getAddress() {
        return address;
    }

    public Bank getBank() {
        return bank;
    }

    public boolean withdrawMoney(String pinCode, double amount) {
        for (Account account : bank.getAccounts()) {
            if (account.getPinCode().equals(pinCode)) {
                return account.withdrawFromAccount(amount);
            }
        }
        return false;
    }
}
