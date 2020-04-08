package pl.fourfun.access;

import pl.fourfun.menutypes.Menu;
import pl.fourfun.menutypes.LoggedUserMenu;

import java.io.IOException;
import java.util.Scanner;

public class LoginService extends User {

    static Scanner scanner = new Scanner(System.in);

    public static void login() throws IOException, InterruptedException {
        System.out.println("Zaloguj się na konto");
        System.out.println("Wybierz numer: ");
        System.out.println("1 Zaloguj jako Administrator ");
        System.out.println("2 Zaloguj jako Użytkownik");
        System.out.println("3 Powrót do menu ");

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
                adminLogin();
            case 2:
                userLogin();
            case 3:
                Menu.showMainMenu();
        }
    }

    public static void userLogin() throws IOException, InterruptedException {
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
    public static void adminLogin() throws IOException, InterruptedException {
        scanner = new Scanner(System.in);
        Admins admins = JsonConverterAdmins.readAdminsJsonFile();
        boolean isLogged = false;
        do {
            System.out.println("Wpisz login(imie Admina):");
            String login = scanner.nextLine();
            System.out.println("Wpisz hasło:");
            String password = scanner.nextLine();

            for (int i = 0; i < admins.getAdmins().size(); i++) {
                boolean isTrueName = admins.getAdmins().get(i).getName().equals(login);
                boolean isTruePass = admins.getAdmins().get(i).getPassword().equals(password);
                if (isTrueName && isTruePass) {
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





