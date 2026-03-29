/* 
Para estudos podemos escrever tudo em um arquivo só mas respeitando que só pode haver
uma classe public
*/  

package SistemaEscolar;

import java.util.ArrayList;
import java.util.List;

abstract class Pessoa {
    private String nome;
    private String registroDigital;

    //metodo construtor da class
    public Pessoa(String nome, String registroDigital) {
        this.nome = nome;
        this.registroDigital = registroDigital;
    }

    //encapsulamento (getters, setters)
    public String getNome(){
        return nome;
    }
    public String getRegistroDigital(){
        return registroDigital;
    }

    //método abstrato
    public abstract void exibirDados();
    //OBS.: Toda classe filha é obrigada a implementar esse método
}



class Aluno extends Pessoa {
    //variavel que vai auxiliar na gestão de notas do aluno
    private List<Double> notas;

    //metodo construtor da classe Aluno
    public Aluno(String nome, String matricula){
        super(nome, matricula);
        //inicializando variável com Arraylist<>();
        this.notas = new ArrayList<>();
    }

    //metodo para adicionar nota do aluno no arrayList notas
    public void adicionarNota(double nota){
        if(nota >=0 && nota <=10){
            this.notas.add(nota);
        }else{
            System.out.println("Erro: Nota inválida para o aluno " + getNome());
        }
    }

    //metodo para calcular media do aluno
    public double calcularMedia(){
        if (notas.isEmpty()) return 0.0;

        double soma = 0;
        for(double nota : notas){
            soma += nota;
        }
        return soma / notas.size();
    }

    //metodo que garante que classes filhas possam sobrescrever sem criar uma nova.
    @Override
    public void exibirDados(){
        System.out.println("=== Ficha do Aluno ===");
        System.out.println("Nome: " + getNome());
        System.out.println("Matricula: " + getRegistroDigital());
        System.out.printf("Média Atual: %.2f%n", calcularMedia());
        System.out.println("Status" + (calcularMedia() >= 7 ? "Aprovado" : "Em recuperação"));
    }

}

