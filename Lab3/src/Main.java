import Repository.AbstractFileRepository;
import Repository.FileRepoPrietenie;
import Repository.FileRepoUtilizator;
//import Repository.PrietenieRepo;
import domain.Prietenie;
import domain.Utilizator;
import domain.validator.ValidatorPrietenie;
import domain.validator.ValidatorUtilizator;

import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        test_repo();
    }

    private static void test_repo() {
        Utilizator u1=new Utilizator("u1FirstName", "u1LastName","u1@gmail.com");
        u1.setId(8L);
        Utilizator u2=new Utilizator("u2FirstName", "u2LastName", "u2@gmail.com"); u2.setId(9L);
        Utilizator u3=new Utilizator("u3FirstName", "u3LastName", "u3@gmail.com"); u3.setId(11L);
        Utilizator u4=new Utilizator("u4FirstName", "u4LastName", "u4@gmail.com"); u4.setId(12L);

        //FileRepoUtilizator
        FileRepoUtilizator repo=new FileRepoUtilizator("E:\\MAP\\Lab3\\src\\Utilizatori.txt",ValidatorUtilizator.getInstance());
        System.out.println("Utilizatori fisier:\n");
        repo.findAll().forEach(System.out::println);
        repo.save(u1);
        repo.save(u2);
        repo.save(u3);
        repo.save(u4);
//        repo.delete(1L);
//        repo.delete(2L);
//        repo.delete(3L);
//        repo.delete(4L);

        Prietenie p1 = new Prietenie(u1, u2);
        FileRepoPrietenie p = new FileRepoPrietenie("E:\\MAP\\Lab3\\src\\Prietenii.txt", ValidatorPrietenie.getInstance(), repo);

    }
}