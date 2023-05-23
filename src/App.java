import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- Wellcome to VKM Bank -----------");
        verifyUser(scanner);

        double checkingBallance = 0;
        double savingsBallance = 0;

        while (true) {
            // back to select account until exit choice
            byte userAccountChoice = selectAccount(scanner);

            switch(userAccountChoice) {
                case 1:
                    System.out.println("----------- CHECKING ACCOUNT -------------");
                    System.out.println("Type 1 - View balance");
                    System.out.println("Type 2 - Withdraw");
                    System.out.println("Type 3 - Deposit");
                    System.out.println("Type 4 - Exit");
                    System.out.print("Choice:");
                    byte userOptionChoice = scanner.nextByte();
                    switch (userOptionChoice) {
                        case 1:
                            System.out.println("Account balance: " +  NumberFormat.getCurrencyInstance().format(checkingBallance));
                            
                            break;
                        case 2:
                            while(true){
                                if(checkingBallance == 0){
                                    System.out.println("------------------------------------------");
                                    System.out.println("Empty account. Make a deposit.");
                                    System.out.println("------------------------------------------");
                                    break;
                                }
                                System.out.print("Enter amount to withdraw:");
                                int amountToWithdraw = scanner.nextInt();
                                if ( checkingBallance - amountToWithdraw >= 0){
                                    checkingBallance -= amountToWithdraw;
                                    System.out.println("Account balance: " + NumberFormat.getCurrencyInstance().format(checkingBallance));
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
                                checkingBallance += amountToDeposit;
                                System.out.println("Account balance: " +  NumberFormat.getCurrencyInstance().format(checkingBallance));
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
                    break;
                case 2:
                break;
                case 3:
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
        while(true) {

            System.out.print("Please enter your account number:");
            int userAccountNumber = scanner.nextInt();
    
            System.out.print("Please enter your pin number:");
            int userPinNumber = scanner.nextInt();
    
            if(accountNumber == userAccountNumber && userPinNumber == accountPin){
                break;
            }

            System.out.println("Wrong account number or pin number.");

        }
        
    }

    static byte selectAccount(Scanner scanner) {
        
        while(true) {
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
        }
        
    }
}
