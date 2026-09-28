package _AD002.example.fitlog.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Workout {
    @Id
    @GeneratedValue
    Long id;
    Integer duration;
    Integer caloriesburnt;
    String wktype;
}
