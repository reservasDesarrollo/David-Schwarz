package xcale.service;

import xcale.repository.InterfaceBaseRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseServiceImpl<E, ID extends Serializable> implements BaseService<E,ID> {

    protected InterfaceBaseRepository<E,ID> interfaceBaseRepository;

    public BaseServiceImpl(InterfaceBaseRepository<E,ID> interfaceBaseRepository){
        this.interfaceBaseRepository = interfaceBaseRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = interfaceBaseRepository.findAll();
            return entities;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entityOptional = interfaceBaseRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = interfaceBaseRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = interfaceBaseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = interfaceBaseRepository.save(entity);
            return entityUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean inactive(ID id) throws Exception {
        try {
            if (interfaceBaseRepository.existsById(id)){
                interfaceBaseRepository.deleteById(id);
                return  true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
