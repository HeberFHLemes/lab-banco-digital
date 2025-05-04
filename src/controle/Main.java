package controle;

import banco.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Banco b = new Banco("Banco Exemplo");
        menuInicial(b);

        int escolha = -1;
        try (Scanner scanner = new Scanner(System.in)){
            do {
                menu();
                escolha = getEscolha(scanner);
                switch (escolha){
                    case 1:
                        CriacaoDeConta.criarConta(b, scanner);
                        break;
                    case 2:
                        OperacaoBancaria.realizarOperacoes(b, scanner);
                        break;
                    // case 3:
                        // Consulta.consultarConta(b, scanner);
                        // break;
                    case 4:
                        Consulta.consultarBanco(b, scanner);
                        break;
                    default:
                        System.out.println("Opção inválida. ");
                        break;
                }
            } while (escolha != 0);
        }
        System.out.println("=== Até breve! ===");
    }

    public static int getEscolha(Scanner scanner){
        int escolha;
        try {
            escolha = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            escolha = -1;
        }
        return escolha;
    }

    private static void menuInicial(Banco banco){
        System.out.println("==========================");
        System.out.printf("      %s%n", banco.getNome().toUpperCase());
        System.out.println("==========================");
        System.out.println("    Seja bem-vindo(a)!    \n");
    }

    private static void menu(){
        System.out.println("""
        [1]. Criar nova conta
        [2]. Realizar operações bancárias
        [3]. Consultar informações da conta
        [4]. Consultar informações do banco
        [0]. Sair
        """);
    }
}
