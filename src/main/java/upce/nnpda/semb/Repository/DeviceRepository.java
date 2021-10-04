package upce.nnpda.semb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semb.Entity.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    Optional<Device> findById(Long id);
    Device findByDescription(String description);
    List<Device> findAll();
}
