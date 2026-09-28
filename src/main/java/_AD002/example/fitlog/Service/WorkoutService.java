package _AD002.example.fitlog.Service;

import _AD002.example.fitlog.Model.Workout;
import _AD002.example.fitlog.Repository.WorkoutRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout createWorkout(Workout data) {
        Workout result = workoutRepository.save(data);
        return result;
    }

    public void updateById(Long id, Workout data) {
        if (!workoutRepository.existsById(id)) {
            throw new RuntimeException("Workout not found");
        }

        data.setId(id);
        workoutRepository.save(data);
    }

    public void deleteById(Long id) {
        if(!workoutRepository.existsById(id))
        {
            throw new RuntimeException("Workout not found");
        }
        workoutRepository.deleteById(id);
    }

    public List<Workout> getAllWorkout() {
        return workoutRepository.findAll();
    }

    public Workout getById(Long id) {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
    }
}