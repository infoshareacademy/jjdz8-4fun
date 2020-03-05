package pl.fourfun.menutypes;

import java.util.Scanner;

import static pl.fourfun.menutypes.Menu.clearMenu;

public class AdministratorMenu {
    static Scanner inputAdminValue = new Scanner(System.in);

    public static void showAdminMenu() {
        while (true) {

            int chosenAdminMenuNumber = 0;

            //clearMenu();
            adminMenu();

            do {
                try {
                    System.out.println("\nWybierz czynność:");
                    chosenAdminMenuNumber = inputAdminValue.nextInt();

                } catch (Exception e) {
                    inputAdminValue.next();
                }
            }

            while ((3 < chosenAdminMenuNumber) || (chosenAdminMenuNumber < 0));

            switch (chosenAdminMenuNumber) {
                case 1:
                    clearMenu();
                    //Tu bedzie opcja dodania produktu
                case 2:
                    optionTwoAdminMenu();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void adminMenu() {
        System.out.print("(Po zalogowaniu) \nWitaj Adminie! Poniżej masz zakres czynności do wyboru: \n1. Dodaj produkt \n2. Edytuj produkt \n3. Wróć do menu głównego");
    }

    public static void optionTwoAdminMenu() {
        EditProductMenu.editingProductMethod();
    }
}
