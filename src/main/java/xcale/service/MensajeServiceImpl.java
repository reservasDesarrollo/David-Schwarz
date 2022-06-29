package xcale.service;


import xcale.entity.Mensaje;
import xcale.repository.InterfaceBaseRepository;
import xcale.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeServiceImpl extends BaseServiceImpl<Mensaje, Integer> implements MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public MensajeServiceImpl(InterfaceBaseRepository<Mensaje, Integer> interfaceBaseRepository) {
        super(interfaceBaseRepository);
    }
    
}
