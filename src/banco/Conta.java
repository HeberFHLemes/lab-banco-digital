package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Conta implements ContaBancaria {

    /* Automaticamente definir agencia como 1 e numero como um sequencial */
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected double saldo;
    protected int agencia;
    protected int numero;
    protected Cliente cliente; // Titular

    // Lista de operações realizadas pela conta
    protected List<Operacao> operacoes;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
        this.operacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {

        // Conferir saldo disponível
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente: " + this.saldo);
            return;
        }

        // Realizar operação
        this.saldo -= valor;

        // Registrar saque
        this.operacoes.add(new Operacao(TipoOperacao.SAQUE, valor, this));

        // Mensagem final
        System.out.println("Valor sacado com sucesso (" + valor + "), saldo atual: " + this.saldo);
    }

    @Override
    public void depositar(double valor) {

        // Realizar operação
        this.saldo += valor;

        // Registrar depósito
        this.operacoes.add(new Operacao(TipoOperacao.DEPOSITO, valor, this));

        // Mensagem final
        System.out.println("Valor depositado com sucesso (" + valor + "), saldo atual: " + this.saldo);
    }

    /* Realização de transferência entre contas */
    @Override
    public void transferir(double valor, ContaBancaria conta) {

        // Conferir saldo disponível
        if (valor > this.saldo){
            System.out.println("Saldo insuficiente: " + this.saldo);
            return;
        }

        // Realizar operação
        this.sacar(valor);
        conta.depositar(valor);

        // Registrar transação entre contas
        this.operacoes.add(new Operacao(TipoOperacao.TRANSFERENCIA, valor, this, (Conta) conta));

        // Mensagem final
        System.out.println("Transação realizada com sucesso (" + valor + "), saldo atual: " + this.saldo);
    }

    // Auxiliar utilizado na implementação de imprimirExtrato(), nas subclasses.
    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    /* Getters */
    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    @Override
    public String toString() {
        return "Conta{ " +
                "Número da conta: '" + numero + '\'' +
                ", Agência: '" + agencia + '\'' +
                ", Saldo atual: '" + saldo + '\'' +
                ", Cliente: '" + cliente + "' }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    public void listarOperacoes(){
        if (operacoes.isEmpty()){
            System.out.println("Ainda não foi realizada nenhuma operação. ");
            return;
        }
        operacoes.forEach(System.out::println);
    }
}
