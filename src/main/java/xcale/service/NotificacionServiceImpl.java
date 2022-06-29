package xcale.service;


import xcale.entity.Notificacion;
import xcale.repository.InterfaceBaseRepository;
import xcale.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacionServiceImpl extends BaseServiceImpl<Notificacion, Integer> implements NotificacionService {

    @Autowired
    private NotificacionRepository NotificacionRepository;

    public NotificacionServiceImpl(InterfaceBaseRepository<Notificacion, Integer> interfaceBaseRepository) {
        super(interfaceBaseRepository);
    }
    
}
