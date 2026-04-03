package br.com.sistema.escolar.service;

import br.com.sistema.escolar.model.Pessoa;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class GerenciadorDados {
    private static final String DIRETORIO = "dados";
    private static final String ARQUIVO = "dados_sistema.csv";

    public static void salvarPessoas(List<Pessoa> pessoas){
        Path caminhoDiretorio = Paths.get(DIRETORIO);
        Path caminhoArquivo = caminhoDiretorio.resolve(ARQUIVO);

        try{
            if(Files.notExists(caminhoDiretorio)){
                Files.createDirectories(caminhoDiretorio);
            }
            try(BufferedWriter writer = Files.newBufferedWriter(caminhoArquivo)){
                for(Pessoa p : pessoas){
                    writer.write(p.toCSV());
                    writer.newLine();
                }
            }
            System.out.println("Dados Salvos em: " + caminhoArquivo.toAbsolutePath());
        }catch (IOException e) {
            throw new RuntimeException("Erro ao salvar dados", e);
        }
    }
}
