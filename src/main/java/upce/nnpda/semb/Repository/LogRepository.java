package upce.nnpda.semb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semb.Entity.Log;

public interface LogRepository extends JpaRepository<Log,Long> {
}
