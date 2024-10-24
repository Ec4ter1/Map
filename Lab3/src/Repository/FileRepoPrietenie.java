package Repository;

import domain.Prietenie;
import domain.Utilizator;
import domain.validator.Validator;

import java.util.List;
import java.util.UUID;

public class FileRepoPrietenie extends AbstractFileRepository<UUID, Prietenie>{

    private FileRepoUtilizator utilizatorRepository;

    public FileRepoPrietenie(String fileName, Validator<Prietenie> validator, FileRepoUtilizator utilizatorRepository) {
        super(fileName, validator);
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public Prietenie extractEntity(String[] attributes) {
        long idUser1 = Long.parseLong(attributes[0]);
        long idUser2 = Long.parseLong(attributes[1]);
        System.out.println("aaaaaaaaaaaaa");//il printeaza
        utilizatorRepository.findAll().forEach(System.out::println);
        Utilizator utilizator1 = utilizatorRepository.findOne(idUser1);
        Utilizator utilizator2 = utilizatorRepository.findOne(idUser2);

        System.out.println("aaaaaaaaaaaaa");//nu
        Prietenie prietenie = new Prietenie(utilizator1, utilizator2);
        prietenie.setId(UUID.randomUUID());
        return prietenie;
    }

    @Override
    protected String createEntityAsString(Prietenie entity) {
        return entity.getUser1().getId() + ";" + entity.getUser2().getId();
    }
}
