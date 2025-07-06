package model;
import util.Teclado;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public Loja[] getLojas(){
        return lojas;
    }

    public void setLojas(Loja[] lojas){
        this.lojas = lojas;
    }

    public String toString() {
        return "Nome: " + nome + "\n" +
               "Endereco: " + endereco.toString() + "\n" +
               "Lojas: " + lojas.length;
    }

    public boolean insereLoja(Loja loja) {
        int i = loja.getNumeroDaLoja() - 1; // Posição correta no array
        if (i >= 0 && i < lojas.length) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String loja) {
        for(int i = 0; i < lojas.length; i++) {
            if(lojas[i] != null && lojas[i].getNome().equals(loja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public void imprimeLojas() {
        for (int i = 0; i < lojas.length; i++) {
            if(lojas[i] != null){
                System.out.println(lojas[i].getNome());
            } else {
                System.out.println("Loja " + (i + 1) + ": Vazia");
            }
        }
    }

    public int quantidadeLojasPorTipo(String tipoProcurado) {
    int contador = 0;

    if (tipoProcurado.equalsIgnoreCase("Cosmético")) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Cosmetico) {
                contador++;
            }
        }
    } else if (tipoProcurado.equalsIgnoreCase("Vestuário")) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Vestuario) {
                contador++;
            }
        }
    } else if (tipoProcurado.equalsIgnoreCase("Bijuteria")) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Bijuteria) {
                contador++;
            }
        }
    } else if (tipoProcurado.equalsIgnoreCase("Alimentação")) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Alimentacao) {
                contador++;
            }
        }
    } else if (tipoProcurado.equalsIgnoreCase("Informática")) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Informatica) {
                contador++;
            }
        }
    } else {
        return -1; // Tipo inválido
    }
    return contador;
}

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorSeguro = -1;
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Informatica) {
                Informatica lojaInfo = (Informatica) lojas[i];
                if (lojaInfo.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInfo.getSeguroEletronicos();
                    lojaMaisCara = lojaInfo;
                }
            }
        }
        return lojaMaisCara;
    }

    public Cosmetico lojaComTaxaComercializacaoMaisAlta() {
        Cosmetico lojaMaisCara = null;
        double maiorTaxa = -1;
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Cosmetico) {
                Cosmetico lojaCosmetico = (Cosmetico) lojas[i];
                if (lojaCosmetico.getTaxaComercializacao() > maiorTaxa) {
                    maiorTaxa = lojaCosmetico.getTaxaComercializacao();
                    lojaMaisCara = lojaCosmetico;
                }
            }
        }
        return lojaMaisCara;
    }

    public boolean verificaNumeroLojaValido(int numeroDaLoja) {
        if(numeroDaLoja > 0 && numeroDaLoja <= this.lojas.length) {
            System.out.println("Loja cadastrada no número: " + numeroDaLoja + "\n");
            return true;
        }
        System.out.println("Número da loja inválido: " + numeroDaLoja + " -> *Deve ser entre 1 e " + this.lojas.length + "*");
        return false;
    }

    public boolean procuraLojaPorNome(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: " + lojas[i]);
                return true;
            }
        }
        System.out.println("Loja não encontrada: " + nomeLoja);
        return false;
    }

    public boolean alteraDados(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: " + lojas[i]);
                lojas[i].setNome(Teclado.leString("Digite o novo nome da loja: "));
                return true;
            }
        }
        System.out.println("Loja não encontrada: " + nomeLoja);
        return false;
    }
}