package _AD002.example.fitlog.DTO;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutRequest {
    @Positive(message="Duration can't be negative")
    private int duration;

    @Positive(message="Calories burnt can't be negative")
    private int caloriesburnt;

    private String wktype;
}

