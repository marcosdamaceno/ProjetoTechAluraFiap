# Documentação da API Projeto TEch

## Pessoa

API para gerenciamento de pessoas.

### GET /pessoa/{id}

Retorna uma pessoa pelo id.

**Parâmetros**

- `id`: integer($int64) - Identificador único da pessoa.

**Resposta**

- Código 200: Retorna a pessoa correspondente ao id fornecido.

```json
{
  "id": 0,
  "nome": "string",
  "data_nascimento": "2023-07-04",
  "email": "string",
  "telefone": "string",
  "sexo": "MASCULINO"
}
### PUT /pessoa/{id}
Atualiza os dados de uma pessoa.

#### Parâmetros
- `id`: integer($int64) - Identificador único da pessoa.

#### Corpo da requisição
```json
{
  "id": 0,
  "nome": "string",
  "data_nascimento": "2023-07-04",
  "email": "string",
  "telefone": "string",
  "sexo": "MASCULINO"
}

TESTE ALTERAÇÃO MAYCON
