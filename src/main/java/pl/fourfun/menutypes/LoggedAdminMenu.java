package pl.fourfun.menutypes;

import pl.fourfun.readwriteproducts.AddProductJson;

import java.io.IOException;
import java.util.Scanner;

import static pl.fourfun.menutypes.Menu.clearMenu;

public class LoggedAdminMenu {
    static Scanner inputAdminValue = new Scanner(System.in);

    public static void showAdminMenu() throws IOException, InterruptedException {
        while (true) {

            int chosenAdminMenuNumber = 0;

            clearMenu();
            adminMenu();

            do {
                try {
                    System.out.println("\nAdminie wybierz czynność:");
                    chosenAdminMenuNumber = inputAdminValue.nextInt();

                } catch (Exception e) {
                    inputAdminValue.next();
                }
            }

            while ((4 < chosenAdminMenuNumber) || (chosenAdminMenuNumber < 0));

            switch (chosenAdminMenuNumber) {
                case 1:
                    clearMenu();
                    ReadProductMenu.readingProductMenu();
                    break;
                case 2:
                    clearMenu();
                    AddProductJson.addProductJson();
                    break;
                case 3:
                    EditProductMenu.editingProductMethod();
                    break;
                case 4:
                    Menu.showMainMenu();
                    break;
            }
        }
    }

    public static void adminMenu() {
        System.out.print("\nAdminie! Poniżej masz zakres czynności do wyboru: \n1. Wyświetl listę produktów \n2. Dodaj produkt \n3. Edytuj produkt \n4. Wróć do menu głównego");
    }
}
