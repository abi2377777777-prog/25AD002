package _AD002.example.fitlog.Controller;

import _AD002.example.fitlog.Model.Workout;
import _AD002.example.fitlog.Repository.WorkoutRepository;
import _AD002.example.fitlog.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fitlog/workout")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;
    @Autowired
    private WorkoutRepository workoutRepository;

    @PostMapping("/create")
    ResponseEntity<Workout> createWorkout(@RequestBody Workout body) {
        return new ResponseEntity<>(
                workoutService.createWorkout(body),
                HttpStatus.CREATED);
    }

    @PutMapping("/updateById/{id}")
    ResponseEntity<String> updateById(
            @PathVariable Long id,
            @RequestBody Workout data) {

        try {
            workoutService.updateById(id, data);

            return new ResponseEntity<>(
                    "Workout updated successfully",
                    HttpStatus.OK);

        } catch (RuntimeException exception) {

            return new ResponseEntity<>(
                    "Workout not found",
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            workoutService.deleteById(id);
            return new ResponseEntity<>(
                    "Workout deleted sucessfully",
                    HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(
                    "Workout not found",
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/getall")
    ResponseEntity<List<Workout>> getall() {
        return new ResponseEntity<>(
                workoutService.getAllWorkout(),
                HttpStatus.OK
        );
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getbyId(@PathVariable long id) {
        try {
            Workout response = workoutService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
}
