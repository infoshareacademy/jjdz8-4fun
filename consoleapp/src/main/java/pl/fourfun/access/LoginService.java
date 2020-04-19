package pl.fourfun.access;

import pl.fourfun.menutypes.LoggedAdminMenu;
import pl.fourfun.menutypes.LoggedUserMenu;

import java.io.IOException;
import java.util.Scanner;

public class LoginService extends User {

    static Scanner scanner = new Scanner(System.in);

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
                boolean isAdmin = users.getUsers().get(i).isAdmin();
                if (isTrueEmail && isTruePass) {
                    System.out.println("Logowanie poprawne...");
                    if (isAdmin){
                        LoggedAdminMenu.showAdminMenu();
                    }
                    else {
                        LoggedUserMenu.showUserMenu();
                    }
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





