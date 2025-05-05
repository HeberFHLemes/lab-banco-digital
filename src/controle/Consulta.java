package controle;

import banco.*;

import java.time.LocalDate;
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

        // Nome do banco
        System.out.println("Nome do banco: " + banco.getNome());

        // Data de fundação (escopo do projeto impõe 'fundacao' do banco como a data da execução do programa)
        System.out.println("Data de fundação: " + LocalDate.now());

        // Retorna antes de realizar as operações seguintes, caso não haja contas cadastradas ainda
        if (banco.getContas().isEmpty()){
            System.out.println("Ainda não há contas registradas. ");
            return;
        }

        // Número de contas cadastradas
        System.out.println("Número total de contas cadastradas: " + banco.getContas().size());

        // Transação mais cara "da história" do banco
        Operacao maisCara = banco.getTransacaoMaisCara();

        if (maisCara != null) {
            System.out.println("Operação mais cara: " + maisCara);
        } else {
            System.out.println("Operação mais cara: Ainda sem operações mais caras");
        }

        // Número total de operações "ao longo da história do banco"
        System.out.println("Número total de operações realizadas: " + banco.getNumeroTotalDeOperacoes());

        // Conta/Cliente mais rico (Cliente será impresso junto com a conta (toString())
        Conta maisRica = banco.getContaMaisRica();
        if (maisRica != null){
            System.out.println("Conta mais rica do banco é: " + maisRica);
        } else {
            System.out.println("Não há clientes mais ricos. ");
        }

        // Contas/Clientes negativados (Cliente será impresso junto com a conta (toString())
        List<Conta> contasNegativadas = banco.getContasNegativadas();

        System.out.println("Contas negativadas: ");

        if (contasNegativadas.isEmpty()) System.out.println("Sem contas negativadas. ");
        else {
            contasNegativadas.forEach(System.out::println);
        }
    }
}
