package Repository;

import domain.Entity;
import domain.Utilizator;
import domain.validator.Validator;
import domain.validator.ValidatorPrietenie;

import java.util.HashMap;
import java.util.Map;

public class PrietenieRepo<ID, E extends Entity<ID>> {
    private Validator<E> validator;
    Map<ID,E> entities;
    FileRepoUtilizator repo;

    public PrietenieRepo(Validator<E> validator, FileRepoUtilizator repo) {
        entities=new HashMap<ID,E>();
        this.repo=repo;
    }

    public E findOne(ID id) {
        if (id==null)
            throw new IllegalArgumentException("id must be not null");
        return entities.get(id);
    }

    public Iterable<E> findAll() {
        return entities.values();
    }

    public E save(E entity) {
        if (entity==null)
            throw new IllegalArgumentException("entity must be not null");
        validator.validate(entity);
        if(entities.get(entity.getId()) != null) {
            return entity;
        }
        entities.put(entity.getId(),entity);
        return null;
    }

    public E delete(ID id) {
        if (id==null)
            throw new IllegalArgumentException("id must be not null");
        return entities.remove(id);
    }
}
