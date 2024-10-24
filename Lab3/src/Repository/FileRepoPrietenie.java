package Repository;

import domain.Prietenie;
import domain.Utilizator;
import domain.validator.Validator;

import java.util.List;
import java.util.UUID;

public class FileRepoPrietenie extends AbstractFileRepository<Long, Prietenie>{

    private final Repository<Long, Utilizator> utilizatorRepo;

    public FileRepoPrietenie(String fileName, Validator<Prietenie> validator, Repository<Long, Utilizator> utilizatorRepo) {
        super(fileName, validator);
        this.utilizatorRepo = utilizatorRepo;
        //loadPrieteni();
    }

    private void loadPrieteni() {
        for (var prietenie : findAll()) {
            Utilizator u1 = utilizatorRepo.findOne(prietenie.getUser1().getId());
            Utilizator u2 = utilizatorRepo.findOne(prietenie.getUser2().getId());

            if (u1 == null && u2 == null) {
                throw new IllegalArgumentException("Nu s-a putut incarca corect din fisier!");
            } else if (u1 != null && u2 != null) {
                u1.addFriends(u2);
                u2.addFriends(u1);
            }
        }
    }

    @Override
    public Prietenie extractEntity(String[] attributes) {
        long idUser1 = Long.parseLong(attributes[1]);
        long idUser2 = Long.parseLong(attributes[2]);

        Utilizator utilizator1 = utilizatorRepo.findOne(idUser1);
        Utilizator utilizator2 = utilizatorRepo.findOne(idUser2);

        Prietenie prietenie = new Prietenie(utilizator1, utilizator2);
        prietenie.setId(Long.parseLong(attributes[0]));
        return prietenie;
    }


    @Override
    protected String createEntityAsString(Prietenie entity) {
        return entity.getId() + ";"+ entity.getUser1().getId() + ";" + entity.getUser2().getId();
    }
}
