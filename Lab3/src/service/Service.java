package service;

import Repository.Repository;
import domain.Prietenie;
import domain.Utilizator;

import java.util.Objects;

public class Service {
    private final Repository<Long, Utilizator> repo_u;
    private final Repository<Long, Prietenie> repo_p;

    public Service(Repository<Long, Utilizator> repo_u, Repository<Long, Prietenie> repo_p) {
        this.repo_u = repo_u;
        this.repo_p = repo_p;
    }

    public Utilizator findUtilizatoriById(Long Id) {
        return repo_u.findOne(Id);
    }

    private Long generateIdUtilizator() {
        Long maxim = 0L;
        for (var user : repo_u.findAll()) {
            if (maxim < user.getId()) {
                maxim = user.getId();
            }
        }
        return maxim + 1;
    }

    private Long generateIdPrietenii() {
        Long maxim = 0L;
        for (var prietenie : repo_p.findAll()) {
            if (maxim < prietenie.getId()) {
                maxim = prietenie.getId();
            }
        }
        return maxim + 1;
    }

    public Utilizator adaugaUtilizator(Utilizator utilizator) {
        utilizator.setId(generateIdUtilizator());
        if (utilizator.getId() != null) {
            return repo_u.save(utilizator);
        } else {
            throw new IllegalArgumentException("Id user doesn't exist");
        }
    }

    public Utilizator removerUtilizator(Long id) {
        if (repo_u.findOne(id) == null) {
            throw new IllegalArgumentException("Id user doesn't exist");
        }
        return repo_u.delete(id);
    }

    public Iterable<Utilizator> getUtilizatori() {
        return repo_u.findAll();
    }

    public Iterable<Prietenie> getPrietenii() {
        return repo_p.findAll();
    }

    public void adaugaPrietenie(Utilizator u1, Utilizator u2) {
        Prietenie prietenie = new Prietenie(u1, u2);
        prietenie.setId(generateIdPrietenii());
        for (var u : repo_p.findAll()) {
            if ((Objects.equals(u.getUser1().getId(), u1.getId()) && Objects.equals(u.getUser2().getId(), u2.getId())) ||
                    (Objects.equals(u.getUser2().getId(), u1.getId()) && Objects.equals(u.getUser1().getId(), u2.getId()))) {
                throw new IllegalArgumentException("Prietenie deja exista!");
            }
        }
        repo_p.save(prietenie);
        u1.addFriends(u2);
        u2.addFriends(u1);
    }

    public void removePrietenie(Long idU1, Long idU2) {
        Long idPrietenie = 0L;
        for (var u : repo_p.findAll()) {
            if ((Objects.equals(u.getUser1().getId(), idU1) && Objects.equals(u.getUser2().getId(), idU2)) ||
                    (Objects.equals(u.getUser2().getId(), idU1) && Objects.equals(u.getUser1().getId(), idU2))) {
                idPrietenie = u.getId();
            }
        }
        if (idPrietenie == 0L) {
            throw new IllegalArgumentException("Prietenia nu exista!");
        }
        repo_p.delete(idPrietenie);
        Utilizator u1 = repo_u.findOne(idU1);
        Utilizator u2 = repo_u.findOne(idU2);
        if (u1 != null && u2 != null) {
            u1.removeFriends(u2);
            u2.removeFriends(u1);
        }
    }
}
