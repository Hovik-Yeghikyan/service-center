package am.itspace.servicecenter.controller;

import am.itspace.servicecenter.entity.User;
import am.itspace.servicecenter.entity.UserType;
import am.itspace.servicecenter.security.SpringUser;
import am.itspace.servicecenter.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;


    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "msg", required = false) String msg, ModelMap modelMap) {
        if (msg != null && !msg.isEmpty()) {
            modelMap.addAttribute("msg", msg);
        }
        return "loginPage";
    }



    @PostMapping("/loginPage")
    public String userRegister(@ModelAttribute User user) {
        User byEmail = userService.findByEmail(user.getEmail());
        if (byEmail == null) {
            user.setUserType(UserType.USER);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.register(user);
            log.info("User with {} email registered successfully", user.getEmail());
            return "redirect:/loginPage?msg=User Registered,Please verify your account!";
        } else {
            log.info("User with {} email already registered", user.getEmail());
            return "redirect:/loginPage?msg=Email already in use";
        }
    }


    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal SpringUser springUser) {
        User user = springUser.getUser();
        if (user.getUserType() == UserType.USER) {
            log.info("user {} logged in", user.getEmail());
            return "redirect:/";
        } else {
            return "redirect:/user/home";
        }
    }


    @GetMapping("/user/verify")
    public String verifyUser(@RequestParam("token") String token) {
        User byToken = userService.findByToken(token);
        if (byToken == null) {
            return "redirect:/";
        }
        if (byToken.isActive()) {
            log.error("user already active! {}", byToken.getEmail());
        }

        byToken.setActive(true);
        byToken.setToken(null);
        userService.save(byToken);

        return "redirect:/";
    }
}
