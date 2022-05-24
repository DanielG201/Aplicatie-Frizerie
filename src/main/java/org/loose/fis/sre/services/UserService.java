package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FoundUserException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.models.User;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("users.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void findUser(String username, String password) throws FoundUserException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                if (Objects.equals(password, user.getPassword()))
                    throw new FoundUserException();
            }
        }
    }

    public static void addUser(String username, String password, String rol, String numeComplet, String adresa, String email, String nrTel) throws UsernameAlreadyExistsException {
        oldUser(username);
        userRepository.insert(new User(username, password, rol, numeComplet, adresa, email, nrTel));
    }
    private static void oldUser(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }
}
