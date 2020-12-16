package app.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String getLoginPage() {
        // можно добавить Model, чтоб обслуживать данные,
        // но щас просто вернем имя вьюхи
        return "login";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }
}
