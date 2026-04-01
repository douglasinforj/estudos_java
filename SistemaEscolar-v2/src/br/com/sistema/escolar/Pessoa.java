package br.com.sistema.escolar;

public abstract class Pessoa {
    private String nome;
    private String registroDigital;

    //Método construtor da class
    public Pessoa (String nome, String registroDigital){
        this.nome = nome;
        this.registroDigital = registroDigital;
    }

    //Encapsulamento
    public String getNome() {
        return nome;
    }
    public String getRegistroDigital() {
        return registroDigital;
    }

    //Método abstract exibirDados personalizado de cada objeto
    public abstract void exibirDados();

    //Método abstract para organizar dados em texto CSV
    public abstract String toCSV();

}
