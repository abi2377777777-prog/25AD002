package _AD002.example.fitlog.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutResponse {
    Long id;
    private Integer duration;
    private Integer caloriesburnt;
    private String wktype;
}
