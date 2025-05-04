package banco;

import java.time.LocalDate;

public class Operacao {

    private TipoOperacao tipo;
    private LocalDate data;
    private double valor;
    private Conta conta;
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
        return "Operacao{" +
                "tipo='" + tipo + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                ", conta=" + conta +
                ", contaDestino=" + (contaDestino != null ? contaDestino.toString() : "") +
                '}';
    }
}

