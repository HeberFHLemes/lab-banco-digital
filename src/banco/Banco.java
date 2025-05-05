package banco;

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

    public void registrarNovaConta(Conta conta){
        this.contas.put(conta.getNumero(), conta);
    }

    public Conta procurarConta(int numero){
        return contas.get(numero); // retorna a conta ou null!
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
