package projetobd.test;

import projetobd.dao.PlanoDao;
import projetobd.modelo.Plano;

public class TestePlanoDao {
    public static void main(String[] args) {
        PlanoDao pDao = new PlanoDao();

        Plano p1 = new Plano(1,200.00,30,380.00);
        Plano p2 = new Plano(2,280.00,60,450.00);
        Plano p3 = new Plano(3,400.00,90,500.00);

//        pDao.create(p1);
//        pDao.create(p2);
//        pDao.create(p3);

        for(Plano p:pDao.findAll()){
            System.out.println(p);
        }

        Plano p = new Plano(3,100.00,360,800.00);
        pDao.update(p);


//        pDao.delete(p1);
//        pDao.delete(p2);
//        pDao.delete(p3);

        pDao.findById(5).ifPresent(System.out::println);



    }





}
