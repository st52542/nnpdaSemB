package upce.nnpda.semb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upce.nnpda.semb.DTO.AddSensorDTO;
import upce.nnpda.semb.DTO.LogDTO;
import upce.nnpda.semb.Entity.Sensor;
import upce.nnpda.semb.Service.LogServices;
import upce.nnpda.semb.Service.SensorService;

@RestController
@RequestMapping("/api/log")
@CrossOrigin("http://localhost:3000")
public class LogController {
    @Autowired
    LogServices logServices;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addLog(@RequestBody LogDTO logDTO) {
        try {
            logServices.addLog(logDTO);
            return "aaa";
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
