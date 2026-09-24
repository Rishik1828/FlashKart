package FlashKart.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserEntity {
    private String username;
    private String password;
    @Id
    private String email;
    private String phone;

}
