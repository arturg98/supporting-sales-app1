package supportingSalesApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import supportingSalesApp.service.UserService;
import supportingSalesApp.model.AppUser;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model, HttpServletRequest request) {
        model.addAttribute("name", principal.getName());
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "hello";
        } else {
            return "hello2";
        }
    }

    @GetMapping("/sing-up")
    public String singup(Model model) {
        model.addAttribute("user", new AppUser());
        return "sing-up";
    }

    @PostMapping("/register")
    public String register(AppUser appUser) {
        userService.addUser(appUser);
        return "sing-up";
    }
}
