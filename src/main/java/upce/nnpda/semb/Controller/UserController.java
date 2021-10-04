package upce.nnpda.semb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upce.nnpda.semb.DTO.ChangePasswordDTO;
import upce.nnpda.semb.DTO.ResetPasswordSendDTO;
import upce.nnpda.semb.DTO.ResetPasswordTokenDTO;
import upce.nnpda.semb.Service.UserService;
import upce.nnpda.semb.DTO.LoginFormDTO;
import upce.nnpda.semb.DTO.SignUpFormDTO;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginFormDTO loginRequest) {
        try {
            return userService.authenticateUser(loginRequest);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpFormDTO signUpRequest){
        try {
            return userService.registerUser(signUpRequest);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/changepassword")
    public String setPassword(Authentication authentication, @RequestBody ChangePasswordDTO changePasswordDTO) {
        try {
            userService.setPassword(authentication, changePasswordDTO);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "password change";
    }

    @GetMapping("/resetpasswordsend")
    public String resetPasswordSend(@RequestBody ResetPasswordSendDTO resetPasswordSendDTO) {
        try {
            userService.resetPasswordSend(resetPasswordSendDTO);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "mail send";
    }
    @PutMapping("/resetpasswordtoken")
    public String resetPasswordToken(@RequestBody ResetPasswordTokenDTO resetPasswordTokenDTO) {
        try {
            userService.resetPasswordToken(resetPasswordTokenDTO);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "password change";
    }
}
