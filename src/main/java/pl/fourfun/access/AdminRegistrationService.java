package pl.fourfun.access;

public class AdminRegistrationService {


    public static void adminRegistration() {
        Admins admins = JsonConverterAdmins.readAdminsJsonFile();
        Admin admin = new Admin("admin", "admin", "666666666", "admin@gmail.com", "admin");
        Admin admin2 = new Admin("admin2", "admin2", "222222222", "admin2@gmail.com", "admin2");
        Admin admin3 = new Admin("admin3", "admin3", "333333333", "admin3@gmail.com", "admin3");
        admins.add(admin);
        admins.add(admin2);
        admins.add(admin3);
        JsonConverterAdmins.saveAdminsToJsonFile(admins);
    }
}
