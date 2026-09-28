package _AD002.example.fitlog.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalResponse {
    Long id;
    private Integer Gweight;
    private Integer period;
    private Integer pweight;
    private Integer Rweight;
}
