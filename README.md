#Documentação API
As instruções a seguir são para a API que gerencia informações sobre Pessoa, Endereço e Eletrodoméstico.

Pessoa
API para gerenciamento de pessoas.

GET /pessoa/{id}
Retorna uma pessoa pelo id.

Parâmetros

id: integer($int64) - Identificador único da pessoa.
Resposta

Código 200: Retorna a pessoa correspondente ao id fornecido.
json
Copy code
{
  "id": 0,
  "nome": "string",
  "data_nascimento": "2023-07-04",
  "email": "string",
  "telefone": "string",
  "sexo": "MASCULINO"
}
PUT /pessoa/{id}
Atualiza as informações de uma pessoa.

Parâmetros

id: integer($int64) - Identificador único da pessoa.
Corpo da requisição

json
Copy code
{
  "id": 0,
  "nome": "string",
  "data_nascimento": "2023-07-04",
  "email": "string",
  "telefone": "string",
  "sexo": "MASCULINO"
}
Resposta

Código 200: A pessoa foi atualizada com sucesso.
DELETE /pessoa/{id}
Deleta uma pessoa pelo id.

Parâmetros

id: integer($int64) - Identificador único da pessoa.
Resposta

Código 200: A pessoa foi deletada com sucesso.
GET /pessoa
Retorna todas as pessoas.

Resposta

Código 200: Retorna todas as pessoas.
json
Copy code
[
  {
    "id": 0,
    "nome": "string",
    "data_nascimento": "2023-07-04",
    "email": "string",
    "telefone": "string",
    "sexo": "MASCULINO"
  }
]
POST /pessoa
Adiciona uma nova pessoa.

Corpo da requisição

json
Copy code
{
  "id": 0,
  "nome": "string",
  "data_nascimento": "2023-07-04",
  "email": "string",
  "telefone": "string",
  "sexo": "MASCULINO"
}
Resposta

Código 200: A pessoa foi adicionada com sucesso.
Endereço
GET /enderecos/{id}
Retorna um endereço pelo id.

Parâmetros

id: integer($int64) - Identificador único do endereço.
Resposta

Código 200: Retorna o endereço correspondente ao id fornecido.
json
Copy code
{
  "id": 0,
  "rua": "string",
  "numero": "string",
  "bairro": "string",
  "cidade": "string",
  "estado": "string"
}
PUT /enderecos/{id}
Atualiza as informações de um endereço.

Parâmetros

id: integer($int64) - Identificador único do endereço.
Corpo da requisição

json
Copy code
{
  "id": 0,
  "rua": "string",
  "numero": "string",
  "bairro": "string",
  "cidade": "string",
  "estado": "string"
}
Resposta

Código 200: O endereço foi atualizado com sucesso.
