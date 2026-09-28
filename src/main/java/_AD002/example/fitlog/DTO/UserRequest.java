package _AD002.example.fitlog.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message="Name is required")
    private String name;

    @NotBlank(message="Email is required")
    private String email;

    @Min(value=1,message="Age should be greater than 0")
    @Max(value=120,message="Age is invalid")
    private int age;

    @Positive(message="Weight can't be negative")
    private int weight;

    @NotBlank(message="Gender is required")
    private String gender;
}
