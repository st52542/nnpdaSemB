package upce.nnpda.semb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upce.nnpda.semb.DTO.LogDTO;
import upce.nnpda.semb.Entity.Log;
import upce.nnpda.semb.Repository.DeviceRepository;
import upce.nnpda.semb.Repository.ListOfDevicesRepository;
import upce.nnpda.semb.Repository.LogRepository;
import upce.nnpda.semb.Repository.SensorRepository;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class LogServicesImpl implements LogServices{
    @Autowired
    LogServices logServices;
    @Autowired
    SensorRepository sensorRepository;
    @Autowired
    LogRepository logRepository;

    @Override
    public void addLog(LogDTO logDTO) {
        Log log = new Log();
        log.setSensor(sensorRepository.findById(logDTO.getIdSensor()).get());
        log.setMeasurement(logDTO.getMeasurement());
        logRepository.save(log);
    }
}
