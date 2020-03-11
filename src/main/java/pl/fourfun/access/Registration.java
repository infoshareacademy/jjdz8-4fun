package pl.fourfun.access;

import java.util.Scanner;

public class Registration {
    Scanner scanner = new Scanner(System.in);
    private boolean isTrue = true;
    private String isYes = "";

    // ----------------- Registration methods -----------------
    public void userSetName(User user) {

        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("1. Imię: ");
                String name = scanner.nextLine();
                user.setName(name);
                System.out.println(user);
                System.out.println("Twoje imię: " + name);
                System.out.println("Czy to się zgadza? (t/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("t") || isYes.equals("T")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetLastName(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("2. Nazwisko: ");
                String lastName = scanner.nextLine();
                user.setLastName(lastName);
                System.out.println(user);
                System.out.println("Twoje nazwisko: " + lastName);
                System.out.println("Czy to się zgadza? (t/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("t") || isYes.equals("T")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetPhoneNumber(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("3. Numer telefonu: ");
                String phoneNumber = scanner.nextLine();
                user.setPhoneNumber(phoneNumber);
                System.out.println(user);
                System.out.println("Twój numer telefonu: " + phoneNumber);
                System.out.println("Czy to się zgadza? (t/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("t") || isYes.equals("T")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetEmail(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("(Email jest również Twoim loginem)");
                System.out.println("4. Email: ");
                String email;
                do {
                    email = scanner.nextLine();
                    if (!Check.checkEmail(email)) {
                        System.out.println("Twój mail jest niepoprawny, spróbuj jeszcze raz::");
                        isTrue = false;
                    } else isTrue = true;
                } while (!isTrue);
                user.setEmail(email);
                System.out.println(user);
                System.out.println("Twój email is: " + email);
                System.out.println("Czy to się zgadza? (t/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if ((isYes.equals("t") || isYes.equals("T")) && Check.checkEmail(email)) {
                    isTrue = true;
                } else isTrue = false;
                System.out.println("Nieprawidłowy email");
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetPassword(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("5. Hasło: ");
                String password = scanner.nextLine();
                user.setPassword(password);
                System.out.println(user);
                System.out.println("Twoje hasło: " + password);
                System.out.println("Czy to się zgadza? (t/n)");
                System.out.println("----------------------------------------");
                isYes = scanner.nextLine();
                if (isYes.equals("n")) {
                    isTrue = false;
                } else if (isYes.equals("t") || isYes.equals("T")) {
                    isTrue = true;
                } else isTrue = false;
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość");
                isTrue = false;
            }
        } while (!isTrue);
    }
}
