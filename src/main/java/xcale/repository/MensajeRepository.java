package xcale.repository;
import xcale.entity.Mensaje;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends InterfaceBaseRepository<Mensaje, Integer> {

}