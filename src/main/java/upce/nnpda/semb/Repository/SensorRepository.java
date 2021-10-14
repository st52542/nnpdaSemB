package upce.nnpda.semb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semb.Entity.Sensor;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor,Long> {
    List<Sensor> findAllByDevice_Id(Long id);
    Sensor findByDescription(String description);
    List<Sensor> findAll ();
}
