# 💻 ITAÚ UNIBANCO - DESAFIO BACKEND 💵

## **Endpoints**

### ```POST /transacao```
- Ambos os campos não podem ser nulos;


- dataHora <= LocalDateTime.now()


- valor >= 0<br>
### ***Deve retonar:***
```json
{
"valor": 123.45,
"dataHora": "2020-08-07T12:34:56.789-03:00"
}
```
### ***RESPONSE HTTP STATUS***
- ```201 Created``` - Sem nenhum corpo
  A transação foi aceita (ou seja foi validada, está válida e foi registrada)


- ```422 Unprocessable``` - Entity sem nenhum corpo
  A transação não foi aceita por qualquer motivo
  (1 ou mais dos critérios de aceite não foram atendidos - por exemplo: uma transação com valor menor que 0)


- ```400 Bad Request``` - Sem nenhum corpo
  A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido)

### ```DELETE /transacao```
- Este endpoint simplesmente apaga todos os dados de transações que estejam armazenados.
### ***RESPONSE HTTP STATUS***
- ```200 OK``` sem body, todas as informações foram apagadas com sucesso.

### ```GET /estatistica```
- Este endpoint deve retornar estatísticas das transações
que aconteceram nos últimos 60 segundos (1 minuto).

### ***RESPONSE HTTP STATUS***
```200 OK``` com os dados das estatísticas.
- Um JSON com os campos ```count```, ```sum```, ```avg```, ```min``` e ```max``` todos preenchidos com seus respectivos valores
Atenção! Quando não houver transações nos últimos 60 segundos considere
todos os valores como ```0``` (zero)


- Deve retornar:
```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

| Campo | Significado                                               | Obrigatório? |
|-------|-----------------------------------------------------------|--------------|
| count | Quantidade de transações nos últimos 60 segundos          | Sim          |
| sum   | Soma total do valor transacionado nos últimos 60 segundos | Sim          |
| avg   | Média do valor transacionado nos últimos 60 segundos      | Sim          |
| min   | Menor valor transacionado nos últimos 60 segundos         | Sim          |
| max   | Maior valor transacionado nos últimos 60 segundos         | Sim          |
