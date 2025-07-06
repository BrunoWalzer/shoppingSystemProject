package model;
import util.Teclado;

public class Vestuario extends Loja {
    private boolean produtosImportados;

    public Vestuario(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario, Endereco endereco, int numeroDaLoja, Data dataFundacao, boolean produtosImportados) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, numeroDaLoja, dataFundacao);
        this.produtosImportados = produtosImportados;
    }

    public boolean getProdutosImportados() {
        return produtosImportados;
    }

    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    public boolean vendeOuNao() {
        return produtosImportados;
    }

    @Override
    public String toString() {
        return super.toString() + "Produtos Importados: " + produtosImportados + "\n";
    }

    // Este aqui é o novo método
    public static boolean perguntarSeVendeImportado() {
        int opcao = Teclado.leInt("Essa loja vende produtos importados?\n" + "Digite 1 para SIM ou 2 para NÃO");

        if (opcao == 1) {
            return true;
        } else if (opcao == 2) {
            return false;
        } else {
            System.out.println("\nOpção inválida, será considerado como 'não vende importados'.\n");
            return false;
        }
    }
}