# DevCalc API

DevCalc é uma API REST simples, escrita em Java, que disponibiliza operações matemáticas básicas
(soma, subtração, multiplicação e divisão). Ela será utilizada para praticar conceitos de
Integração Contínua (CI), Entrega Contínua (CD), Docker e Infra as Code.

## Tecnologias e ferramentas

- Linguagem: Java 17
- Build: Maven
- Framework web: Javalin
- Testes: JUnit (JUnit Jupiter)
- Container: Docker / Docker Compose
- CI/CD: GitHub Actions

## Como executar localmente

Pré-requisitos:
- Java 17 instalado (`java -version`)
- Maven instalado (`mvn -version`)

### Passos

1. Clonar o repositório:

   ```bash
   git clone https://github.com/SEU_USUARIO/devcalc-api.git
   cd devcalc-api
   ```

2. Compilar o projeto e rodar os testes:

   ```bash
   mvn clean test
   ```

3. Executar a aplicação:

   - Via Maven (execução direta):

     ```bash
     mvn exec:java -Dexec.mainClass=com.devcalc.App
     ```

   - Ou gerando o JAR com dependências:

     ```bash
     mvn clean package
     java -jar target/devcalc-api-1.0.0-jar-with-dependencies.jar
     ```

4. Acessar no navegador ou via `curl`:

   ```bash
   curl http://localhost:7000/
   ```

   Esperado: `DevCalc API - OK`
