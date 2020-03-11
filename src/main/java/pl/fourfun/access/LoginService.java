package pl.fourfun.access;

import pl.fourfun.Menu;
import pl.fourfun.menutypes.LoggedUserMenu;

import java.io.IOException;
import java.util.Scanner;

public class LoginService extends User {

    static Scanner scanner = new Scanner(System.in);

    public static void login() throws IOException {
        System.out.println("Zaloguj się na konto");
        System.out.println("Wybierz numer: ");
        System.out.println("1 Zaloguj ");
        System.out.println("2 Wyjdź ");

        boolean isReturn;
        int choose = 1;
        do {
            try {
                scanner = new Scanner(System.in);
                choose = scanner.nextInt();
                isReturn = false;
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość, spróbuj jeszcze raz: ");
                isReturn = true;
            }
        } while (isReturn);

        switch (choose) {
            case 1:
                userLogin();
            case 2:
                Menu.showMainMenu();
        }
    }

    public static void userLogin() {
        scanner = new Scanner(System.in);
        Users users = JsonConverterUsers.readUsersJsonFile();
        boolean isLogged = false;
        do {
            System.out.println("Wpisz e-mail:");
            String email = scanner.nextLine();
            System.out.println("Wpisz hasło:");
            String password = scanner.nextLine();

            for (int i = 0; i < users.getUsers().size(); i++) {
                boolean isTrueEmail = users.getUsers().get(i).getEmail().equals(email) && Check.checkEmail(users.getUsers().get(i).getEmail());
                boolean isTruePass = users.getUsers().get(i).getPassword().equals(password);
                if (isTrueEmail && isTruePass) {
                    System.out.println("Logowanie poprawne...");
                    LoggedUserMenu.showUserMenu();
                    isLogged = true;
                    break;
                } else
                    isLogged = false;
            }
            if (isLogged == false) {
                System.out.println("Zły login lub hasło");
            }
        } while (!isLogged);
    }
}





