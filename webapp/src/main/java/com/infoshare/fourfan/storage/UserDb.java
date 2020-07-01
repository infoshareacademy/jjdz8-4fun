package com.infoshare.fourfan.storage;

import com.infoshare.fourfan.domain.access.User;
import java.util.ArrayList;
import java.util.List;

public class UserDb {

    private static List<User> userRepository = new ArrayList<User>();

    public static List<User> getUserRepository() {
        if (userRepository.size() == 0) {
            fillUserRepository();
        }
        return userRepository;
    }

    private static void fillUserRepository() {

        User user1 = new User();
        user1.setEmail("jan.kowalski@gmail.com");
        user1.setName("Jan");
        user1.setSurName("Kowalski");
        user1.setPhoneNumber("512456999");
        user1.setPassword("password-jan");
        user1.setAdmin(false);
        userRepository.add(user1);

        User user2 = new User();
        user2.setEmail("Katarzyna.Mikowska@outlook.com");
        user2.setName("Katarzyna");
        user2.setSurName("Mikowska");
        user2.setPhoneNumber("511345678");
        user2.setPassword("password-katarzyna");
        user2.setAdmin(false);
        userRepository.add(user2);

        User user3 = new User();
        user3.setEmail("Beata.Dyla@gmail.com");
        user3.setName("Beata");
        user3.setSurName("Dyla");
        user3.setPhoneNumber("500458888");
        user3.setPassword("password-beata");
        user3.setAdmin(false);
        userRepository.add(user3);

        User user4 = new User();
        user4.setEmail("jan.Hryniewicki@gmail.com");
        user4.setName("Jan");
        user4.setSurName("Hryniewicki");
        user4.setPhoneNumber("606543213");
        user4.setPassword("password-janH");
        user4.setAdmin(false);
        userRepository.add(user4);

        User user5 = new User();
        user5.setEmail("admin@wp.pl");
        user5.setName("Admin");
        user5.setSurName("Admin");
        user5.setPhoneNumber("502111333");
        user5.setPassword("password-admin");
        user5.setAdmin(true);
        userRepository.add(user5);

        User user6 = new User();
        user6.setEmail("tomasz.wisniewski@gmail.com");
        user6.setName("Tomasz");
        user6.setSurName("Wisniewski");
        user6.setPhoneNumber("503445667");
        user6.setPassword("password-tomasz");
        user6.setAdmin(false);
        userRepository.add(user6);
    }

    public static boolean contains(User user) {
        List<User> repository = getUserRepository();
        for (User userFromList : repository) {
            if (userFromList.getEmail() == user.getEmail()) {
                return true;
            }
        }
        return false;
    }
}