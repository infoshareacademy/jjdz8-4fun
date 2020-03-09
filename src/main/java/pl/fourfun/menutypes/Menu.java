package pl.fourfun.menutypes;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner inputValue = new Scanner(System.in);

    public static void showMainMenu() throws IOException {
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

    static void optionOneMainMenu() {
        System.out.println("Tu wyświetli się menu dla zarejestrownia użytkownika");
    }

    static void optionTwoMainMenu() throws IOException {
        System.out.println("Tu wyświetli się menu do zalogowania użytkowanika");
        LoggedUserMenu.showUserMenu();
    }

    static void optionThreeMainMenu() {
        System.out.println("Tu zakończy się program");
    }

    static void clearMenu() {
        //Clear zastąpiony przez myślniki
        System.out.println("----------------------------------------------------------------");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("\n");
    }
}

