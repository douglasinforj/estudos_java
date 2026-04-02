package br.com.sistema.escolar.auth;

public interface Autenticavel {
    boolean login(String usuario, String senha);
}
