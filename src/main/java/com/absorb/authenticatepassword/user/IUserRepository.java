package com.absorb.authenticatepassword.user;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer>{
    public User findByUsername(String username);
}
