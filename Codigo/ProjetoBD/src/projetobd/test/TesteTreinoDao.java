package projetobd.test;

import projetobd.dao.TreinoDao;
import projetobd.modelo.Treino;

import java.time.LocalDate;

public class TesteTreinoDao {
    public static void main(String[] args) {
        TreinoDao tDao = new TreinoDao();

        Treino t1 = new Treino(LocalDate.now(), 30, "1111111111", "11111111111");
        Treino t2 = new Treino(LocalDate.now(), 60, "1111111112", "22222222222");
        Treino t3 = new Treino(LocalDate.now(), 90, "1111111113", "33333333333");

//        tDao.create(t1);
//        tDao.create(t2);
//        tDao.create(t3);

        for (Treino t : tDao.findAll()){
            System.out.println(t);
        }

        Treino t = new Treino();
        t.setData(LocalDate.now());
        t.setProfessorCref("1111111112");
        t.setAlunoCpf("22222222222");
        t.setDuracao(40);

        tDao.update(t);

//        tDao.delete(t1);
//        tDao.delete(t2);
//        tDao.delete(t3);
        tDao.findByDataAndCrefAndCpf(LocalDate.of(2022,9,9),
                                    "1111111113","33333333333").
                                    ifPresent(System.out::println);





    }
}
