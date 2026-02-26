import java.io.*;
import java.util.*;

public class BankSystem {

    static final String FILE_NAME = "accounts.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n====== BANK MANAGEMENT SYSTEM ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> {
                    System.out.println("Thank You!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    // 🔹 Create Account
    public static void createAccount() {
        try {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            if (accountExists(accNo)) {
                System.out.println("Account already exists!");
                return;
            }

            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(accNo + "," + name + "," + balance + "\n");
            fw.close();

            System.out.println("Account Created Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Deposit
    public static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        updateBalance(accNo, amount, true);
    }

    // 🔹 Withdraw
    public static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();

        updateBalance(accNo, amount, false);
    }

    // 🔹 Check Balance
    public static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int fileAccNo = Integer.parseInt(data[0]);

                if (fileAccNo == accNo) {
                    System.out.println("Name: " + data[1]);
                    System.out.println("Balance: " + data[2]);
                    br.close();
                    return;
                }
            }

            br.close();
            System.out.println("Account Not Found!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Update Balance
    public static void updateBalance(int accNo, double amount, boolean isDeposit) {
        try {
            File inputFile = new File(FILE_NAME);
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int fileAccNo = Integer.parseInt(data[0]);

                if (fileAccNo == accNo) {
                    double balance = Double.parseDouble(data[2]);

                    if (!isDeposit && balance < amount) {
                        System.out.println("Insufficient Balance!");
                        br.close();
                        bw.close();
                        tempFile.delete();
                        return;
                    }

                    balance = isDeposit ? balance + amount : balance - amount;
                    bw.write(accNo + "," + data[1] + "," + balance);
                    found = true;
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found)
                System.out.println("Transaction Successful!");
            else
                System.out.println("Account Not Found!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Check if Account Exists
    public static boolean accountExists(int accNo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == accNo) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (Exception ignored) {}

        return false;
    }
}