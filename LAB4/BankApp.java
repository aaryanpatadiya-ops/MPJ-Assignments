import java.io.*;
import java.util.*;

class BalanceException extends Exception {
    BalanceException(String msg) {
        super(msg);
    }
}
class CIDException extends Exception {
    CIDException(String msg) {
        super(msg);
    }
}

class User implements Serializable {
    int id;
    String name;
    double bal;

    User(int id, String name, double bal) {
        this.id = id;
        this.name = name;
        this.bal = bal;
    }

    void printInfo() {
        System.out.println("CID: " + id + " | Name: " + name + " | Balance: " + bal);
    }
}

public class BankApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();

    static void newAccount() {
        try {
            System.out.print("Enter CID (1-20): ");
            int id = sc.nextInt();

            if (id < 1 || id > 20)
                throw new CIDException("CID must be between 1 and 20");

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Initial Amount: ");
            double amt = sc.nextDouble();

            if (amt <= 0)
                throw new ArithmeticException("Amount should be positive");

            if (amt < 1000)
                throw new BalanceException("Minimum balance required is 1000");

            users.add(new User(id, name, amt));
            System.out.println("Account Created!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void depositAmt() {
        try {
            System.out.print("Enter CID: ");
            int id = sc.nextInt();

            System.out.print("Enter amount to deposit: ");
            double amt = sc.nextDouble();

            if (amt <= 0)
                throw new ArithmeticException("Invalid amount");

            for (User u : users) {
                if (u.id ==id) {
                    u.bal += amt;
                    System.out.println("Deposit Done!");
                    return;
                }
            }

            System.out.println("No such customer");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void withdrawAmt() {
        try {
            System.out.print("Enter CID: ");
            int id = sc.nextInt();

            System.out.print("Enter amount to withdraw: ");
            double amt = sc.nextDouble();

            for (User u : users) {
                if (u.id ==id) {
                    if (amt > u.bal)
                        throw new ArithmeticException("Insufficient funds");

                    u.bal -= amt;
                    System.out.println("Withdrawal Done!");
                    return;
                }
            }

            System.out.println("Customer not found");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void showUsers() {
        if (users.size() ==0) {
            System.out.println("No data available");
            return;
        }

        for (User u : users) {
            u.printInfo();
        }
    }
    static void saveData() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("records.txt"));
            out.writeObject(users);
            out.close();
            System.out.println("Data saved!");
        } catch (Exception e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int ch;

        do {
            System.out.println("\length--- Bank Menu ---");
            System.out.println("1. New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display All");
            System.out.println("5. Save Records");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1: newAccount(); break;
                case 2: depositAmt(); break;
                case 3: withdrawAmt(); break;
                case 4: showUsers(); break;
                case 5: saveData(); break;
                case 6: System.out.println("Exiting Program"); break;
                default: System.out.println("Invalid Option");
            }

        } while (ch != 6);
    }
}
