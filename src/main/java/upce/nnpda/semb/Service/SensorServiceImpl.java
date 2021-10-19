package upce.nnpda.semb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import upce.nnpda.semb.DTO.AddSensorDTO;
import upce.nnpda.semb.DTO.DeviceDTO;
import upce.nnpda.semb.DTO.ModifySensorDTO;
import upce.nnpda.semb.Entity.Device;
import upce.nnpda.semb.Entity.ListOfDevices;
import upce.nnpda.semb.Entity.Sensor;
import upce.nnpda.semb.Entity.User;
import upce.nnpda.semb.Repository.DeviceRepository;
import upce.nnpda.semb.Repository.ListOfDevicesRepository;
import upce.nnpda.semb.Repository.SensorRepository;
import upce.nnpda.semb.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService{
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SensorService sensorService;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    ListOfDevicesRepository listOfDevicesRepository;

    @Override
    public List<Sensor> getSensors(Authentication authentication, DeviceDTO deviceDTO) {
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        List<Sensor> sensorList = new ArrayList<>();
        if (user != null){
            sensorList = sensorRepository.findAllByDevice_Id(deviceDTO.getId());
        }
        return sensorList;
    }

    @Override
    public Sensor addSensor(Authentication authentication, AddSensorDTO addSensorDTO) {
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        if (user != null){
            Sensor sensor=new Sensor();
            sensor.setType(addSensorDTO.getType());
            sensor.setDescription(addSensorDTO.getDescription());
            sensor.setDevice(deviceRepository.findById(addSensorDTO.getId()).get());
            sensorRepository.save(sensor);
        }
        return sensorRepository.findByDescription(addSensorDTO.getDescription());
    }

    @Override
    public List<Long> getSensorsIds() {
        List<Sensor> allSensors = sensorRepository.findAll();
        List<Long> idsList = new ArrayList<>();
        allSensors.forEach(sensorRecord->{idsList.add(sensorRecord.getId());});
        return idsList;
    }

    @Override
    public Sensor modifySensor(Authentication authentication, ModifySensorDTO modifySensorDTO) {
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        if (user != null){
            Optional<Sensor> forModify=sensorRepository.findById(modifySensorDTO.getId());
            forModify.get().setDescription(modifySensorDTO.getDescription());
            sensorRepository.save(forModify.get());
        }
        return sensorRepository.findByDescription(modifySensorDTO.getDescription());
    }
}
