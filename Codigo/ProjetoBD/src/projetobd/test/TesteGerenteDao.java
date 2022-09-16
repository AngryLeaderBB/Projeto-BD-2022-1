package projetobd.test;

import projetobd.dao.GerenteDao;
import projetobd.modelo.Gerente;

import java.time.LocalDate;
import java.util.List;

public class TesteGerenteDao {
    public static void main(String[] args) {
        GerenteDao gerenteDao = new GerenteDao();
//        Gerente g1 = new Gerente("11111111111","Carlos",200.00,"M","40028922", LocalDate.now());
//        Gerente g2 = new Gerente("11111111113","Ana",215.00,"F","33333333", LocalDate.now());
//        Gerente g3 = new Gerente("11111111114","Ze",205.00,"M","44444444", LocalDate.now());
//        gerenteDao.create(g1);
//        gerenteDao.create(g2);
//        gerenteDao.create(g3);
//
//        List<Gerente> lista = gerenteDao.findAll();
//
//        for (Gerente g:lista) {
//            System.out.println(g);
//        }
//
//        Gerente g = new Gerente("11111111114","Mariana",300.00,
//                                "F","44444444", LocalDate.of(2000,1,8));
//
//        gerenteDao.update(g);

        Gerente gerente = gerenteDao.findByCpf("11111111113").orElseThrow();
        System.out.println("gerente = " + gerente);

//
//        gerenteDao.delete(g1);
//        gerenteDao.delete(g2);
//        gerenteDao.delete(g3);
    }

}
