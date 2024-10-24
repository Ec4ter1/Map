package Repository;

import domain.Utilizator;
import domain.validator.Validator;

import java.util.List;

public class FileRepoUtilizator extends AbstractFileRepository<Long, Utilizator> {

    public FileRepoUtilizator(String fileName, Validator<Utilizator> validator) {
        super(fileName, validator);
    }

    @Override
    public Utilizator extractEntity(String[] attributes) {
        Utilizator user = new Utilizator(attributes[1], attributes[2], attributes[3]);
        user.setId(Long.parseLong(attributes[0]));
        return user;
    }

    @Override
    protected String createEntityAsString(Utilizator entity) {
        return entity.getId()+";"+entity.getFirstName()+";"+entity.getLastName()+";"+entity.getEmail();
    }
}
