package ATM;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank("MyBank");

        Account acc1 = new Account("123456", "1111", 1000.0, myBank);
        Account acc2 = new Account("789012", "2222", 500.0, myBank);

        myBank.addAccount(acc1);
        myBank.addAccount(acc2);

        ATM atm1 = new ATM("ATM001", "123 Street", myBank);
        ATM atm2 = new ATM("ATM002", "456 Avenue", myBank);
        ATM atm3 = new ATM("ATM003", "789 Boulevard", myBank);

        myBank.addATM(atm1);
        myBank.addATM(atm2);
        myBank.addATM(atm3);

        System.out.println("Initial balance of account 1: " + acc1.getBalance());

        boolean success = atm1.withdrawMoney("1111", 200.0);
        System.out.println("Withdrawal successful: " + success);

        System.out.println("Updated balance of account 1: " + acc1.getBalance());
    }
}

