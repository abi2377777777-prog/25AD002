package _AD002.example.fitlog.Controller;

import _AD002.example.fitlog.Model.Goal;
import _AD002.example.fitlog.Repository.GoalRepository;
import _AD002.example.fitlog.Service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fitlog/goal")
public class GoalController {
    @Autowired
    private GoalService goalService;
    @Autowired
    private GoalRepository goalRepository;

    @PostMapping("/create")
    ResponseEntity<Goal> createGoal(@RequestBody Goal body) {
        return new ResponseEntity<>(
                goalService.createGoal(body),
                HttpStatus.CREATED);
    }

    @PutMapping("/updateById/{id}")
    ResponseEntity<String> updateById(
            @PathVariable Long id,
            @RequestBody Goal data) {

        try {
            goalService.updateById(id, data);

            return new ResponseEntity<>(
                    "Goal updated successfully",
                    HttpStatus.OK);

        } catch (RuntimeException exception) {

            return new ResponseEntity<>(
                    "Goal not found",
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            goalService.deleteById(id);
            return new ResponseEntity<>(
                    "Goal deleted sucessfully",
                    HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(
                    "Goal not found",
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/getall")
    ResponseEntity<List<Goal>> getall() {
        return new ResponseEntity<>(
                goalService.getAllGoal(),
                HttpStatus.OK
        );
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getbyId(@PathVariable long id) {
        try {
            Goal response = goalService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
}