package xcale.service;

import xcale.entity.User;
import xcale.repository.InterfaceBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xcale.repository.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(InterfaceBaseRepository<User, Integer> interfaceBaseRepository) {
        super(interfaceBaseRepository);
    }
    public User getUserByUserName(String user) {
        return userRepository.findByLogin(user);
    }
}
