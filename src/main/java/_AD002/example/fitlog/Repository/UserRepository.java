package _AD002.example.fitlog.Repository;

import _AD002.example.fitlog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>{

}
