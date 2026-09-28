package _AD002.example.fitlog.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Goal {
    @Id
    @GeneratedValue
    Long id;
    Integer Gweight;
    Integer period;
    Integer pweight;
    Integer Rweight;
}