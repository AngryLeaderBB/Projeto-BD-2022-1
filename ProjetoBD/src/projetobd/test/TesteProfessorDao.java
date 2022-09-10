package projetobd.test;

import projetobd.dao.ProfessorDao;

public class TesteProfessorDao {
    public static void main(String[] args) {
        ProfessorDao pDao = new ProfessorDao();
//
//        Professor p1 = new Professor("1111111111","11111111111","Musculação",
//                "1111111", LocalDate.now(),"Joao",10,
//                1800.00,"M","11111111");
//
//        Professor p2 = new Professor("1111111112","11111111111","Musculação",
//                "1111112", LocalDate.now(),"Jessica",10,
//                1800.00,"F","11111111");
//
//       Professor p3 = new Professor("1111111113","11111111113","Ginástica",
//                "1111112", LocalDate.now(),"Maria",10,
//               1800.00,"F","11111113");
//
//       pDao.create(p1);
//       pDao.create(p2);
//       pDao.create(p3);
//
//       for(Professor p:pDao.findAll()){
//           System.out.println(p);
//       }
//
//       Professor p4 = new Professor("1111111112","11111188883","Natacao",
//                "1111112", LocalDate.now(),"Maria",15,
//                2400.00,"F","2222222");
//
//       pDao.update(p4);
//
//
//       Professor p5 = new Professor();
//       p5.setCref("1111111112");

//       pDao.delete(p5);
//       pDao.delete(p1);
//       pDao.delete(p3);

        pDao.findByCref("1111111117").ifPresent(System.out::println);

    }


}
