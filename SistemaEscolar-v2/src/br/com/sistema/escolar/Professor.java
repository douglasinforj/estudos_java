package br.com.sistema.escolar;

public class Professor extends Pessoa implements Autenticavel{
    private String disciplina;
    private double salario;

    //Método construtor chamando atribustos da class pai Pessoa
    public Professor(String nome, String registroFuncional, String disciplina, double salario){
        super(nome, registroFuncional);
        this.disciplina = disciplina;
        //Método com encapsulamento para validar salário
        setSalario(salario);
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero");
        }
        this.salario = salario;
    }

    //Encapsulamento 
    public double getSalario(){
        return salario;
    }
    public String getDisciplina(){
        return disciplina;
    }

    @Override
    public boolean login(String usuario, String senha){
        //Simulando logica de autenticação
        return getRegistroDigital().equals(usuario) && "admin123".equals(senha);
        //Evita NullPointerException na senha
    }

    @Override
    public String toCSV(){
        return "PROFESSOR, " + getNome() + "," + getRegistroDigital() + "," + getDisciplina() + "," + getSalario();   
    }

    
    @Override
    public void exibirDados(){
        System.out.println("\n --- Registro do professor ---");
        System.out.println("Nome: " + getNome());
        System.out.println("ID_Funcional: " + getRegistroDigital());
        System.out.println("Disciplina: " + getDisciplina());
        System.out.printf("Remuneração: R$ %.2f%n", getSalario());
    }

}
