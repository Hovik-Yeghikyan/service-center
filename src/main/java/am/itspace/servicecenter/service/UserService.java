package am.itspace.servicecenter.service;

import am.itspace.servicecenter.entity.User;

import java.util.List;

public interface UserService {

     User save(User user);

    List<User> findAll();

    User findByEmail(String email);

}

