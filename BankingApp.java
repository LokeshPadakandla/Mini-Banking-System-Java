import java.util.Scanner;

class BankAccount {
    String name;
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    void showDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited. New Balance: ₹" + balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn. New Balance: ₹" + balance);
        }
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n=== Welcome to Simple Bank ===");
            System.out.println("1. Create Account");
            System.out.println("2. Show Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initBal = sc.nextDouble();
                    account = new BankAccount(name, accNum, initBal);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (account != null) {
                        account.showDetails();
                    } else {
                        System.out.println("No account found. Please create one first.");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmt = sc.nextDouble();
                        account.deposit(depositAmt);
                    } else {
                        System.out.println("No account found.");
                    }
                    break;

                case 4:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmt = sc.nextDouble();
                        account.withdraw(withdrawAmt);
                    } else {
                        System.out.println("No account found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Simple Bank. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}





