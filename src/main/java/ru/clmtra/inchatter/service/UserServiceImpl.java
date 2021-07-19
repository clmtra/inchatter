package ru.clmtra.inchatter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.clmtra.inchatter.model.User;
import ru.clmtra.inchatter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        userRepository.save(user);
    }
}
