package banco.modelo;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
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
