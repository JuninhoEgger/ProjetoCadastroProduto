package projfinal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Venda objVenda = new Venda();
        ArrayList<Produto> produtos = objVenda.getListaDeProdutos();
        byte op;
        do {
            op = Byte.parseByte(JOptionPane.showInputDialog("SISTEMA DE VENDAS\n"
                    + "1 - CADASTRAR PRODUTO\n"
                    + "2 - MOSTRAR TODOS OS PRODUTOS\n"
                    + "3 - MOSTRAR QUANTIDADE DE PRODUTOS\n"
                    + "4 - PESQUISAR PRODUTOS POR DIA DE VALIDADE\n"
                    + "5 - PESQUISAR PRODUTOS POR VALOR UNITÁRIO\n"
                    + "6 - PESQUISAR PRODUTOS POR NOME\n"
                    + "7 - ALTERAR VALOR UNITÁRIO DO PRODUTO PESQUISANDO POR NOME\n"
                    + "8 - REMOVER PRODUTO PESQUISANDO POR NOME\n"
                    + "9 - MOSTRAR VALOR TOTAL DAS VENDAS\n"
                    + "10 - EXCLUIR TODOS OS PRODUTOS\n"
                    + "0 - SAIR\n"
                    + "Digite sua opção:"));
            Object[] meses = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
            Object[] dias = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
            switch (op) {
                case 1:
                    Produto objProduto = new Produto();
                    Produto resultadoDaBusca;
                    JOptionPane.showMessageDialog(null, "INFORME OS DADOS DO PRODUTO");
                    do {
                        objProduto.setNome(JOptionPane.showInputDialog("NOME"));
                        resultadoDaBusca = objVenda.pesquisarProdutoPorNome(objProduto.getNome());
                        if (resultadoDaBusca != null) {
                            JOptionPane.showMessageDialog(null, "PRODUTO JÁ CADASTRADO\n"
                                    + "DIGITE NOVAMENTE", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (resultadoDaBusca != null);

                    do {
                        objProduto.setValorUnitario(Double.parseDouble(JOptionPane.showInputDialog("VALOR UNITÁRIO")));
                        if (objProduto.getValorUnitario() < 0) {
                            JOptionPane.showMessageDialog(null, "VALOR INVÁLIDO\n"
                                    + "DIGITE NOVAMENTE!");
                        }
                    } while (objProduto.getValorUnitario() < 0);
                    
                    JOptionPane.showMessageDialog(null, "INFORME A DATA DE VALIDADE DO PRODUTO");
                    do {
                        objProduto.getDataDeValidade().setDia(Byte.parseByte((String) JOptionPane.showInputDialog(null, "ESCOLHA O DIA", "DIAS", JOptionPane.INFORMATION_MESSAGE,null, dias, dias[0])));
                        objProduto.getDataDeValidade().setMes(Byte.parseByte((String) JOptionPane.showInputDialog(null, "ESCOLHA O MÊS", "MESES", JOptionPane.INFORMATION_MESSAGE,null , meses, meses[0])));
                        objProduto.getDataDeValidade().setAno(Integer.parseInt(JOptionPane.showInputDialog("ANO")));
                        if (!objProduto.getDataDeValidade().validarData()) {
                            JOptionPane.showMessageDialog(null, "DATA INVÁLIDA\n"
                                    + "DIGITE NOVAMENTE");
                        }
                    } while (!objProduto.getDataDeValidade().validarData());
                    produtos.add(objProduto);
                    JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO!");
                    break;
                case 2:
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                    } else {
                        JOptionPane.showMessageDialog(null, objVenda);
                    }
                    break;
                case 3:
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                    } else {
                        JOptionPane.showMessageDialog(null, "QUANTIDADE TOTAL DE PRODUTOS CADASTRADOS: " + produtos.size());
                    }
                    break;
                case 4:
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                    } else {
                        ArrayList<Produto> produtosNaValidade;
                        do {
                            produtosNaValidade = objVenda.pesquisarDiaValidade(Byte.parseByte((String) JOptionPane.showInputDialog(null, "INFORME O DIA PARA A PESQUISA", "PESQUISA POR DIAS", JOptionPane.INFORMATION_MESSAGE, null, dias, dias[0])));
                            if (produtosNaValidade.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "NENHUM PRODUTO FOI ENCONTRADO!");
                            } else {
                                String resposta = "";
                                for (int i = 0; i < produtosNaValidade.size(); i++) {
                                    resposta += produtosNaValidade.get(i) + "\n";
                                }
                                JOptionPane.showMessageDialog(null, "OS PRODUTOS ENCONTRADOS NESTA VALIDADE SÃO:\n" + resposta);
                            }
                        } while (produtosNaValidade.isEmpty());

                    }
                    break;
                case 5:
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                    } else {
                        ArrayList<Produto> produtosNoValorUnitario;
                        do {
                            produtosNoValorUnitario = objVenda.pesquisarValorUnitario(Double.parseDouble(JOptionPane.showInputDialog("INFORME O VALOR UNITÁRIO PARA EFETUAR A PESQUISA")));
                            if (produtosNoValorUnitario.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "NENHUM PRODUTO FOI ENCONTRADO!");
                            } else {
                                String resposta = "";
                                for (int i = 0; i < produtosNoValorUnitario.size(); i++) {
                                    resposta += produtosNoValorUnitario.get(i) + "\n";
                                }
                                JOptionPane.showMessageDialog(null, "OS PRODUTOS ENCONTRADOS COM ESTE VALOR UNITÁRIO SÃO:\n" + resposta);
                            }
                        } while (produtosNoValorUnitario.isEmpty());

                    }
                    break;
                case 6:
                case 7:
                case 8:
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                    } else {
                        Produto produtoEncontrado;
                        do {
                            produtoEncontrado = objVenda.pesquisarProdutoPorNome(JOptionPane.showInputDialog("DIGITE O NOME DO PRODUTO PARA EFETUAR A PESQUISA"));
                            if (produtoEncontrado == null) {
                                JOptionPane.showMessageDialog(null, "NENHUM PRODUTO COM ESTE NOME ESTÁ CADASTRADO!");
                            } else {
                                JOptionPane.showMessageDialog(null, "PRODUTO ENCONTRADO\n" + produtoEncontrado);
                                if (op == 7) {
                                    do {
                                        produtoEncontrado.setValorUnitario(Double.parseDouble(JOptionPane.showInputDialog("INFORME O NOVO VALOR UNITÁRIO DO PRODUTO")));
                                        if (produtoEncontrado.getValorUnitario() < 0) {
                                            JOptionPane.showMessageDialog(null, "VALOR UNITÁRIO INVÁLIDO\n"
                                                    + "DIGITE NOVAMENTE");
                                        }
                                    } while (produtoEncontrado.getValorUnitario() < 0);
                                } else if (op == 8) {
                                    op = (byte) JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA EXCLUIR ESSE PRODUTO?");
                                    if (op == 0) {
                                        op = 1;
                                        produtos.remove(produtoEncontrado);
                                        JOptionPane.showMessageDialog(null, "PRODUTO EXCLUÍDO COM SUCESSO!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "EXCLUSÃO CANCELADA!");
                                    }
                                }
                            }

                        } while (produtoEncontrado == null);
                    }
                    break;
                case 9:
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                    } else {
                        JOptionPane.showMessageDialog(null, "VALOR TOTAL DAS VENDAS: R$ " + objVenda.calcularVenda());
                    }
                    break;
                case 10:
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                    } else {
                        op = (byte) JOptionPane.showConfirmDialog(null, "TEM CERTEZA ABSOLUTA QUE DESEJA APAGAR TODOS OS PRODUTOS CADASTRADOS?");
                        if (op == 0) {
                            op = 1;
                            produtos.clear();
                            JOptionPane.showMessageDialog(null, "TODOS OS PRODUTOS FORAM EXCLUÍDOS COM SUCESSO!");
                        } else {
                            JOptionPane.showMessageDialog(null, "EXCLUSÃO CANCELADA!");
                        }
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "                    SISTEMA ENCERRADO", "SISTEMA", JOptionPane.DEFAULT_OPTION);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA\n"
                            + "DIGITE NOVAMENTE");
            }
        } while (op != 0);

    }

}