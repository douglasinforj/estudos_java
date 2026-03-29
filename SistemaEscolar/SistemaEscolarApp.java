package SistemaEscolar;

import java.util.ArrayList;
import java.util.List;

abstract class Pessoa {
    private String nome;
    private String registroDigital;

    public Pessoa(String nome, String registroDigital) {
        this.nome = nome;
        this.registroDigital = registroDigital;
    }

    public String getNome(){
        return nome;
    }

    public String getRegistroDigital(){
        return registroDigital;
    }

    public abstract void exibirDados();
}

class Aluno extends Pessoa {

    private List<Double> notas;

    public Aluno(String nome, String matricula){
        super(nome, matricula);
        this.notas = new ArrayList<>();
    }

    public void adicionarNota(double nota){
        if(nota >= 0 && nota <= 10){
            this.notas.add(nota);
        } else {
            System.out.println("Erro: Nota inválida para o aluno " + getNome());
        }
    }

    public double calcularMedia(){
        if (notas.isEmpty()) return 0.0;

        double soma = 0;
        for(double nota : notas){
            soma += nota;
        }
        return soma / notas.size();
    }

    @Override
    public void exibirDados(){
        System.out.println("=== Ficha do Aluno ===");
        System.out.println("Nome: " + getNome());
        System.out.println("Matricula: " + getRegistroDigital());
        System.out.printf("Média Atual: %.2f%n", calcularMedia());
        System.out.println("Status: " + (calcularMedia() >= 7 ? "Aprovado" : "Em recuperação"));
    }
}

//Classe principal (única public)
public class SistemaEscolarApp {

    public static void main(String[] args){

        Aluno aluno01 = new Aluno("Douglas Silva", "2026-java-01");

        aluno01.adicionarNota(8.5);
        aluno01.adicionarNota(7.0);
        aluno01.adicionarNota(9.0);
        aluno01.adicionarNota(3.0);

        aluno01.exibirDados();
    }
}