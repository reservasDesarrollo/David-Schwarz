package xcale.service;



import xcale.entity.Participante;
import xcale.repository.InterfaceBaseRepository;
import xcale.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteServiceImpl extends BaseServiceImpl<Participante, Integer> implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public ParticipanteServiceImpl(InterfaceBaseRepository<Participante, Integer> interfaceBaseRepository) {
        super(interfaceBaseRepository);
    }
    
}
