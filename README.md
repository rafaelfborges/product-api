# API de Produtos

Desafio realizado durante o treinamento do programa Starter na GFT. O objetivo era aplicar os conceitos apreendidos de API's Rest com Spring. Para isso era necessário seguir os seguintes requisitos.

## Tecnologias

Java, Spring, Spring Data JPA, Spring Security, Spring Fox (OpenAPI), Lombok, Mapstruct, Flyway e Mysql.

## Requisitos

- Criar os domínios da API com base no modelo UML.
- Utilizar os contratos para os métodos POST.
- Usar validações
- Tratar exceções.
- Aplicar segurança na API com Oauth 2.
- Documentar a API utilizando OpenApi (Swagger2).
- Popular a base com dados para teste. 

### Modelo UML

![UML - Product API](https://raw.githubusercontent.com/rafaelfborges/docs-api/main/product-api/uml-product-api.png)

### Contrato

- Cliente
```json
{
    "nome": "Fulano",
    "email": "email@gmail.com",
    "senha": "123",
    "documento": "111.111.11-50"
}
```

- Produto
```json
{
    "nome": "Produto XYZ",
    "valor": 10.50,
    "promocao": true,
    "valorPromo": 9.50,
    "categoria": "eletronico",
    "imagem": "produto.jpg",
    "quantidade": 5,
    "fornecedor": {
      "id": 1
    }
}
```

- Fornecedor
```json
{
    "nome": "Produto XYZ",
    "cnpj": "XX.XXX.XXX/XXXX-XX"
}
```

- Venda
```json
{
    "fornecedor": {
      "id": 1
    },
    "cliente": {
      "id": 1
    },
    "produtos": [
      {
        "id": 1
      },
      {
        "id": 3
      }
    ],
    "dataCompra": "30/01/2020"
}
```

### Modelo de Endpoints

![Produtos](https://github.com/rafaelfborges/docs-api/blob/main/product-api/endpoint-products.png)
** Utilizar modelo em todos os endpoints.

### Destaques da implementação do projeto
- Tratamento de exceções.
- Migração de dados com Flyway.
- Os endpoints retornam páginas nas consultas.
- Conversão de entradas e saídas em DTO's com Map Struct.
- A documentação é feita em cima de interfaces, deixando os recursos (controllers), limpos.
