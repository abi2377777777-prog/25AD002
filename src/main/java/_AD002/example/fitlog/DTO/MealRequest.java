package _AD002.example.fitlog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealRequest {
    private Integer carb;
    private Integer protein;
    private Integer fibre;
    private Integer intakecalories;
}
