package model;
import util.Teclado;

public class Loja {
    // Atributos
    private String nome;
    private int quantidadeFuncionarios;
    private int salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private String tipo;
    private int numeroDaLoja;

    // Construtor com todos os atributos
    public Loja(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario, Endereco endereco, int numeroDaLoja, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.numeroDaLoja = numeroDaLoja;
    }

    // Construtor com nome e quantidade de funcionários
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1; 
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public int getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(int salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroDaLoja() {
        return numeroDaLoja;
    }

    @Override
    public String toString() {
    return "Loja: " + nome +
           "\nFuncionários: " + quantidadeFuncionarios +
           "\nSalário Base por Funcionário: " + 
           (salarioBaseFuncionario == -1 ? "Não definido" : "R$ " + salarioBaseFuncionario) +
           "\nTamanho da Loja: " + tamanhoDaLoja() + "\n" +
           "Endereço: " + endereco.toString() + "\n" +
           "Data de Fundação: " + dataFundacao.toString() + "\n" +
            "Numero da loja (ID): " + numeroDaLoja + "\n";
    }

    public double gastosComSalario() {
        if(salarioBaseFuncionario == -1){
            return -1;
        }
        return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    public char tamanhoDaLoja(){
        if(quantidadeFuncionarios < 10) {
            return 'P';
        } else if (quantidadeFuncionarios <= 30) {
            return 'M';
        } else {
            return 'G';
        }
    }
}