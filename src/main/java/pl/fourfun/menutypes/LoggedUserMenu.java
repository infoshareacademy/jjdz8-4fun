package pl.fourfun.menutypes;

import java.util.Scanner;

import static pl.fourfun.Menu.clearMenu;

public class LoggedUserMenu {
    static Scanner inputAdminValue = new Scanner(System.in);

    public static void showUserMenu() {
        while (true) {

            int chosenUserMenuNumber = 0;

            clearMenu();
            userMenu();

            do {
                try {
                    System.out.println("\nWybierz czynność:");
                    chosenUserMenuNumber = inputAdminValue.nextInt();

                } catch (Exception e) {
                    inputAdminValue.next();
                }
            }

            while ((4 < chosenUserMenuNumber) || (chosenUserMenuNumber < 0));

            switch (chosenUserMenuNumber) {
                case 1:
                    clearMenu();
                    ReadProductMenu.readingProductMenu();
                    break;
                case 2:
                    clearMenu();
                    //Tu będzie metoda, która umożliwi dodawanie produktu
                case 3:
                    EditProductMenu.editingProductMethod();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void userMenu() {
        System.out.print("(Po zalogowaniu) \nUżytkowniku! Poniżej masz zakres czynności do wyboru: \n1. Wyświetl listę produktów \n2. Dodaj produkt \n3. Edytuj produkt \n4. Wróć do menu głównego");
    }
}
