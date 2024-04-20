# develcode-cadastro-usuario
Repositório destinado ao "TESTE CADASTRO BÁSICO USUÁRIO"

## Tecnologias
- Java
- Spring Boot
- React JS

## Pré-requisitos
- Java JDK 8 ou superior
- Node.js
- npm (gerenciador de pacotes do Node.js)

## Ambiente de desenvolvimento usado
Este projeto foi desenvolvido utilizando as seguintes ferramentas:

- **IntelliJ IDEA**: Uma poderosa IDE para desenvolvimento Java, utilizada para escrever, depurar e executar o código do projeto.
- **VS Code**:Conhecido por sua leveza, interface intuitiva e extensibilidade, proporcionando uma experiência de desenvolvimento eficiente e produtiva.
- **Maven**: Ferramenta de automação de compilação utilizada para gerenciar as dependências do projeto e realizar builds.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência de dados. Recomenda-se a utilização do pgAdmin ou de outras ferramentas de administração para gerenciar o banco de dados.
- **Postman**: Uma plataforma de colaboração para desenvolvimento de APIs. Utilizado para testar endpoints e realizar requisições HTTP durante o desenvolvimento da aplicação.

Certifique-se de ter essas ferramentas instaladas e configuradas corretamente para uma experiência de desenvolvimento sem problemas.

## Instalando o projeto

Primeiro você deve clonar o repositório,

```bash
# Clone o repositório
$ git clone https://github.com/biancabalabenute/develcode-cadastro-usuario.git
```

Agora, dentro do IntelliJ, instale as depedências com o Maven.
```bash
cd backend
mvn install
```
Agora, dentro do VSCode, instale as depedências com o node.
```bash
cd frontend
npm install
```

## Banco de dados
Para o banco estou usando o PostgreSQL na porta padrão 5432. Importante criar um BD com o nome develcodeDB. Mude a senha para a que você definiu quando instalou o BD e o usuário se for diferente do padrão.
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/develcodeDB
spring.datasource.username=postgres
spring.datasource.password=bia123
```

## Executando o arquivo
Por fim, você pode executar o backend e em seguida o frontend e testar as requisições.
