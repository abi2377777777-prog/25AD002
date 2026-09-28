package _AD002.example.fitlog.Service;

import _AD002.example.fitlog.Model.User;
import _AD002.example.fitlog.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User data) {
        User result = userRepository.save(data);
        return result;
    }

    public void updateById(Long id, User data) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        data.setId(id);
        userRepository.save(data);
    }

    public void deleteById(Long id) {
        if(!userRepository.existsById(id))
        {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }


}
