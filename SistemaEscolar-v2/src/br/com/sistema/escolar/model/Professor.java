package br.com.sistema.escolar.model;

import br.com.sistema.escolar.auth.Autenticavel;

public class Professor extends Pessoa implements Autenticavel{

    private String especialidade;
    private double salario;

    //variavel para guardar a senha padrão para Professor
    private static final String SENHA_PADRAO = "admin123";

    //Construtor da classe
    public Professor(String nome, String registroFuncional, String especialidade, double salario){
        super(nome, registroFuncional);
        this.especialidade = especialidade;
        //função com encapsulamento e validação
        setSalario(salario);
    }

    //Setters
    public void setSalario(double salario){
        if(salario <= 0){
            throw new IllegalArgumentException("Salário deve ser maior que zero.");
        }else{
            this.salario = salario;  
        }
    }

    //Getters
    public double getSalario(){
        return salario;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    //Prática do polimorfismo, reutilizando método para subscrever tratando login
    @Override
    public boolean login(String usuario, String senha){
        if(usuario == null || senha == null){
            return false;
        }else{
            return getRegistroDigital().equals(usuario) && SENHA_PADRAO.equals(senha);
        }
    }
    //Prática com método que será sobrescrito para lidar com os dados formatados em CSV
    @Override
    public String toCSV(){
        return "Professro" + getNome() +"," + getRegistroDigital() + "," + getEspecialidade() + "," + getSalario();
    }

    @Override
    public void exibirDados(){
        System.out.println("\n === Registro do Professor");
        System.out.println("Nome: " + getNome());
        System.out.println("ID_Funcional: " + getRegistroDigital());
        System.out.println("Disciplina: " + getEspecialidade());
        System.out.printf("Remuneração: R$ %.2f%n", getSalario());


    }

}
