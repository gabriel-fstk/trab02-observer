
# TRAB02-OBSERVER: Sistema de Leilão Usando o Padrão Observer

Este projeto implementa um sistema de leilão simples utilizando o **Padrão Observer** em Java. No contexto do leilão, temos um leiloeiro (o **Sujeito**) e diversos licitantes (os **Observadores**). Os licitantes podem realizar lances, e o leiloeiro notifica a todos sobre a atualização do lance mais alto.

## Estrutura do Projeto

A estrutura do projeto está organizada da seguinte maneira:

```
src/
 └── main/
     └── java/
         └── com/
             └── leilao/
                 ├── app/
                 │   └── Main.java       # Ponto de entrada da aplicação
                 ├── interfaces/
                 │   ├── Observer.java   # Interface para os Observadores (Licitantes)
                 │   └── Subject.java    # Interface para o Sujeito (Leiloeiro)
                 └── models/
                     ├── Leiloeiro.java  # Classe do Leiloeiro que gerencia os lances
                     └── Licitante.java  # Classe dos Licitantes que realizam e observam os lances
```

### Classes e Interfaces

- **Main.java**: Classe principal que inicia o leilão, criando licitantes e leiloeiros.
- **Observer.java**: Interface que define o contrato para os observadores (licitantes). Contém o método `update()`, chamado quando o estado do sujeito muda.
- **Subject.java**: Interface que define o contrato para o sujeito (leiloeiro). Contém os métodos:
  - `addObserver(Observer o)`: Adiciona um observador.
  - `removeObserver(Observer o)`: Remove um observador.
  - `notifyObservers()`: Notifica todos os observadores sobre uma mudança.
- **Leiloeiro.java**: Implementa o leiloeiro, que mantém uma lista de observadores (licitantes) e notifica-os quando um novo lance é feito.
- **Licitante.java**: Implementa um licitante que observa o leiloeiro e faz lances.

## Padrão Observer

O **Padrão Observer** permite que objetos (observadores) sejam notificados sobre mudanças em outro objeto (sujeito). Neste caso:

- **Leiloeiro** é o **Subject** (sujeito).
- **Licitante** é o **Observer** (observador).

Cada vez que um licitante faz um lance, o leiloeiro notifica todos os outros licitantes com o valor atualizado do lance.

## Como Rodar o Projeto

### Pré-requisitos

- Java JDK 8 ou superior instalado.
- Um editor de código como VSCode ou IntelliJ IDEA.

### Executando o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/trab02-observer.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd trab02-observer
   ```

3. Compile e execute o programa:

   - Se estiver usando **VSCode**:
     - Abra o projeto e use a extensão **Java Extension Pack** para compilar e rodar.
   
   - Via terminal:
     ```bash
     javac -d bin src/main/java/com/leilao/app/Main.java
     java -cp bin com.leilao.app.Main
     ```

4. O programa iniciará o leilão e exibirá as atualizações dos lances conforme os licitantes fizerem suas ofertas.

## Exemplo de Uso

### Main.java

Aqui está um exemplo simplificado de como o sistema funciona na classe `Main`:

```java
package com.leilao.app;

import com.leilao.models.Leiloeiro;
import com.leilao.models.Licitante;

public class Main {
    public static void main(String[] args) {
        Leiloeiro leiloeiro = new Leiloeiro();

        Licitante licitante1 = new Licitante("Licitante 1");
        Licitante licitante2 = new Licitante("Licitante 2");

        leiloeiro.addObserver(licitante1);
        leiloeiro.addObserver(licitante2);

        leiloeiro.novoLance(500);  // Notifica os licitantes
        leiloeiro.novoLance(600);  // Notifica os licitantes
    }
}
```

### Resultado Esperado

```bash
Licitante 1 foi notificado. Novo lance: 500.0
Licitante 2 foi notificado. Novo lance: 500.0
Licitante 1 foi notificado. Novo lance: 600.0
Licitante 2 foi notificado. Novo lance: 600.0
```

## Métodos Implementados

### Subject (Leiloeiro)

- `void addObserver(Observer o)`: Adiciona um observador à lista.
- `void removeObserver(Observer o)`: Remove um observador da lista.
- `void notifyObservers()`: Notifica todos os observadores sobre uma mudança de estado.

### Observer (Licitante)

- `void update(double novoLance)`: Atualiza o estado do observador com o novo lance.

## Contribuições

Se você quiser contribuir com o projeto, sinta-se à vontade para abrir **issues** ou enviar **pull requests**. Todos os tipos de contribuição são bem-vindos!

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.
