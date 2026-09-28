package _AD002.example.fitlog.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Meal {
    @Id
    @GeneratedValue
    Long id;
    Integer carb;
    Integer protein;
    Integer fibre;
    Integer intakecalories;
}
