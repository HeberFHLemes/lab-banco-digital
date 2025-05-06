package banco.modelo;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    @Override
    public String toString() {
        return  "Conta-Poupança {" +
                "Número da conta: '" + numero + '\'' +
                ", Agência: '" + agencia + '\'' +
                ", Saldo atual: '" + saldo + '\'' +
                ", Cliente/Titular: '" + cliente + "'}";
    }
}
