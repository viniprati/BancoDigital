package banco;

public class BancoDigital {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        cc.depositar(100);
        cc.transferir(50, poupanca);

        cc.imprimirExtrato();
        System.out.println();
        poupanca.imprimirExtrato();
    }
}

class Cliente {
    private final String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) return;
        saldo -= valor;
    }

    public void depositar(double valor) {
        if (valor <= 0) return;
        saldo += valor;
    }

    public void transferir(double valor, Conta destino) {
        if (valor <= 0 || valor > saldo) return;
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void imprimirExtrato() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
    }
}

class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirExtrato();
    }
}
