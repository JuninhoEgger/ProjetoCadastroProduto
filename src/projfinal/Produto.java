package projfinal;

import java.text.DecimalFormat;

public class Produto {
    private String nome;
    private double valorUnitario;
    private Data dataDeValidade;

    public Produto() {
        this.dataDeValidade = new Data();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Data getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(Data dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("R$ ##,00.00");
        return "\n"
                + "Nome: " + nome + "\n"
                + "Valor unitário: " + f.format(valorUnitario) + "\n"
                + "Data de validade: " + dataDeValidade;
    }

}
