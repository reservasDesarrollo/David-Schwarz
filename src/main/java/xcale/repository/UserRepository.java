package xcale.repository;
import xcale.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends InterfaceBaseRepository<User, Integer> {
    User findByLogin(String user);
}