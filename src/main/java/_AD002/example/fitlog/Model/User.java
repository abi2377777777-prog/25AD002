package _AD002.example.fitlog.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data


public class User {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String email;
    Integer age;
    Integer weight;
    String gender;
    private LocalDate date;



}
