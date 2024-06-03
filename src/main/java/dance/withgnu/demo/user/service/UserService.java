package dance.withgnu.demo.user.service;

import dance.withgnu.demo.dto.UserInfo;
import dance.withgnu.demo.user.entity.UserEntity;
import dance.withgnu.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserInfo getUserInfoById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return new UserInfo(userEntity.getId(), userEntity.getUserId(), userEntity.getUserType());
        }
        return null;
    }
}
