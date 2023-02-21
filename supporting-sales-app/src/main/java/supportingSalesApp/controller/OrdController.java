package supportingSalesApp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import supportingSalesApp.model.AppUser;
import supportingSalesApp.model.Ord;
import supportingSalesApp.service.OrdService;
import supportingSalesApp.service.UserService;

import java.util.List;

@Controller
public class OrdController {

    private UserService userService;
    private OrdService ordService;

    public OrdController(UserService userService, OrdService ordService) {
        this.userService = userService;
        this.ordService = ordService;
    }

    @PostMapping("/createOrder")
    public String createOrder(Ord ord) {
        ordService.addOrd(ord);
        return "created";
    }

    @GetMapping("/order")
    public String order(Model model) {
        List<AppUser> users = userService.showUsers();
        model.addAttribute("users", users);
        return "order";
    }

    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Ord> ords = ordService.showOrders();
        model.addAttribute("ords", ords);
        return "orders";
    }

    @GetMapping("/myorders")
    public String getMyOrders(Model model, @AuthenticationPrincipal AppUser user) {
        List<Ord> myords = ordService.showUserOrders(user);
        model.addAttribute("myords", myords);
        return "myorders";
    }
}
