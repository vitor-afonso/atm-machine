import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        double checkingBalance = 0;
        double savingsBalance = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- Wellcome -----------");
        verifyUser(scanner);
        
        while (true) {
            // select account until exit choice
            byte userAccountChoice = selectAccount(scanner);
            
            switch(userAccountChoice) {
                case 1:
                    checkingBalance = getChosenAccount(scanner, checkingBalance, "CHECKING");
                    break;
                case 2:
                    savingsBalance = getChosenAccount(scanner, savingsBalance, "SAVINGS");
                    break;
                case 3:
                    System.out.println("Thank you for using this ATM, bye.");
                    break;
    
                default:
                    System.out.println("------------------------------------------");
                    System.out.println("Invalid choice. Type a number between (1-3)");
                    System.out.println("------------------------------------------");
            }

            if(userAccountChoice == 3){
                break;
            }
        }
    }

    static void verifyUser(Scanner scanner) {
        final int accountNumber = 851207;
        final int accountPin = 1234;
        while (true) {
            try {
                System.out.print("Please enter your account number:");
                int userAccountNumber = scanner.nextInt();
                System.out.print("Please enter your pin number:");
                int userPinNumber = scanner.nextInt();
                if (accountNumber == userAccountNumber && userPinNumber == accountPin) {
                    break;
                }
                System.out.println("------------------------------------------");
                System.out.println("Wrong account number or pin number.");
                System.out.println("------------------------------------------");
            } catch (Exception e) {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("Invalid input. Please enter valid numbers.");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                // Clear scanner buffer
                scanner.nextLine();
            }
        }
    }

    static byte selectAccount(Scanner scanner) {
        while(true) {
            try {
                System.out.println("------------ SELECT ACCOUNT --------------");
                System.out.println("Please select account you want to access:");
                System.out.println("Type 1 - Checking account");
                System.out.println("Type 2 - Savings account");
                System.out.println("Type 3 - Exit");
                System.out.print("Choice:");
                byte userAccountChoice = scanner.nextByte();
                if(userAccountChoice > 0 && userAccountChoice < 4){
                    return userAccountChoice;
                }
                System.out.println("------------------------------------------");
                System.out.println("Invalid choice. Type a number between (1-3)");
                System.out.println("------------------------------------------");
                
            } catch (Exception e) {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("Invalid input. Please enter valid number.");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                // Clear scanner buffer
                scanner.nextLine();
            }
        }
    }

    static double getChosenAccount(Scanner scanner, double accountBalance, String accountName) {
        while(true) {
            try {
                byte selectedAccountOption = selectAccountOptions(scanner, accountName);
                accountBalance = runAccountChoice( scanner, selectedAccountOption, accountBalance);
                if(selectedAccountOption == 4) {
                    return accountBalance;
                }
            } catch (Exception e) {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("Invalid input. Please enter valid number.");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                // Clear scanner buffer
                scanner.nextLine();
            }
        }
    }

    static byte selectAccountOptions(Scanner scanner, String accountName) {
        while(true) {
            
            System.out.println("------------ " + accountName + " ACCOUNT --------------");
            System.out.println("Type 1 - View balance");
            System.out.println("Type 2 - Withdraw");
            System.out.println("Type 3 - Deposit");
            System.out.println("Type 4 - Exit");
            System.out.print("Choice:");
            byte userOptionChoice = scanner.nextByte();
            return userOptionChoice;
                
        }
    }

    static double runAccountChoice(Scanner scanner, byte userOptionChoice, double balance){
        
        switch (userOptionChoice) {
            case 1:
                System.out.println("Account balance: " +  NumberFormat.getCurrencyInstance().format(balance));
                
                break;
            case 2:
                while(true){
                    if(balance == 0){
                        System.out.println("------------------------------------------");
                        System.out.println("Empty account. Make a deposit.");
                        System.out.println("------------------------------------------");
                        break;
                    }
                    
                    System.out.print("Enter amount to withdraw:");
                    int amountToWithdraw = scanner.nextInt();
                    if ( balance - amountToWithdraw >= 0){
                        balance -= amountToWithdraw;
                        System.out.println("Account balance: " + NumberFormat.getCurrencyInstance().format(balance));
                        break;
                    }
                    System.out.println("You dont have the funds to perform the operation.");
                }
                break;
            case 3:
                while(true){
                    System.out.print("Enter amount to deposit:");
                    int amountToDeposit = scanner.nextInt();
                    if ( amountToDeposit > 0){
                        balance += amountToDeposit;
                        System.out.println("Account balance: " +  NumberFormat.getCurrencyInstance().format(balance));
                        break;
                    }
                    System.out.println("------------------------------------------");
                    System.out.println("Invalid amount.");
                    System.out.println("------------------------------------------");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("------------------------------------------");
                System.out.println("Invalid choice. Type a number between (1-4)");
                System.out.println("------------------------------------------");
        }
        return balance;
    }
}
