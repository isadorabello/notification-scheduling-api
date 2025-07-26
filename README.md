
# API - Agendamento de Notificações (Desafio Magalu)

Esse projeto foi desenvolvido para um desafio técnico visando apresentar habilidades de desenvolvedor java backend e tem como escopo o cadastro de notificações para posterior envio.



## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/isadorabello/notification-scheduling-api.git
```

Entre no diretório do projeto

```bash
  cd notification-scheduling-api
```

Rode o arquivo docker-compose

```bash
    docker-compose up --build
```

## Documentação da API

#### Cadastra notificações pendentes

```http
  POST /scheduling
```

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `emailDestinatario` | `string` | **Obrigatório**. Email do destinatário da notificação |
| `telefoneDestinatario` | `string` | **Obrigatório**. Telefone do destinatário da notificação |
| `dataHoraEnvio` | `string` | **Obrigatório**. Mensagem da notificação |
| `mensagem` | `string` | **Obrigatório**. Data hora do evento no formado dd-MM-yyyy HH:mm:ss |

#### Retorna uma notificação por id

```http
  GET /scheduling/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### Cancela uma notificação por id

```http
  DELETE /scheduling/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer cancelar |


## Rodando os testes

Para rodar os testes, rode o seguinte comando:

```bash
  mvn test
```
