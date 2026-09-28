package _AD002.example.fitlog.Service;

import _AD002.example.fitlog.Model.Goal;
import _AD002.example.fitlog.Repository.GoalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoalService {
    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(Goal data) {
        Goal result = goalRepository.save(data);
        return result;
    }

    public void updateById(Long id, Goal data) {
        if (!goalRepository.existsById(id)) {
            throw new RuntimeException("Goal not found");
        }

        data.setId(id);
        goalRepository.save(data);
    }

    public void deleteById(Long id) {
        if(!goalRepository.existsById(id))
        {
            throw new RuntimeException("Goal not found");
        }
        goalRepository.deleteById(id);
    }

    public List<Goal> getAllGoal() {
        return goalRepository.findAll();
    }

    public Goal getById(Long id) {
        return goalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found"));
    }
}