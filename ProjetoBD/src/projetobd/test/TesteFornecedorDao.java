package projetobd.test;

import projetobd.dao.FornecedorDao;
import projetobd.modelo.Fornecedor;

public class TesteFornecedorDao {
    public static void main(String[] args) {
        FornecedorDao fDao = new FornecedorDao();

        Fornecedor f1 = new Fornecedor("11111","whey","10101010");
        Fornecedor f2 = new Fornecedor("22222","gatorade","30303030");
        Fornecedor f3 = new Fornecedor("33333","smartfit","40404040");

//        fDao.create(f1);
//        fDao.create(f2);
//        fDao.create(f3);

        for (Fornecedor f:fDao.findAll()) {
            System.out.println(f);
        }

//        Fornecedor f = new Fornecedor("22222","ninho","70707070");
//        fDao.update(f);

//        fDao.delete(f1);
//        fDao.delete(f2);
//        fDao.delete(f3);

        fDao.findByCnpj("11111").ifPresent(System.out::println);


    }
}
