package _AD002.example.fitlog.Repository;

import _AD002.example.fitlog.Model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkoutRepository extends JpaRepository<Workout,Long>{

}
