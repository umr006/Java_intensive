package ex05;

import java.util.Scanner;

public class Program {

    static Scanner in = new Scanner(System.in);
    static TransactionsService service = new TransactionsService();
    public static void devMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. DEV – remove a transfer by ID");
        System.out.println("6. DEV – check transfer validity");
        System.out.println("7. Finish execution");
        System.out.println("-----------------------------------------------");
    }

    public static void productionMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. Finish execution");
        System.out.println("-----------------------------------------------");
    }

    public static void addUser() {
        System.out.println("Enter a user name and a balance");
        try {
            String name = in.next();
            int balance = in.nextInt();
            service.addUserInArray(name, balance);
            System.out.println("User with id = " + service.usersArrayTransactionsService.retrieveNumberOfUsers() + "added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        String[] newArgs = {"--profile=dev"};
        args = newArgs;
        int mode = 0;

        System.out.println(args[0]);

        if (args[0].equals("--profile=dev"))
            mode = 1;
        else if (args[0].equals("--profile=production"))
            mode = 2;
        else {
            System.out.println("Argument Error!");
            System.exit(1);
        }
        while (true) {
            if (mode == 1) {
                devMenu();
            } else {
                productionMenu();
            }

            int choise = in.nextInt();

            if(choise == 7 && mode == 1 || choise == 5 && mode == 2) {
                break;
            } else if (choise == 1) {
                addUser();
            } else if (choise == 2) {

            } else if (choise == 3) {

            } else if (choise == 4) {

            } else if (choise == 5) {

            } else if (choise == 6) {

            } else if (choise == 7) {

            } else {
                System.out.println("Error"); //to be
            }
        }
    }
}
