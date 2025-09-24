# Projeto DIAMANTE
## Tecnologias Usadas

<div style="display: inline_block"><br> 
  <img aling="center" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
</div>

## INTEGRANTES
### Jhonantan Quispe Torrez
[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white
)](https://www.linkedin.com/in/jhonatan-quispe-torrez-360b60198/)[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/JhowQT)
### Julia Damasceno Busso
[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white
)](https://www.linkedin.com/in/jhonatan-quispe-torrez-360b60198/)[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/JhowQT)

### COMO USAR OS ENDPOINTS

- **METODO GET**
`localhost:8080`
> Retorna os Integrantes do Trabalho
_______________________________________________________________________________________________________
- **METODO GET/CONTA**
`localhost:8080:conta`
> Retorna todas as contas dentro do banco de dados
_______________________________________________________________________________________________________
- **METODO GET/CONTA/ID**
`localhost:8080/conta/1`
> Retorna a busca por id, onde o **id**, deve ser refente a conta existente
_______________________________________________________________________________________________________
- **METODO POST/CONTA**
`localhost:8080/conta`
> Referese a criação da conta
> **formato para a criação**
```json
{
  "numero": "",
  "agencia": "",
  "nomeTitular": "",
  "cpfTitular": "",
  "dataAbertura": "",
  "saldo": 0.0,
  "tipo": ""
}
Para o tipo: "", entrada esperada e corrente, 
poupança ou salário.
_______________________________________________________________________________________________________
- **METODO PUT/CONTA/1/ENCERRAR**
`localhost:8080/conta/1/encerrar`
>Refese ao encerramento da conta **encerrar** e o parametro para encerrar a conta
>Retorno esperado e `ativo=false`
_______________________________________________________________________________________________________
- **METODO PUT/CONTA/1/DEPOSITO?VALOR=100**
`localhost:8080/conta/1/deposito?valor=500`
>Para o deposito criamos a referencia de **deposito** e **valor** onde '=500' e o valor a ser depositado
_______________________________________________________________________________________________________
- **METODO PUT/CONTA/1/SAQUE?VALOR=100**
`localhost:8080/conta/1/saque?valor=500`
>Para o deposito criamos a referencia de **saque** e **valor** onde '=500' e o valor a ser sacado
_______________________________________________________________________________________________________
- **METODO PUT/CONTA/PIX?IdOrigen=1&IdDestino=2&valor=100**
`localhost:8080//conta/pix?idOrigem=1&idDestino=2&valor=100`
> Para a implementação do **PIX**, parametro **idOrigen** serve para inserirmos o **id** que vai enviar e o **IdDestino** redere-se ao **id** que vai receber o valor























