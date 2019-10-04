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

Rota para incluir Categoria: __URL/categoria/incluir__
```
{
	"descricao": "Frutas"
}
```

Rota para alterar Categoria: __URL/categoria/alterar/{id_categoria}__
```
{
	"descricao": "Frutas Vermelhas"
}
```

Rota para excluir Categoria: __URL/categoria/remover/{id_categoria}__

Rota para listar TODAS Categorias: __URL/categoria/listar__

Rota para incluir Palavra: __URL/palavra/incluir__ 
```
{
	"palavra": "Morango",
	"dica": "Desenho infantil",
	"categoria": {
		"id": 1,
		"descricao": "Frutas Vermelhas"
	}
}
```
Rota para alterar Palavra: __URL/palavra/alterar/{id_palavra}__ 
```
{
	"palavra": "Melancia",
	"dica": "Desenho infantil",
	"categoria": {
		"id": 1,
		"descricao": "Frutas Vermelhas"
	}
}
```

Rota para excluir Palavra: __URL/palavra/remover/{id_palavra}__

Rota para listar TODAS as Palavras: __URL/palavra/listar__

Rota para listar Palavras por Categoria: __URL/palavra/listar/{id_categoria}/categoria__

Rota para salvar Rodada do Jogador: __URL/rodada/jogador__
```
{
	"nome": "Leonardo",
	"pontuacao": "100",
	"categoria": {
		"id": 1,
		"descricao": "Frutas Vermelhas"
	}
}
```

Rota para listar o Ranking: __URL/ranking/listar__
