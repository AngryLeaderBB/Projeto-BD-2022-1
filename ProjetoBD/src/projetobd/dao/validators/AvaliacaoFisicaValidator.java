package projetobd.dao.validators;

import projetobd.dao.AlunoDao;
import projetobd.dao.ProfessorDao;
import projetobd.modelo.AvaliacaoFisica;
import java.util.NoSuchElementException;

public class AvaliacaoFisicaValidator {

    public static void valida(AvaliacaoFisica a) {
        if (new AlunoDao().findByCpf(a.getAlunoCpf()).isEmpty()) {
            throw new NoSuchElementException("Aluno não existe");
        }

        if(new ProfessorDao().findByCref(a.getProfessorCref()).isEmpty()){
            throw new NoSuchElementException("Professor não existe");
        }
    }

}
