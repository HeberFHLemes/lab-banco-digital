package banco;

import java.util.Comparator;
import java.time.LocalDate;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Banco {

    private final String nome; // Nome do banco

    /**
        HashMap contendo as contas registradas.
        Key é o número (que deve ser único) da conta
        Value será o objeto conta
     */
    private Map<Integer, Conta> contas;

    public Banco(String nome){
        this.nome = nome;
        this.contas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public Map<Integer, Conta> getContas() {
        return contas;
    }

    // Listar todas as operações realizadas pelo banco
    public void listarOperacoes(){
        contas.values().forEach(conta -> conta.operacoes.forEach(System.out::println));
    }

    // Listar todas as contas cadastradas
    public void listarContas(){
        contas.values().forEach(System.out::println);
    }

    // Adiciona a conta ao HashMap de contas, com key = número da conta e value = objeto conta.
    public void registrarNovaConta(Conta conta){
        this.contas.put(conta.getNumero(), conta);
    }

    // Retorna a conta procurada pelo número ou null
    public Conta procurarConta(int numero){
        return contas.get(numero);
    }

    // Transação mais cara "da história do banco"
    public Operacao getTransacaoMaisCara(){

        // Uso de stream(), flatmap() e max() para retornar a operação que contenha o atributo 'valor' maior
        // (Pode retornar null)
        return contas.values().stream()
                .flatMap(c -> c.getOperacoes().stream())
                .max(Comparator.comparingDouble(Operacao::getValor))
                .orElse(null);

    }

    // Número total de operações "ao longo da história" do banco
    public int getNumeroTotalDeOperacoes(){

        // Uso de stream(), map() e reduce() para somar o número de total operações realizadas por cada conta e retorná-lo
        return contas.values().stream()
                .map(conta -> conta.getOperacoes().size())
                .reduce(0, Integer::sum);

    }

    // Retorna a conta com maior saldo
    public Conta getContaComMaiorSaldo(){

        // Retorna a conta com maior saldo, com o uso de stream(), max(), orElse() e Comparator.
        // (Pode retornar null)
        return contas.values().stream()
                .max(Comparator.comparingDouble(Conta::getSaldo))
                .orElse(null);

    }

    // Retorna uma lista de contas com saldo menor que 0
    public List<Conta> getContasNegativadas(){

        // Uso de stream(), filter() e toList()
        return contas.values().stream().filter(conta -> conta.getSaldo() < 0).toList();

    }

    @Override
    public String toString() {
        return this.nome;
    }

    // Para uso em Consulta: lista diversas informações sobre o banco, de
    public void listarInformacoesDoBanco(){

        System.out.println("=== Informações gerais sobre o banco ===");

        // Nome do banco
        System.out.println("Nome do banco: " + nome);

        // Data de fundação (escopo do projeto impõe 'fundacao' do banco como a data da execução do programa)
        System.out.println("Data de fundação: " + LocalDate.now());

        // Retorna antes de realizar as operações seguintes, caso não haja contas cadastradas ainda
        if (contas.isEmpty()){
            System.out.println("Ainda não há contas registradas. ");
            return;
        }

        // Número de contas cadastradas
        System.out.println("Número total de contas cadastradas: " + contas.size());

        // Transação mais cara "da história" do banco
        Operacao maisCara = getTransacaoMaisCara();
        System.out.println("Operação mais cara: " + (maisCara != null ? maisCara : "Ainda sem operações mais caras. "));

        // Número total de operações "ao longo da história do banco"
        System.out.println("Número total de operações realizadas: " + getNumeroTotalDeOperacoes());

        // Conta/Cliente mais rico (Cliente será impresso junto com a conta (toString())
        Conta maisRica = getContaComMaiorSaldo();
        if (maisRica != null){
            System.out.println("Conta mais rica do banco é: " + maisRica);
        }

        // Contas/Clientes negativados (Cliente será impresso junto com a conta (toString())
        List<Conta> contasNegativadas = getContasNegativadas();

        System.out.print("Contas negativadas: ");

        if (contasNegativadas.isEmpty()) System.out.println("Sem contas negativadas. ");
        else {
            System.out.println();
            contasNegativadas.forEach(System.out::println);
        }
    }
}
