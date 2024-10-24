import Repository.AbstractFileRepository;
import Repository.FileRepoPrietenie;
import Repository.FileRepoUtilizator;
//import Repository.PrietenieRepo;
import Repository.Repository;
import domain.Prietenie;
import domain.Utilizator;
import domain.validator.ValidatorPrietenie;
import domain.validator.ValidatorUtilizator;
import service.Service;

import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //test_repo();
        test_service();
    }

    private static void test_repo() {
        Utilizator u1=new Utilizator("u1FirstName", "u1LastName","u1@gmail.com");
        u1.setId(8L);
        Utilizator u2=new Utilizator("u2FirstName", "u2LastName", "u2@gmail.com"); u2.setId(9L);
        Utilizator u3=new Utilizator("u3FirstName", "u3LastName", "u3@gmail.com"); u3.setId(11L);
        Utilizator u4=new Utilizator("u4FirstName", "u4LastName", "u4@gmail.com"); u4.setId(12L);

        Repository<Long, Utilizator> repo_u = new FileRepoUtilizator("E:\\MAP\\Lab3\\src\\Utilizatori.txt",new ValidatorUtilizator());
        Repository<Long, Prietenie> repo_p = new FileRepoPrietenie("E:\\MAP\\Lab3\\src\\Prietenii.txt",new ValidatorPrietenie(), repo_u);
        repo_u.save(u1);
        repo_u.save(u2);
        repo_u.save(u3);
        repo_u.save(u4);
        repo_u.findAll().forEach(System.out::println);

        Prietenie p1 = new Prietenie(u1,u2);
        p1.setId(1L);
        repo_p.save(p1);
        repo_p.findAll().forEach(System.out::println);
        repo_p.delete(1L);
    }

    static void test_service(){
        Repository<Long, Utilizator> repo_u = new FileRepoUtilizator("E:\\MAP\\Lab3\\src\\Utilizatori.txt",new ValidatorUtilizator());
        Repository<Long, Prietenie> repo_p = new FileRepoPrietenie("E:\\MAP\\Lab3\\src\\Prietenii.txt",new ValidatorPrietenie(), repo_u);
        Service service = new Service(repo_u, repo_p);
        Utilizator u1 = new Utilizator("Ana","Mois","aaa@gmail.com");
        Utilizator u2 = new Utilizator("Bianca","Draguta","bbb@gmail.com");
        service.adaugaUtilizator(u1);
        service.adaugaUtilizator(u2);
        service.getUtilizatori().forEach(System.out::println);

        service.getPrietenii().forEach(System.out::println);
//        service.adaugaPrietenie(u1,u2);
//        try {
//            service.adaugaPrietenie(u2,u1);
//        }
//        catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//        service.getPrietenii().forEach(System.out::println);
        service.removePrietenie(17L,18L);
        service.removerUtilizator(13L);
        service.removerUtilizator(14L);
    }
}