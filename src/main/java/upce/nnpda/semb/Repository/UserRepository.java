package upce.nnpda.semb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semb.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByUuidAndUuidNotNull(String uuid);
}
