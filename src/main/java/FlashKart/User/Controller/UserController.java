package FlashKart.User.Controller;

import FlashKart.User.DTO.ConvertToDTO;
import FlashKart.User.DTO.UserResponseDTO;
import FlashKart.User.Entity.UserEntity;
import FlashKart.User.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserEntity user){
        userService.create(user);
        return ResponseEntity.ok(ConvertToDTO.userResponseDTO(user));
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{Email}")
    public ResponseEntity getUserByEmail(@PathVariable String Email){
        return userService.findbyEmail(Email);

    }
}
