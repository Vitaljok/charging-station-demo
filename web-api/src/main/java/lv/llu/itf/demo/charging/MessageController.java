package lv.llu.itf.demo.charging;

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
    public String getUserMessage() {
        return "User message";
    }

    @GetMapping("/admin")
    public String getAdminMessage() {
        return "Admin message";
    }
}
