package projetobd.test;

import projetobd.connection.GeradorConexao;
import projetobd.dao.ModeloEquipamentoDao;
import projetobd.dao.mappers.PlanoMapper;
import projetobd.modelo.ModeloEquipamento;
import projetobd.modelo.Plano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class TesteModeloEquipamentoDao {
    public static void main(String[] args) {
        ModeloEquipamentoDao mDao = new ModeloEquipamentoDao();

        ModeloEquipamento m1 = new ModeloEquipamento("m1");
        ModeloEquipamento m2 = new ModeloEquipamento("m2");
        ModeloEquipamento m3 = new ModeloEquipamento("m3");

//        mDao.create(m1);
//        mDao.create(m2);
//        mDao.create(m3);


        for(ModeloEquipamento m:mDao.findAll()){
            System.out.println(m);
        }

        mDao.findByNome("m15").ifPresent(System.out::println);

    }
}
