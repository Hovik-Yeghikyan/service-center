package am.itspace.servicecenter.repository;

import am.itspace.servicecenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
