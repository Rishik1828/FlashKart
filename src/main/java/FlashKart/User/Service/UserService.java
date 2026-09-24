package FlashKart.User.Service;

import FlashKart.User.DTO.ConvertToDTO;
import FlashKart.User.DTO.UserResponseDTO;
import FlashKart.User.Entity.UserEntity;
import FlashKart.User.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
        UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public void create(UserEntity user) {
            userRepository.save(user);
        }

        public List<UserResponseDTO> getAllUsers() {
            List<UserEntity> users = userRepository.findAll();
            List<UserResponseDTO> responses = new ArrayList<>();
            for(UserEntity user : users) {
                responses.add(ConvertToDTO.userResponseDTO(user));
            }
            return responses;
        }

        public ResponseEntity findbyEmail(String Email) {
            Optional<UserEntity>optional=userRepository.findByEmail(Email);
            if(optional.isPresent()) {
                return ResponseEntity.ok(ConvertToDTO.userResponseDTO(optional.get()));
            }
            else return ResponseEntity.notFound().build();
        }


}
