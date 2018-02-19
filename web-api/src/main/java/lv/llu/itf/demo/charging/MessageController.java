package lv.llu.itf.demo.charging;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{id}")
    @PreAuthorize("#id != 100")
    public String getUserMessageDetails(@PathVariable Long id) {
        return "User detailed message: " + id;
    }

    @GetMapping("/admin")
    public String getAdminMessage(Authentication auth) {
        return "Admin message: Hi, " + auth.getName();
    }

    @PostMapping
    public String changeMessages(Authentication auth) {
        return "Changed by  " + auth.getName();
    }
}
