package com.absorb.authenticatepassword.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }
    
    @Override
    public User createUser(User user) {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setPassword(passwordEncoder.encode(user.getPassword()));
        return iUserRepository.save(u);
    }

    @Override
    public boolean authenticate(User user) {
        User u = findByUsername(user.getUsername());
        return passwordEncoder.matches(user.getPassword(), u.getPassword());
    }
}
