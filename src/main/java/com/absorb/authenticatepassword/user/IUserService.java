package com.absorb.authenticatepassword.user;

public interface IUserService {
    public User findByUsername(String username);
    public User createUser(User user);
    public boolean authenticate(User user);
}
