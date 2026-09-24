package FlashKart.User.DTO;

import FlashKart.User.Entity.UserEntity;

public  class ConvertToDTO {
    public static UserResponseDTO userResponseDTO(UserEntity userEntity) {
        return new UserResponseDTO(userEntity.getUsername(),userEntity.getEmail());
    }
}
