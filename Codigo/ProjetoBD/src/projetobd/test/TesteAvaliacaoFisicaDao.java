package projetobd.test;

import projetobd.dao.AvaliacaoFisicaDao;
import projetobd.modelo.AvaliacaoFisica;

import java.time.LocalDate;

public class TesteAvaliacaoFisicaDao {
    public static void main(String[] args) {
        AvaliacaoFisicaDao aDao = new AvaliacaoFisicaDao();

        AvaliacaoFisica a1 = new AvaliacaoFisica(LocalDate.now(),12,13,
                                            14,15,16,17,18,
                                            19,20,21,
                                            22,"1111111111","22222222222");

        AvaliacaoFisica a2 = new AvaliacaoFisica(LocalDate.now(),12,13,
                21,22,23,25,27,
                34,45,54,
                15,"1111111112","11111111111");

        AvaliacaoFisica a3 = new AvaliacaoFisica(LocalDate.now(),12,13,
                21,22,23,25,27,
                34,45,54,
                15,"1111111111","33333333333");

//        aDao.create(a1);
//        aDao.create(a2);
//        aDao.create(a3);

        for(AvaliacaoFisica a:aDao.findAll()){
            System.out.println(a);
        }

        AvaliacaoFisica a = new AvaliacaoFisica(LocalDate.now(),40,40,
                40,40,40,40,40,
                40,40,40,
                40,"1111111111","11111111111");

        aDao.update(a);

        AvaliacaoFisica a4 = new AvaliacaoFisica();
        a4.setData(LocalDate.now());
        a4.setProfessorCref("1111111111");
        a4.setAlunoCpf("22222222222");

//        aDao.delete(a4);
//        aDao.delete(a3);
        System.out.println("Mostrando busca");
        aDao.findByDataAndCrefAndCpf(LocalDate.now(),"1111111111","83333333333").ifPresent(System.out::println);

    }
}
