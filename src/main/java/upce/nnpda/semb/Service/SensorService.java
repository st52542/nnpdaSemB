package upce.nnpda.semb.Service;

import org.springframework.security.core.Authentication;
import upce.nnpda.semb.DTO.AddSensorDTO;
import upce.nnpda.semb.DTO.DeviceDTO;
import upce.nnpda.semb.Entity.Sensor;

import java.util.List;

public interface SensorService {
    List<Sensor> getSensors(Authentication authentication, DeviceDTO deviceDTO);
    Sensor addSensor(Authentication authentication, AddSensorDTO addSensorDTO);
}
