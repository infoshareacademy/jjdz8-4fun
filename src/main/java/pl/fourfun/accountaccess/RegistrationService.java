package pl.fourfun.accountaccess;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RegistrationService extends User {

    public static void registration() throws IOException {
        Scanner scanner = new Scanner(System.in);

        User user = new User();
        boolean isTrue = true;
        boolean isRegistrationValid = true;
        String isYes = "";
        int choose = 1;

        System.out.println("\n" + "CREATE AN ACCOUNT" + "\n");
        System.out.println(user);
        System.out.println("To register, fill in the fields below:");
        System.out.println("----------------------------------------");
        do {

            switch (choose) {
                case 1:
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
                case 2:
                    do {
                        try {
                            scanner = new Scanner(System.in);
                            System.out.println("2. Last name: ");
                            String surName = scanner.nextLine();
                            user.setSurName(surName);
                            System.out.println(user);
                            System.out.println("Your last name is: " + surName);
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
                case 3:
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
                case 4:
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
                case 5:
                    do {
                        try {
                            scanner = new Scanner(System.in);
                            System.out.println("5. Password: ");
                            char[] password = new Scanner(System.in).nextLine().toCharArray();
                            user.setPassword(password);
                            System.out.println(user);
                            System.out.println("Your password is: " + String.valueOf(password));
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
                    System.out.println("Your account:");
                    System.out.println(user);
                    System.out.println("Is it correct? (y/n)");
                    System.out.println("----------------------------------------");
                    isYes = scanner.nextLine();
                    if (isYes.equals("y") || isYes.equals("Y")) {
                        isRegistrationValid = true;
                    } else {
                        isRegistrationValid = false;
                        System.out.println("What would you like to change: ");
                        System.out.println("1 First name: " + user.getName());
                        System.out.println("2 Last name: " + user.getSurName());
                        System.out.println("3 Phone number: " + user.getPhoneNumber());
                        System.out.println("4 Email: " + user.getEmail());
                        System.out.println("5 Password: " + String.valueOf(user.getPassword()));
                        choose = scanner.nextInt();
                    }
            }
        } while (!isRegistrationValid);

        List<User> userRegister = register();

        userRegister.add(user);
        File file = new File("user.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.write(String.valueOf(user));
        writer.close();
        System.out.println("Thank you, your account has been registered :)");
        System.out.println("Would you like to register new account? (y/n)");
        isYes = scanner.nextLine();

        user = new User();
        System.out.println("----------------------------------------");
        if (isYes.equals("y") || isYes.equals("Y")) {
            RegistrationService.registration();
        }
    }
    public static List<User> register(User... users) {
        return new ArrayList<User>(Arrays.asList(users));
    }
}