package am.itspace.servicecenter.service.Impl;

import am.itspace.servicecenter.entity.User;
import am.itspace.servicecenter.repository.UserRepository;
import am.itspace.servicecenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;
   private final SendMailService sendMailService;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User register(User user) {
        String activationToken = UUID.randomUUID().toString();
        user.setActive(false);
        user.setToken(activationToken);
        User save = userRepository.save(user);
        sendMailService.sendWelcomeMail(user);
        return save;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User findByToken(String token) {
        return userRepository.findByToken(token).orElse(null);
    }
}
