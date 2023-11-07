package ru.netology.springbootdemo2.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springbootdemo2.services.*;

import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }

        UserEntity userEntity = userRepository.findByUsername(user);

        if (userEntity == null) {
            throw new UnauthorizedUser("Unknown user " + user);
        }

        String authoritiesString = userEntity.getAuthorities();
        List<Authorities> userAuthorities = Authorities.fromString(authoritiesString);

        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}