package model;

public class Alimentacao extends Loja {
    private Data dataAlvara;
    private double precoAlmocoLivre;

    public Alimentacao(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario, Endereco endereco, int numeroDaLoja, Data dataFundacao, Data dataAlvara, double precoAlmocoLivre) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, numeroDaLoja, dataFundacao);
        this.dataAlvara = dataAlvara;
    }

    public Data getDataAlvara() {
        return dataAlvara;
    }

    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    public double getPrecoAlmocoLivre() {
        return precoAlmocoLivre;
    }

    public void setPrecoAlmocoLivre(double precoAlmocoLivre) {}

    @Override
    public String toString() {
        return super.toString() + "Data de Alvará: " + dataAlvara;
    }
}