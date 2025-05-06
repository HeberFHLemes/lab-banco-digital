package banco;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    public ContaPoupanca(String nome, String cpf){
        super(new Cliente(nome, cpf));
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
