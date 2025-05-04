package banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome; // Nome do banco
    private List<Conta> contas; // Lista de contas registradas

    public Banco(String nome){
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    // Listar todas as operações realizadas pelo banco
    public void listarOperacoes(){
        contas.forEach(conta -> conta.operacoes.forEach(System.out::println));
    }
}
