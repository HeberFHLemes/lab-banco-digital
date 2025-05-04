package banco;

/**
 * Interface para tornar claro a definição dos métodos básicos que uma conta bancária deverá ter
 */
public interface ContaBancaria {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, ContaBancaria conta);

    void imprimirExtrato();
}
