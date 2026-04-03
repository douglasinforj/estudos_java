package br.com.sistema.escolar.model;

public abstract class Pessoa {
    private String nome;
    private String registroDigital;

    //Método construtor Pessoa
    public Pessoa(String nome, String registroDigital){
        this.nome = nome;
        this.registroDigital = registroDigital;
    }
    //Encapsulamento
    public String getNome(){
        return nome;
    }
    public String getRegistroDigital(){
        return registroDigital;
    }
    //Métodos abstratos que serão utilizados pelos objetos
    public abstract void exibirDados();

    public abstract String toCSV();

}
