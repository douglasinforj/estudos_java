package SistemaEscolar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//adicionando interface para simulação e Autenticação
interface Autenticavel {
    boolean login(String usuario, String senha);
}

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

    //método para formatar os dados
    public abstract String toCSV();
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
    public String toCSV(){
        return "ALUNO," + getNome() + "," + getRegistroDigital() + "," + calcularMedia();
    }

    @Override
    public void exibirDados(){
        System.out.println("\n --- Ficha do Aluno ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Matricula: " + getRegistroDigital());
        System.out.printf("Média Atual: %.2f%n", calcularMedia());
        System.out.println("Status: " + (calcularMedia() >= 7 ? "Aprovado" : "Em recuperação"));
    }
}

class Professor extends Pessoa implements Autenticavel{
    private String especialidade;
    private double salario;

    //metodo construtor Professor
    public Professor(String nome, String registroFuncional, String especialidade, double salario){
        super(nome, registroFuncional);
        this.especialidade = especialidade;
        setSalario(salario);   //função criada a seguir.
    }
    //encapsulando com logica de proteção
    public void setSalario( double salario){
        if(salario > 0){
            this.salario = salario;
        }else{
            System.out.println("Erro: Salario de ser valor positivo");
        }
    }
    public double getSalario(){
        return salario;
    }
    public String getEspecialidade(){
        return especialidade;
    }

    @Override
    public String toCSV() {
        return "PROFESSOR," + getNome() + "," + getRegistroDigital() + "," + getEspecialidade() + "," + getSalario();
    }

    @Override
    public boolean login(String usuario, String senha) {
        return usuario.equals(usuario) && senha.equals(senha);
    }

    @Override
    public void exibirDados(){
        System.out.println("\n --- Registro do professor ---");
        System.out.println("Nome: " + getNome());
        System.out.println("IDFuncional: " + getRegistroDigital());
        System.out.println("Disciplina: " + especialidade);
        System.out.printf("Remuneração: R$ %.2f%n",getSalario());
        System.out.println("\n");
    }
}

class GerenciadorDados {
    private static final String NOME_ARQUIVO = "Dados/dados_sistema.csv";

    public static void salvarPessoas(List<Pessoa> pessoas) {
        try {
            // Garante que a pasta existe
            Path path = Paths.get(NOME_ARQUIVO);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
                for (Pessoa p : pessoas) {
                    writer.write(p.toCSV());
                    writer.newLine();
                }
            }

            System.out.println("\n[Sucesso] Dados salvos em " + path.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}


//Classe principal (única public)
public class SistemaEscolarApp {
    public static void main(String[] args){

        //Adicionar Variavel para receber varios registros (array)
        List<Pessoa> listaPessoas = new ArrayList<>();    

        //Alunos
        Aluno aluno01 = new Aluno("Douglas Silva", "2026-java-01");
        aluno01.adicionarNota(8.5);
        aluno01.adicionarNota(7.0);
        aluno01.adicionarNota(9.0);
        aluno01.adicionarNota(3.0);

        Aluno aluno02 = new Aluno("Erick Roberto", "2026-java-02");
        aluno02.adicionarNota(9.5);
        aluno02.adicionarNota(7.8);
        aluno02.adicionarNota(7.0);
        aluno02.adicionarNota(9.0);

        //adicionando alunos a lista
        listaPessoas.add(aluno01);
        listaPessoas.add(aluno02);



        //Professor
        Professor pro01 = new Professor("Dr. Ricardo", "PRO-001","Desenvolvimento Java", 5500.00);
        listaPessoas.add(pro01);

        //mais do polimorfismo com exibirdados
        System.out.println("\n --- RELATÓRIO GERAL DO SISTEMA ---");
        for(Pessoa p : listaPessoas){
            p.exibirDados();
        }

        //Persistindo dados na prática
        GerenciadorDados.salvarPessoas(listaPessoas);

        //Teste de autenticação
        System.out.println("\n --- Teste de Login do professor ---");
        boolean login = pro01.login("PRO-001", "admin123");
        System.out.println(login ? "\n Login realizado com sucesso" : "Falha no login");
    }
}