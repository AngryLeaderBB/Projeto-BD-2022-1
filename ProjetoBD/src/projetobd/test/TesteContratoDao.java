package projetobd.test;

import projetobd.dao.ContratoDao;
import projetobd.modelo.Contrato;

import java.time.LocalDate;

public class TesteContratoDao {
    public static void main(String[] args) {
        ContratoDao cDao = new ContratoDao();

        Contrato c1 = new Contrato(1, LocalDate.now(),"11111111111","11111111111",1);
        Contrato c2 = new Contrato(2, LocalDate.now(),"22222222222","11111111113",2);

//        cDao.create(c1);
//        cDao.create(c2);

        for(Contrato c:cDao.findAll()){
            System.out.println(c);
        }

        Contrato c3 = new Contrato(2, LocalDate.now(),"11111111111","11111111114",3);
        cDao.update(c3);

//        cDao.delete(c1);
//        cDao.delete(c2);

        cDao.findByNumero(1).ifPresent(System.out::println);


    }
}
