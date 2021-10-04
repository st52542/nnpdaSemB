package upce.nnpda.semb.Service;

import org.springframework.security.core.Authentication;
import upce.nnpda.semb.DTO.AddDeviceDTO;
import upce.nnpda.semb.Entity.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Optional<Device>> getDevices(Authentication authentication);
    Device addDevice(Authentication authentication,AddDeviceDTO device);
}
