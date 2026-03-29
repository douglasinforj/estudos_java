/* 
Para estudos podemos escrever tudo em um arquivo só mas respeitando que só pode haver
uma classe public
*/  

package SistemaEscolar;

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
    
}

