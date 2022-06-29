package xcale.service;

import xcale.entity.Grupo;
import xcale.repository.GrupoRepository;
import xcale.repository.InterfaceBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoServiceImpl extends BaseServiceImpl<Grupo, Integer> implements GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public GrupoServiceImpl(InterfaceBaseRepository<Grupo, Integer> interfaceBaseRepository) {
        super(interfaceBaseRepository);
    }

}
