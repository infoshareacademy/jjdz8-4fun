package pl.fourfun.accountaccess;

import java.util.Scanner;

public class Registration {
    Scanner scanner = new Scanner(System.in);
    private boolean isTrue = true;
    private boolean isReturn = false;
    private boolean isRegistrationValid = true;
    private String isYes = "";
    private int choose = 1;

    // ----------------- Registration methods -----------------
    public void userSetName(User user) {

        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("1. First name: ");
                String name = scanner.nextLine();
                user.setName(name);
                System.out.println(user);
                System.out.println("Your name is: " + name);
                System.out.println("Is it correct? (y/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("y") || isYes.equals("Y")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetLastName(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("2. Last name: ");
                String lastName = scanner.nextLine();
                user.setLastName(lastName);
                System.out.println(user);
                System.out.println("Your last name is: " + lastName);
                System.out.println("Is it correct? (y/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("y") || isYes.equals("Y")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetPhoneNumber(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("3. Phone number: ");
                String phoneNumber = scanner.nextLine();
                user.setPhoneNumber(phoneNumber);
                System.out.println(user);
                System.out.println("Your phone number is: " + phoneNumber);
                System.out.println("Is it correct? (y/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("y") || isYes.equals("Y")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetEmail(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("4. Email: ");
                String email = scanner.nextLine();
                user.setEmail(email);
                System.out.println(user);
                System.out.println("Your email is: " + email);
                System.out.println("Is it correct? (y/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("y")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetPassword(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("5. Password: ");
                String password = scanner.nextLine();
                user.setPassword(password);
                System.out.println(user);
                System.out.println("Your password is: " + password);
                System.out.println("Is it correct? (y/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("y") || isYes.equals("Y")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }
}
