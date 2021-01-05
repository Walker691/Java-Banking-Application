import java.util.Scanner;
import java.lang.Math;
public class BankingApplication {

    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount("Nishant", "20000");
        obj1.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }

    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction Occured");
        }
    }

    void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deopsit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
        String option = "";
        do {
            System.out.println("==========================================");
            System.out.println("Enter an Option");
            System.out.println("==========================================");
            System.out.println("\n");
            option = scanner.next();

            switch (option) {
                case "A":
                    System.out.println("----------------------------");
                    System.out.println("Balance=" + balance);
                    System.out.println("----------------------------");
                    System.out.println("/n");
                    break;

                case "B":
                    System.out.println("-----------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("-----------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case "C":
                    System.out.println("------------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("/n");
                    break;

                case "D":
                    System.out.println("-------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Invalid Option!!. Please enter Again");
                    break;
            }
        }
        while (option != "E");
        scanner.close();
        System.out.println("We are glad to Provide our Services");
    }
}