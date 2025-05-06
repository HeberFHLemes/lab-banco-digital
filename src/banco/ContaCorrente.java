package banco;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente(String nome, String cpf) {
        super(new Cliente(nome, cpf));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    @Override
    public String toString() {
        return  "Conta-Corrente {" +
                "Número da conta: '" + numero + '\'' +
                ", Agência: '" + agencia + '\'' +
                ", Saldo atual: '" + saldo + '\'' +
                ", Cliente/Titular: '" + cliente + "'}";
    }
}
