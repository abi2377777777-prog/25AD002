package _AD002.example.fitlog.Controller;

import _AD002.example.fitlog.Model.Meal;
import _AD002.example.fitlog.Repository.MealRepository;
import _AD002.example.fitlog.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fitlog/meal")
public class MealController {
    @Autowired
    private MealService mealService;
    @Autowired
    private MealRepository mealRepository;

    @PostMapping("/create")
    ResponseEntity<Meal> createMeal(@RequestBody Meal body) {
        return new ResponseEntity<>(
                mealService.createMeal(body),
                HttpStatus.CREATED);
    }

    @PutMapping("/updateById/{id}")
    ResponseEntity<String> updateById(
            @PathVariable Long id,
            @RequestBody Meal data) {

        try {
            mealService.updateById(id, data);

            return new ResponseEntity<>(
                    "Meal updated successfully",
                    HttpStatus.OK);

        } catch (RuntimeException exception) {

            return new ResponseEntity<>(
                    "Meal not found",
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            mealService.deleteById(id);
            return new ResponseEntity<>(
                    "Meal deleted sucessfully",
                    HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(
                    "Meal not found",
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/getall")
    ResponseEntity<List<Meal>> getall() {
        return new ResponseEntity<>(
                mealService.getAllMeal(),
                HttpStatus.OK
        );
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getbyId(@PathVariable long id) {
        try {
            Meal response = mealService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
}
