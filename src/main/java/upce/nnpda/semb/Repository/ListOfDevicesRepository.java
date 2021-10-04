package upce.nnpda.semb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upce.nnpda.semb.Entity.ListOfDevices;

import java.util.List;

public interface ListOfDevicesRepository extends JpaRepository<ListOfDevices,Long> {
    List<ListOfDevices> findAllByUserId(Long id);
}
