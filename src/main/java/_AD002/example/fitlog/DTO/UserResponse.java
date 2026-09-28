package _AD002.example.fitlog.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    Long id;
    private String name;
    private String email;
    private Integer age;
    private Integer weight;
    private String gender;
}
