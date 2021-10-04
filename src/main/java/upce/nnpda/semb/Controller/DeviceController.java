package upce.nnpda.semb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upce.nnpda.semb.DTO.AddDeviceDTO;
import upce.nnpda.semb.Entity.Device;

import upce.nnpda.semb.Service.DeviceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/device")
@CrossOrigin("http://localhost:3000")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Optional<Device>> getDevices(Authentication authentication) {
        try {
            return deviceService.getDevices(authentication);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Device addDevice(Authentication authentication,@RequestBody AddDeviceDTO device) {
        try {
            return deviceService.addDevice(authentication,device);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
