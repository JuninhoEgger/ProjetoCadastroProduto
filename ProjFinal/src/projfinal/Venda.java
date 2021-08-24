package projfinal;

import java.util.ArrayList;

public class Venda {

    private ArrayList<Produto> listaDeProdutos;

    public Venda() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public double calcularVenda() {
        double soma = 0;
        for (int i = 0; i < this.listaDeProdutos.size(); i++) {
            soma += this.listaDeProdutos.get(i).getValorUnitario();
        }
        return soma;
    }

    public Produto pesquisarProdutoPorNome(String nome) {
        for (int i = 0; i < this.listaDeProdutos.size(); i++) {
            if (this.listaDeProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
                return this.listaDeProdutos.get(i);
            }
        }
        return null;
    }

    public ArrayList<Produto> pesquisarDiaValidade(byte dia) {
        ArrayList<Produto> produtosNaValidade = new ArrayList<>();
        for (int i = 0; i < this.listaDeProdutos.size(); i++) {
            if (this.listaDeProdutos.get(i).getDataDeValidade().getDia() == dia) {
                produtosNaValidade.add(this.listaDeProdutos.get(i));
            }
        }
        return produtosNaValidade;
    }

    public ArrayList<Produto> pesquisarValorUnitario(double valorUnitario) {
        ArrayList<Produto> produtosNoValorUnitario = new ArrayList<>();
        for (int i = 0; i < this.listaDeProdutos.size(); i++) {
            if (this.listaDeProdutos.get(i).getValorUnitario() == valorUnitario) {
                produtosNoValorUnitario.add(this.listaDeProdutos.get(i));
            }
        }
        return produtosNoValorUnitario;
    }

    @Override
    public String toString() {
        String resposta = "";
        for (int i = 0; i < this.listaDeProdutos.size(); i++) {
            resposta += this.listaDeProdutos.get(i) + "\n";
        }

        return "LISTA DE PRODUTOS\n" + resposta;
    }

}
