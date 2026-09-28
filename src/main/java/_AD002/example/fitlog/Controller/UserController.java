package _AD002.example.fitlog.Controller;

import _AD002.example.fitlog.Model.User;
import _AD002.example.fitlog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fitlog")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    ResponseEntity<User> createuser(@RequestBody User body) {
        return new ResponseEntity<>(
                userService.createUser(body),
                HttpStatus.CREATED);
    }

}
