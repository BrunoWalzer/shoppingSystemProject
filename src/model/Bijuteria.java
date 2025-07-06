package model;
import util.Teclado;

public class Bijuteria extends Loja {
    private int metaVendas;

    public Bijuteria(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario, Endereco endereco, int numeroDaLoja, Data dataFundacao, int metaVendas) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, numeroDaLoja, dataFundacao);
        this.metaVendas = metaVendas;
    }

    public int getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(int metaVendas) {
        this.metaVendas = metaVendas;
    }

    @Override
    public String toString() {
        return super.toString() + "Meta de Vendas: R$" + metaVendas + "\n";
    }
}
