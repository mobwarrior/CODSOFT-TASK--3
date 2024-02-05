import java.util.Scanner;

class bAccount{
    private double balance;

    public bAccount(double balance) {
        this.balance = balance;
    }

    public String deposit(double amount) {
        balance += amount;
        return String.format("Deposit of $%.2f successful. Current balance: $%.2f", amount, balance);
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient funds. Withdrawal failed.";
        }
        balance -= amount;
        return String.format("Withdrawal of $%.2f successful. Current balance: $%.2f", amount, balance);
    }

    public String checkBalance() {
        return String.format("Current balance: $%.2f", balance);
    }
}

class ATM {
    private bAccount userAccount;
    Scanner scanner;

    public ATM(bAccount userAccount) {
        this.userAccount = userAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                System.out.println(userAccount.withdraw(withdrawAmount));
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                System.out.println(userAccount.deposit(depositAmount));
                break;
            case 3:
                System.out.println(userAccount.checkBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class Task3{
    public static void main(String[] args) {
        bAccount userAccount = new bAccount(1000);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Select an option (1-4): ");
            int selectedOption = atm.scanner.nextInt();
            atm.processOption(selectedOption);
        }
    }
}
