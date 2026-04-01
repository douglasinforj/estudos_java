# Aprendizados Aplicados
## Programação Orientada a Objetos (POO)
Uso de herança com a classe abstrata Pessoa sendo base para Aluno e Professor.
Aplicação de polimorfismo, permitindo tratar diferentes tipos (Aluno e Professor) de forma uniforme através de List<Pessoa>.
Implementação de classes abstratas com métodos obrigatórios (exibirDados e toCSV).
Uso de encapsulamento, protegendo atributos e validando dados via métodos (setSalario).
## Interfaces e Contratos
Criação da interface Autenticavel, demonstrando entendimento de contratos de comportamento.
Preparação da arquitetura para futuras implementações de autenticação.
## Estruturas de Dados
Utilização de Listas (ArrayList) para gerenciamento dinâmico de objetos.
Manipulação de coleções com diferentes tipos através de abstração (Pessoa).
## Lógica de Negócio
Implementação de cálculo de média (calcularMedia) com validação de dados.
Regras de negócio aplicadas:
Validação de notas (0 a 10)
Definição de status do aluno (Aprovado / Recuperação)
Validação de salário (valor positivo)
💾 Persistência de Dados em Arquivo
Escrita de dados em arquivo .csv utilizando:
BufferedWriter
FileWriter
Uso de try-with-resources para gerenciamento automático de recursos.
Estruturação de dados no formato CSV para interoperabilidade.
## Tratamento de Exceções
Uso de try/catch para captura e tratamento de IOException.
Exibição de mensagens de erro controladas para o usuário.
## Boas Práticas de Código
Separação de responsabilidades (SRP):
Aluno e Professor → regras de negócio
GerenciadorDados → persistência
SistemaEscolarApp → execução
Código organizado e legível, com uso de:
Métodos bem definidos
Nomes semânticos
Uso de @Override para garantir consistência na sobrescrita de métodos.
## Polimorfismo na Prática
Iteração sobre List<Pessoa> chamando exibirDados() sem saber o tipo específico.
Demonstração clara de desacoplamento e extensibilidade.
## Organização de Projeto
Uso de package para organização (SistemaEscolar).
Estrutura pronta para evolução para arquiteturas mais robustas (MVC, API, etc.).