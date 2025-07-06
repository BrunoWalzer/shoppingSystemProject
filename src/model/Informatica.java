package model;
import util.Teclado;

public class Informatica extends Loja {
    private double seguroEletronicos;

    public Informatica(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario, Endereco endereco, int numeroDaLoja, Data dataFundacao, double seguroEletronicos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, numeroDaLoja, dataFundacao);
        this.seguroEletronicos = seguroEletronicos;
    }

    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }

    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }    

    @Override
    public String toString() {
        return super.toString() + "Seguro de Eletrônicos: " + seguroEletronicos + "\n";
    }
}