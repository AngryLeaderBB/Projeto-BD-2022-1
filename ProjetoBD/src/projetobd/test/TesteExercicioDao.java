package projetobd.test;

import projetobd.dao.ExercicioDao;
import projetobd.modelo.Exercicio;

import java.time.LocalDate;

public class TesteExercicioDao {
    public static void main(String[] args) {
        ExercicioDao eDao = new ExercicioDao();

        Exercicio e1 = new Exercicio(1,10,20,"Musculação",
                "m1", LocalDate.now().minusDays(1),"1111111111", "11111111111");

        Exercicio e2 = new Exercicio(2,12,30,"Agachamento",
                "m2", LocalDate.now().minusDays(1),"1111111112", "22222222222");

//        eDao.create(e1);
//        eDao.create(e2);

        for (Exercicio e:eDao.findAll()){
            System.out.println(e);
        }

        Exercicio e3 = new Exercicio(2,20,20,"Alongamento",
                "m3", LocalDate.now().minusDays(1),"1111111112", "22222222222");


        eDao.update(e3);

//        eDao.delete(e1);
//        eDao.delete(e2);

        eDao.findById(5).ifPresent(System.out::println);

    }
}
