package _AD002.example.fitlog.Controller;

import _AD002.example.fitlog.Model.User;
import _AD002.example.fitlog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @PutMapping("/updateById/{id}")
    ResponseEntity<String> updateById(
            @PathVariable Long id,
            @RequestBody User data) {

        try {
            userService.updateById(id, data);

            return new ResponseEntity<>(
                    "User updated successfully",
                    HttpStatus.OK);

        } catch (RuntimeException exception) {

            return new ResponseEntity<>(
                    "User not found",
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(
                    "User deleted sucessfully",
                    HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(
                    "User not found",
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/getall")
    ResponseEntity<List<User>> getall() {
        return new ResponseEntity<>(
                userService.updateUser(data),
                HttpStatus.OK
        );
    }

    
}
