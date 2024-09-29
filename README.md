
# Projeto de Leilão com Padrão Observer

Este projeto implementa um sistema de leilão em Java utilizando o padrão de design **Observer**. O sistema é composto por classes que representam o leiloeiro e os licitantes. Cada licitante é um observador que é notificado a cada novo lance, e o leiloeiro é o sujeito que gerencia os lances e notifica os licitantes.

## Estrutura de Diretórios

```plaintext
src
└── main
    └── java
        └── com
            └── leilao
                ├── app
                │   └── Main.java
                ├── interfaces
                │   ├── Observer.java
                │   └── Subject.java
                └── models
                    ├── Leiloeiro.java
                    └── Licitante.java
```

## Funcionalidades

- **Licitantes**: Podem fazer lances durante o leilão.
- **Leiloeiro**: Recebe os lances e notifica os licitantes sobre novos valores.
- **Notificação**: Cada licitante é notificado quando um novo lance maior é realizado.
- **Vencedor**: O leiloeiro pode anunciar o vencedor ao final do leilão, informando o nome do licitante e o valor do maior lance.

## Como o Sistema Funciona

1. O **Leiloeiro** recebe os lances dos **Licitantes**.
2. Cada vez que um novo lance é feito, se for maior que o atual, todos os licitantes são notificados.
3. O **Leiloeiro** rastreia o licitante que fez o maior lance e pode anunciar o vencedor ao final do leilão.

## Exemplo de Código

Aqui está um exemplo de uso das classes do projeto:

```java
public class Main {
    public static void main(String[] args) {
        Leiloeiro leiloeiro = new Leiloeiro();
        Licitante licitante1 = new Licitante("Alice");
        Licitante licitante2 = new Licitante("Bob");

        leiloeiro.addObserver(licitante1);
        leiloeiro.addObserver(licitante2);

        leiloeiro.receberLance(licitante1, 100.0);
        leiloeiro.receberLance(licitante2, 150.0);
        leiloeiro.receberLance(licitante1, 200.0);

        leiloeiro.anunciarVencedor(); // Anuncia Alice como vencedora com um lance de 200.0
    }
}
```

## Métodos Importantes

### `Leiloeiro.java`

- `addObserver(Observer observer)`: Adiciona um licitante para ser notificado sobre os lances.
- `removeObserver(Observer observer)`: Remove um licitante da lista de notificação.
- `notifyObservers()`: Notifica todos os licitantes sobre o novo lance.
- `receberLance(Licitante licitante, double valor)`: Recebe o lance de um licitante e notifica os demais se for maior que o lance anterior.
- `anunciarVencedor()`: Anuncia o licitante com o maior lance.

### `Licitante.java`

- `update(double valor)`: Método chamado quando um novo lance é feito, que notifica o licitante sobre o valor atual.

## Como Rodar o Projeto

### Pré-requisitos

- **Java 8** ou superior instalado.

### Passos para rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd seu-repositorio
   ```
3. Compile o projeto:
   ```bash
   javac -d bin src/main/java/com/leilao/**/*.java
   ```
4. Rode o projeto:
   ```bash
   java -cp bin com.leilao.app.Main
   ```

## Contribuição

Sinta-se à vontade para fazer um fork deste projeto e enviar pull requests com melhorias ou correções. Sugestões e feedbacks são bem-vindos!

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
