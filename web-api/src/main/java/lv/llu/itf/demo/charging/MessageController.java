package lv.llu.itf.demo.charging;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @GetMapping("/public")
    public String getPublicMessage() {
        return "Public message";
    }

    @GetMapping("/user")
    public String getUserMessage(Authentication auth) {
        return "User message: Welcome, " + auth.getName();
    }

    @GetMapping("/admin")
    public String getAdminMessage(Authentication auth) {
        return "Admin message: Hi, " + auth.getName();
    }
}
