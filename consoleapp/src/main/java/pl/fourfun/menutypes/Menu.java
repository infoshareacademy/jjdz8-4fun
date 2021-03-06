package pl.fourfun.menutypes;


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
        while (3 < chosenMainMenuNumber || chosenMainMenuNumber < 1);

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
                System.exit(0);
                break;
        }
    }


    static void menu() {
        System.out.print("Witaj w naszym programie! " +
                "\n1. Zaloguj się" +
                "\n2. Zarejestruj się " +
                "\n3. Zakończ działanie aplikacji \n");
    }


    static void optionOneMainMenu() throws IOException, InterruptedException {
        LoginService.userLogin();
    }

    static void optionTwoMainMenu() throws IOException, InterruptedException {
        RegistrationService.registration();
    }

    public static void clearMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}

