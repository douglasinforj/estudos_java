package br.com.sistema.escolar;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private List<Double> notas;

    //Método Contrutos da classe Aluno
    public Aluno(String nome, String matricula){
        //chamando atributos da classe pai
        super(nome, matricula);
        this.notas = new ArrayList<>();
    }
    //Método para adicionar entrada de nota ao arrayList de notas, inclusão de exception
    public void adicionarNota(double nota){
        if (nota < 0 || nota > 10){
            throw new IllegalArgumentException(
                "Nota Inválida: " + nota + "para o aluno: " + getNome()
            );
        } else {
            this.notas.add(nota);
        }
    }

    //Método para calcular média do aluno, inclusão de exception
    public double calcularMedia(){
        if (notas.isEmpty()){
        throw new IllegalStateException("Aluno " + getNome() + " sem notas.");
        }
        double soma = 0.0;
        for (double nota : notas){
            soma += nota;
        }
        return soma / notas.size();
    }
    
    @Override
    public void exibirDados(){
        System.out.println("\n --- Ficha do Aluno ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Matricula: " + getRegistroDigital());
        System.out.printf("Média atual %.2f%n", calcularMedia());
        System.out.println("Status: " + (calcularMedia() >= 7 ? "Aprovado" : "Em recuperação"));
    }

    @Override
    public String toCSV(){
        return "Aluno, " + getNome() + " ," + getRegistroDigital() + ", " + calcularMedia();
    }

}
