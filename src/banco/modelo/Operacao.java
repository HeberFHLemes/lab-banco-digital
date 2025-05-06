package banco.modelo;

import java.time.LocalDate;

public class Operacao {

    private final TipoOperacao tipo;
    private final LocalDate data;
    private final double valor;
    private final Conta conta;
    private Conta contaDestino;

    public Operacao(TipoOperacao tipo, double valor, Conta conta){
        this.tipo = tipo;
        this.data = LocalDate.now();
        this.valor = valor;
        this.conta = conta;
    }

    public Operacao(TipoOperacao tipo, double valor, Conta conta, Conta contaDestino){
        this.tipo = tipo;
        this.data = LocalDate.now();
        this.valor = valor;
        this.conta = conta;
        this.contaDestino = contaDestino;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public Conta getConta() {
        return conta;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Operacao de " + tipo +
                ", data: " + data +
                ", valor: " + valor +
                ", conta: " + conta +
                (contaDestino != null ? (", contaDestino: " + contaDestino) : "");
    }
}

