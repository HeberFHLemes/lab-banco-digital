package banco;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Banco {

    private String nome; // Nome do banco

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
    public Conta getContaMaisRica(){

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
}
