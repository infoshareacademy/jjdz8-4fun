package pl.fourfun.access;

import pl.fourfun.menutypes.Menu;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationService extends User {

    public static void registrationStart() throws IOException, InterruptedException {

        System.out.println("\n" + "ZALÓŻ KONTO" + "\n");
        System.out.println("Aby się zarejestrować, wypełnij poniższe pola:");
        System.out.println("----------------------------------------");

        User user = new User();
        AdminRegistrationService.adminRegistration();
        userRegistration(user);
    }

    public static void userRegistration(User user) throws IOException, InterruptedException {
        Users users = JsonConverterUsers.readUsersJsonFile();


        Scanner scanner;

        boolean isRegistrationValid = true;
        boolean isReturn;
        int choose = 1;
        do {
            Registration registration = new Registration();

            System.out.println("Wybierz numer: ");
            System.out.println("1 Imię: " + user.getName());
            System.out.println("2 Nazwisko: " + user.getLastName());
            System.out.println("3 Numer telefonu: " + user.getPhoneNumber());
            System.out.println("4 Email(to również Twój login): " + user.getEmail());
            System.out.println("5 Hasło: " + user.getPassword());
            System.out.println("6 Zapisz");
            System.out.println("7 Wyjdź");
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
                    registration.userSetName(user);
                    userRegistration(user);
                case 2:
                    registration.userSetLastName(user);
                    userRegistration(user);
                case 3:
                    registration.userSetPhoneNumber(user);
                    userRegistration(user);
                case 4:
                    registration.userSetEmail(user);
                    userRegistration(user);
                case 5:
                    registration.userSetPassword(user);
                    userRegistration(user);
                case 6:
                    scanner = new Scanner(System.in);
                    System.out.println("Twoje konto:");
                    System.out.println(user);
                    System.out.println("Czy to się zgadza? (t/n)");

                    System.out.println("----------------------------------------");
                    String isCorrect = scanner.nextLine();

                    if (isCorrect.equals("t") || isCorrect.equals("T")) {
                        users.add(user);
                        JsonConverterUsers.saveUsersToJsonFile(users);

                        System.out.println("Liczba użytkowników: " + users.getUsers().size());
                        userRegistration(user);
                        System.out.println("Dziękuję, Twoje konto zostało zarejestrowane :)");
                        System.out.println("----------------------------------------");

                    } else {
                        isRegistrationValid = false;
                        userRegistration(user);
            }
                case 7:
                    Menu.showMainMenu();
            }

        } while (!isRegistrationValid) ;
    }
}
