package br.com.sistema.escolar.app;

import java.util.ArrayList;
import java.util.List;
import br.com.sistema.escolar.model.Pessoa;
import br.com.sistema.escolar.model.Professor;
import br.com.sistema.escolar.model.Aluno;


public class SistemaEscolarApp {

    public static void main(String[] args){
        List<Pessoa> listaPessoas = new ArrayList<>();    

        try{
            //Cadastro de aluno
            Aluno aluno01 = new Aluno("Douglas Silva", "2026-java-01");
            aluno01.adicionarNota(9.3);
            aluno01.adicionarNota(7.0);
            aluno01.adicionarNota(9.0);
            aluno01.adicionarNota(6.9);
            listaPessoas.add(aluno01);

            //Cadastro de Professor
            Professor pro01 = new Professor("Dr. Daniel","PRO-001", "Professor de Java", 55000.00);
            listaPessoas.add(pro01);

            //Relatório
            System.out.println("\n ---Relatório---");
            for(Pessoa p : listaPessoas){
                p.exibirDados();
            }


        }catch(Exception e){
            System.err.println("Erro: " + e.getMessage());
        }
    }

}
