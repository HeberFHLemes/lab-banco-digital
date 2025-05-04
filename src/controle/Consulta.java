package controle;

import banco.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
                informacoesGeraisBanco(banco);
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

    private static void informacoesGeraisBanco(Banco banco){
        System.out.println("=== Informações gerais sobre o banco ===");
        // Nome
        System.out.println("Nome do banco: " + banco.getNome());

        // Data de fundação
        System.out.println("Data de fundação: " + LocalDate.now());

        if (banco.getContas().isEmpty()){
            System.out.println("Ainda não há contas registradas. ");
            return;
        }

        // Número de contas cadastradas
        System.out.println("Número total de contas cadastradas: " + banco.getContas().size());

        // Transação mais cara "da história do banco"

        // Número total de operações "ao longo da história do banco"

        // Cliente mais rico e clientes negativados
        Conta contaComMaiorSaldo = banco.getContas().get(0);
        List<Conta> negativados = new ArrayList<>();

        for (Conta c : banco.getContas()){
            if (c.getSaldo() > contaComMaiorSaldo.getSaldo()){
                contaComMaiorSaldo = c;
            }

            if (c.getSaldo() < 0){
                negativados.add(c);
            }
        }

        System.out.println("Conta mais rica do banco: " + contaComMaiorSaldo.getNumero());
        System.out.println("Contas negativadas: " + negativados);
    }
}
