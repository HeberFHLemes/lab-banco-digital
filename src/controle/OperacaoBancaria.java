package controle;

import banco.*;
import java.util.Scanner;

public class OperacaoBancaria {

    public static void realizarOperacoes(Banco banco, Scanner scanner){

        System.out.println("Digite o número da conta desejado: ");
        int numero = Integer.parseInt(scanner.nextLine());

        Conta conta = banco.procurarConta(numero);
        if (conta == null) {
            System.out.println("Nenhuma conta foi encontrada com este número. ");
            return;
        }

        System.out.println("Escolha qual operação deseja realizar: ");
        System.out.println("""
                [1]. SAQUE
                [2]. DEPÓSITO
                [3]. TRANSFERÊNCIA
                [0]. CANCELAR
                """);
        int op = Main.getEscolha(scanner);
        switch (op){
            case 1:
                realizarSaque(conta, scanner);
                break;
            case 2:
                realizarDeposito(conta, scanner);
                break;
            case 3:
                realizarTransferencia(banco, conta, scanner);
                break;
            case 0:
                System.out.println("Voltando ao menu. ");
        }
    }

    private static void realizarSaque(Conta conta, Scanner scanner){

        System.out.println("=== Realizar saque ===");

        System.out.println("Digite o valor a ser sacado da conta: ");
        double valor = Double.parseDouble(scanner.nextLine());

        conta.sacar(valor);
    }

    private static void realizarDeposito(Conta conta, Scanner scanner){
        System.out.println("=== Realizar depósito ===");

        System.out.println("Digite o valor a ser depositado: ");
        double valor = Double.parseDouble(scanner.nextLine());

        conta.depositar(valor);
    }

    private static void realizarTransferencia(Banco banco, Conta conta, Scanner scanner){

        System.out.println("=== Realizar transferência ===");

        System.out.println("Digite o número da conta a ser transferido o valor desejado: ");
        int numero = Integer.parseInt(scanner.nextLine());

        Conta contaAlvo = banco.procurarConta(numero);
        if (contaAlvo == null) {
            System.out.println("Nenhuma conta foi encontrada com este número. ");
            return;
        }

        System.out.println("Digite o valor a ser transferido para esta outra conta: ");
        double valor = Double.parseDouble(scanner.nextLine());

        conta.transferir(valor, contaAlvo);
    }
}
