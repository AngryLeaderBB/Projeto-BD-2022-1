package projetobd.test;

import projetobd.dao.AlunoDao;
import projetobd.modelo.Aluno;

import java.time.LocalDate;

public class TesteAlunoDao {
    public static void main(String[] args) {
        AlunoDao aDao = new AlunoDao();
        Aluno a1 = new Aluno("11111111111", LocalDate.now(),"Ivo","M","33218181","A");
        Aluno a2 = new Aluno("22222222222", LocalDate.now(),"Shakira","F","77777777","I");
        Aluno a3 = new Aluno("33333333333", LocalDate.now(),"Madona","F","77777777","A");

//        aDao.create(a1);
//        aDao.create(a2);
//        aDao.create(a3);


//        for (Aluno a:aDao.findAll()) {
//            System.out.println(a);
//        }

//        Aluno a = new Aluno("11111111111","1234567", LocalDate.now(),"Toninho","M","40404040","I");
//        aDao.update(a);
//
//        aDao.delete(a);
//        aDao.delete(a2);
//        aDao.delete(a3);

        aDao.findByCpf("8533128452").ifPresent(System.out::println);


    }
}
