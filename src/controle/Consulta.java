package controle;

import banco.*;

import java.util.Scanner;

public class Consulta {
    public static void consultarBanco(Banco banco, Scanner scanner){
        System.out.println("=== Consultar Banco ===");

        System.out.println("O que deseja consultar sobre o banco " + banco.getNome());
        System.out.println("""
                [1]. Informações gerais
                [2]. Contas registradas
                [3]. Operações registradas
                [0]. Cancelar
                """);
        int escolha = Main.getEscolha(scanner);
        switch (escolha){
            case 1:
                banco.listarInformacoesDoBanco();
                break;
            case 2:
                System.out.println("=== Contas registradas no banco ===");
                banco.listarContas();
                break;
            case 3:
                System.out.println("=== Operações registradas no banco ===");
                banco.listarOperacoes();
                break;
            default:
                System.out.println("Voltando ao menu. ");
        }
    }

    public static void consultarConta(Banco banco, Scanner scanner) {

        System.out.println("=== Consultar Conta ===");

        System.out.println("Digite o número da conta desejada: ");
        int numero = Integer.parseInt(scanner.nextLine());

        Conta conta = banco.procurarConta(numero);
        if (conta == null) {
            System.out.println("Nenhuma conta foi encontrada com este número. ");
            return;
        }

        System.out.println("O que deseja consultar sobre a conta '" + conta.getNumero() + "' ?");
        System.out.println("""
                [1]. Imprimir Extrato
                [2]. Operações registradas
                [0]. Cancelar
                """);
        int escolha = Main.getEscolha(scanner);
        switch (escolha){
            case 1:
                conta.imprimirExtrato();
                break;
            case 2:
                System.out.println("=== Operações realizadas pela conta ===");
                conta.listarOperacoes();
                break;
            default:
                System.out.println("Voltando ao menu. ");
        }
    }
}
