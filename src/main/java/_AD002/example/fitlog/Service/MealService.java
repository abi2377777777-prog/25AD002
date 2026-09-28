package _AD002.example.fitlog.Service;

import _AD002.example.fitlog.Model.Meal;
import _AD002.example.fitlog.Repository.MealRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Meal createMeal(Meal data) {
        Meal result = mealRepository.save(data);
        return result;
    }

    public void updateById(Long id, Meal data) {
        if (!mealRepository.existsById(id)) {
            throw new RuntimeException("Meal not found");
        }

        data.setId(id);
        mealRepository.save(data);
    }

    public void deleteById(Long id) {
        if(!mealRepository.existsById(id))
        {
            throw new RuntimeException("Meal not found");
        }
        mealRepository.deleteById(id);
    }

    public List<Meal> getAllMeal() {
        return mealRepository.findAll();
    }

    public Meal getById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
    }
}
