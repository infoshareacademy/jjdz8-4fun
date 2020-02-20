package pl.fourfun;

import java.util.Scanner;

public class Menu {
    static Scanner inputValue = new Scanner(System.in);

    static void showMainMenu() {
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
        System.out.print("Witaj w naszym programie! \n1. Zarejestruj nowego użytkownika" +
                "\n2. Zaloguj się jako administrator\n3. Zaloguj się jako użytkownik\n4. Zakończ działanie aplikacji \n");
    }

    static void optionOneMainMenu() {
        System.out.println("Tu wyświetli się menu dla nowego użytkownika");
    }

    static void optionTwoMainMenu() {
        System.out.println("Tu wyświetli się menu do logowania administratora");
    }

    static void optionThreeMainMenu() {
        System.out.println("Tu wyświetli się menu do logowania użytkownika");
    }

    static void clearMenu() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }
    }


}

