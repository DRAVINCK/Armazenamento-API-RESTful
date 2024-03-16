# Gerenciamento de Produtos e Itens Armazenados

Este é um projeto de exemplo para demonstrar o gerenciamento de produtos e itens armazenados em uma aplicação Java Web utilizando Spring Boot.

## Descrição do Projeto

Este projeto é uma aplicação Java Web que oferece funcionalidades básicas para gerenciamento de produtos e itens armazenados. Ele inclui:

- CRUD (Create, Read, Update, Delete) para produtos e itens armazenados.
- Endpoint para listar todos os produtos, cada um com um link para seus detalhes.
- Endpoint para listar todos os itens armazenados, cada um com um link para seus detalhes.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring HATEOAS
- MySQL 
- Maven

## Como Configurar e Executar o Projeto

1. Clone este repositório para sua máquina local:
`
git clone https://github.com/seu-usuario/nome-do-repositorio.git
`

3. Certifique-se de ter o JDK (Java Development Kit) e o Maven instalados em sua máquina.

4. Configure as informações do banco de dados no arquivo `application.properties` ou `application.yml`, conforme necessário.

5. Execute a aplicação usando o Maven:
`
mvn spring-boot:run
`

5. Acesse a aplicação em `http://localhost:8080` (ou a porta configurada).

## Endpoints Disponíveis

- `/api/products`: Endpoint para operações CRUD de produtos.
- `/api/storedItem`: Endpoint para operações CRUD de itens armazenados.
- `/api/products/all`: Endpoint para listar todos os produtos.
- `/api/storedItem/all`: Endpoint para listar todos os itens armazenados.








