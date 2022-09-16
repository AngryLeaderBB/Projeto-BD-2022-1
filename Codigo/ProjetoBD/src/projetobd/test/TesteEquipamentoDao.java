package projetobd.test;

import projetobd.dao.EquipamentoDao;
import projetobd.modelo.Equipamento;

public class TesteEquipamentoDao {
    public static void main(String[] args) {
        EquipamentoDao eDao = new EquipamentoDao();

        Equipamento e1 = new Equipamento(1,"marca1","m1","11111");
        Equipamento e2 = new Equipamento(2,"marca2","m2","22222");

//        eDao.create(e1);
//        eDao.create(e2);

        for(Equipamento e:eDao.findAll()){
            System.out.println(e);
        }

        Equipamento e3 = new Equipamento(1,"marca3","m1","33333");
        eDao.update(e3);


//        eDao.delete(e2);
//        eDao.delete(e3);

        eDao.findById(10).ifPresent(System.out::println);

    }
}
