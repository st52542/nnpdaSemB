package upce.nnpda.semb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import upce.nnpda.semb.DTO.AddDeviceDTO;
import upce.nnpda.semb.DTO.ModifyDeviceDTO;
import upce.nnpda.semb.Entity.Device;
import upce.nnpda.semb.Entity.ListOfDevices;
import upce.nnpda.semb.Entity.User;
import upce.nnpda.semb.Repository.DeviceRepository;
import upce.nnpda.semb.Repository.ListOfDevicesRepository;
import upce.nnpda.semb.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ListOfDevicesRepository listOfDevicesRepository;
    @Override
    public List<Optional<Device>> getDevices(Authentication authentication) {
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        List<ListOfDevices> listOfDevices = listOfDevicesRepository.findAllByUserId(user.get().getId());
        List<Optional<Device>> deviceList = new ArrayList<>();
        listOfDevices.forEach(deviceRecord->{deviceList.add(deviceRepository.findById(deviceRecord.getDevices().getId()));});
        return deviceList;
    }

    @Override
    public Device addDevice(Authentication authentication, AddDeviceDTO device) {
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        Device addDevice = new Device();
        addDevice.setDescription(device.getDescription());
        deviceRepository.save(addDevice);
        ListOfDevices newDevice = new ListOfDevices();
        newDevice.setDevices(deviceRepository.findByDescription(device.getDescription()));
        newDevice.setUser(user.get());
        listOfDevicesRepository.save(newDevice);
        return deviceRepository.findByDescription(device.getDescription());
    }

    @Override
    public Device modifyDevice(Authentication authentication, ModifyDeviceDTO device) {
        userRepository.findByUsername(authentication.getName());
        Optional<Device> forModify = deviceRepository.findById(device.getId());
        forModify.get().setDescription(device.getDescription());
        deviceRepository.save(forModify.get());
        return deviceRepository.findByDescription(device.getDescription());
    }

    @Override
    public Device getSingleDevice(Authentication authentication, Long id) {
        userRepository.findByUsername(authentication.getName());
        return deviceRepository.findById(id).get();
    }
}
