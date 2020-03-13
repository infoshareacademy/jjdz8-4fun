package pl.fourfun;


import pl.fourfun.access.LoginService;
import pl.fourfun.access.RegistrationService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner inputValue = new Scanner(System.in);


    public static void showMainMenu() throws IOException, InterruptedException {

        int chosenMainMenuNumber = 0;

        clearMenu();
        menu();

        do {
            try {
                System.out.println("\nWybierz opcję która cię interesuje:");
                chosenMainMenuNumber = inputValue.nextInt();

            } catch (Exception e) {
                inputValue.next();
            }
        }
        while (4 < chosenMainMenuNumber || chosenMainMenuNumber < 1);

        switch (chosenMainMenuNumber) {
            case 1:
                clearMenu();
                optionOneMainMenu();
                break;
            case 2:
                clearMenu();
                optionTwoMainMenu();
                break;
            case 3:
                clearMenu();
                optionThreeMainMenu();
                break;
            case 4:
                System.exit(0);
        }
    }


    static void menu() {
        System.out.print("Witaj w naszym programie! \n1. Zarejestruj nowego użytkownika \n2. Zaloguj się jako użytkownik\n3. Zakończ działanie aplikacji \n");
    }

    static void optionOneMainMenu() throws IOException, InterruptedException {
        RegistrationService.registration();
    }

    static void optionTwoMainMenu() throws IOException, InterruptedException {
        LoginService.login();
    }

    static void optionThreeMainMenu() throws IOException {

    }

    public static void clearMenu() {
        //Clear zastąpiony przez myślniki
        System.out.println("----------------------------------------------------------------");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("\n");
    }


}

