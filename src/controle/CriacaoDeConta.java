package controle;

import banco.*;
import java.util.Scanner;

public class CriacaoDeConta {

    public static void criarConta(Banco banco, Scanner scanner){

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu cpf: ");
        String cpf = scanner.nextLine();

        System.out.println("Escolha o tipo de conta que desejas criar: ");

        System.out.println("""
                [1]. Conta Corrente
                [2]. Conta Poupança
                [0]. Cancelar e voltar
                """);
        int escolha = Main.getEscolha(scanner);

        if (escolha <= 0 || escolha > 2) {
            System.out.println("Voltando ao menu. ");
            return;
        }
        Conta novaConta;
        if (escolha == 1){
            novaConta = new ContaCorrente(new Cliente(nome, cpf));
        } else {
            novaConta = new ContaPoupanca(new Cliente(nome, cpf));
        }

        banco.registrarNovaConta(novaConta);
        System.out.println("Conta criada com sucesso! Número atribuído: " + novaConta.getNumero() + ". ");
    }
}
