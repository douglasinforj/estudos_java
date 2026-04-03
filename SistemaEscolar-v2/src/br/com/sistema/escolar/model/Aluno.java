package br.com.sistema.escolar.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
    //Variavel para armazenar as notas do aluno
    private List<Double> notas = new ArrayList<>();
    
    public Aluno(String nome, String matricula){
        super(nome, matricula);
    }
    public void adicionarNota(double nota){
        if (nota < 0 || nota > 10){
            throw new IllegalArgumentException("Nota inválida" + nota);
        }
        notas.add(nota);
    }
    public double calcularMedia(){
        return notas.stream()                 //percorre os dados em notas
            .mapToDouble(Double::doubleValue) //converte os dados em double primitivo
            .average()                        //calcula média dos valore (OptionalDouble)
            .orElse(0.0);              //se não tem valor retorna 0.0     
    }

    @Override
    public void exibirDados(){
        System.out.println("\n ===Ficha do Aluno===");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getRegistroDigital());
        System.out.printf("Média atual: %.2f%n", calcularMedia());
        System.out.println("Status: " + (calcularMedia() >= 7 ? "Aprovado" : "Reprovado"));
    }

    @Override
    public String toCSV(){
        return "Aluno, " + getNome() + "," + getRegistroDigital() + "," + calcularMedia();
    }
    
}
