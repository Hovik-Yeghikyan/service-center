package am.itspace.servicecenter.controller;

import am.itspace.servicecenter.entity.User;
import am.itspace.servicecenter.repository.UserRepository;
import am.itspace.servicecenter.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;


    @GetMapping("/user/register")
    public String userRegisterPage(@RequestParam(value = "msg", required = false) String msg, ModelMap modelMap) {
        if (msg != null && !msg.isEmpty()) {
            modelMap.addAttribute("msg", msg);
        }
        return "register";
    }

    @PostMapping("/user/register")
    public String userRegister(@ModelAttribute User user) {
        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail.isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "redirect:/user/register?msg=User Registered";
        } else {
            return "redirect:/user/register?msg=Email already in use";
        }
    }
}
