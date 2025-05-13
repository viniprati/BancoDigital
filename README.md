# BancoDigital

Projeto simples em Java que simula um banco digital com contas correntes e poupança. Permite realizar depósitos, saques, transferências e exibir extratos.

## Estrutura

- **Cliente**: representa o titular da conta.
- **Conta (abstrata)**: base para contas bancárias.
- **ContaCorrente**: extensão da Conta, representa uma conta corrente.
- **ContaPoupanca**: extensão da Conta, representa uma conta poupança.
- **BancoDigital (main)**: executa um exemplo de uso.

## Funcionalidades

- Criar cliente e contas.
- Depositar valor.
- Transferir entre contas.
- Exibir extratos formatados.

## Exemplo de uso

Ao executar `BancoDigital.java`, o programa:

1. Cria um cliente chamado João.
2. Cria uma conta corrente e uma poupança para ele.
3. Deposita R$100 na conta corrente.
4. Transfere R$50 da conta corrente para a poupança.
5. Imprime os extratos de ambas.

## Saída esperada

```java
\=== Extrato Conta Corrente ===
Titular: João
Agência: 1
Número: 1
Saldo: R\$ 50.00

\=== Extrato Conta Poupança ===
Titular: João
Agência: 1
Número: 2
Saldo: R\$ 50.00
```



## Como rodar

1. Crie uma pasta chamada `banco`.
2. Salve o código em um arquivo `BancoDigital.java` dentro da pasta.
3. Compile e execute com:
   ```bash
   javac banco/BancoDigital.java
   java banco.BancoDigital
   ```
