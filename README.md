# Spring Boot API - Jogo da Forca

API Rest em Java utilizando Spring Boot, contendo endpoints para página administrativa, persistência de jogadas e consulta de ranking do jogo da forca.

## Pré-requisitos

Instalações:
- JDK versão: 11
- Gradle versão 5.6.2
- Mysql versão: 5.7.25

Criação do banco de dados:<br/>
```
create database forca_db;
```

Observação:<br/>
Configurar no arquivo __application.yml__ com url, username e password do banco de dados, conforme exemplo abaixo:
```
datasource:
    url: jdbc:mysql://localhost:3306/forca_db
    username: root
    password: root
```
## Executar a aplicação
Acessar a pasta do projeto e executar os seguintes comandos:
```
gradle build
gradle bootRun
```
## Serviços 

Rota para incluir Categoria: __[URL]/categoria/incluir__
Exemplo:
```
{
	"descricao": "Frutas"
}
```

Rota para alterar Categoria: __[URL]/categoria/alterar/1__
Exemplo:
```
{
	"descricao": "Frutas Vermelhas"
}
```

Rota para excluir Categoria: __[URL]/categoria/remover/1__

Rota para listar TODAS Categorias: __[URL]/categoria/listar__
