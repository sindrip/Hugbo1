package is.hi.hirslan.repository;

import is.hi.hirslan.model.User;
import is.hi.hirslan.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
    List<UserRole> findByUser (User user);
}
