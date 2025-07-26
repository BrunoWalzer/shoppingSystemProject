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

    public int quantidadeLojasPorTipo(TipoDeLoja tipoProcurado) {
        int contador = 0;

        if (tipoProcurado == TipoDeLoja.COSMETICO) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] instanceof Cosmetico) {
                    contador++;
                }
            }
        } else if (tipoProcurado == TipoDeLoja.VESTUARIO) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] instanceof Vestuario) {
                    contador++;
                }
            }
        } else if (tipoProcurado == TipoDeLoja.BIJUTERIA) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] instanceof Bijuteria) {
                    contador++;
                }
            }
        } else if (tipoProcurado == TipoDeLoja.ALIMENTACAO) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] instanceof Alimentacao) {
                    contador++;
                }
            }
        } else if (tipoProcurado == TipoDeLoja.INFORMATICA) {
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
        if (numeroDaLoja <= 0 || numeroDaLoja > this.lojas.length) {
            System.out.println("Número da loja inválido: " + numeroDaLoja + " -> *Deve ser entre 1 e " + this.lojas.length + "*");
            return false;
        }
        if (lojas[numeroDaLoja - 1] == null) {
            System.out.println("Loja cadastrada no número: " + numeroDaLoja + "\n");
            return true;
        } else {
            System.out.println("Já existe uma loja cadastrada nesse número: " + numeroDaLoja);
            return false;
        }
    }

    public boolean procuraLojaPorNome(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: \n" + lojas[i]);
                return true;
            }
        }
        System.out.println("Loja não encontrada: " + nomeLoja);
        return false;
    }

    public boolean alteraNomeDaLoja(String nomeLoja) {
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

    public boolean alteraNumeroDeLoja(String nomeLoja) {
        for(int i = 0; i < lojas.length; i++) {
            if (nomeLoja != null && nomeLoja.equalsIgnoreCase(lojas[i].getNome())) {
                System.out.println("Loja encontrada: " + lojas[i]);
                int novoNumero = Teclado.leInt("Digite o novo número da loja: ");
                if (verificaNumeroLojaValido(novoNumero)) {
                    lojas[i].setNumeroDaLoja(novoNumero);
                    return true;
                } else {
                    System.out.println("Número inválido, não foi possível alterar.");
                }

            }
        }

        return false;
    }

    public boolean confereTipoDeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] instanceof Bijuteria && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: " + lojas[i]);
                int novaMeta = Teclado.leInt("Digite a nova meta de vendas: ");
                ((Bijuteria)lojas[i]).setMetaVendas(novaMeta);
                return true;
            } else if (lojas[i] instanceof Cosmetico && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: " + lojas[i]);
                int novaTaxaComercializacao = Teclado.leInt("Digite a nova taxa de comercialização: ");
                ((Cosmetico)lojas[i]).setTaxaComercializacao(novaTaxaComercializacao);
                return true;
            } else if (lojas[i] instanceof Informatica && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: " + lojas[i]);
                double novoSeguro = Teclado.leDouble("Digite o novo valor do seguro dos eletrônicos: ");
                ((Informatica)lojas[i]).setSeguroEletronicos(novoSeguro);
                return true;
            } else if (lojas[i] instanceof Alimentacao && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: " + lojas[i]);
                int novoValorLivre = Teclado.leInt("Digite o novo valor da modalidade livre: ");
                ((Alimentacao)lojas[i]).setPrecoAlmocoLivre(novoValorLivre);
                return true;
            } else if (lojas[i] instanceof Vestuario && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                System.out.println("Loja encontrada: " + lojas[i]);
                boolean produtosImportadosEditados = ((Vestuario)lojas[i]).perguntarSeVendeImportado();
                ((Vestuario)lojas[i]).setProdutosImportados(produtosImportadosEditados);
                return true;
            }
        }
        return false;
    }

    public boolean alteraValorNumeroLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                int novoNumero = Teclado.leInt("Novo número da loja: ");
                if (verificaNumeroLojaValido(novoNumero) && lojas[novoNumero - 1] == null) {
                    Loja loja = lojas[i];
                    loja.setNumeroDaLoja(novoNumero);
                    lojas[i] = null;
                    lojas[novoNumero - 1] = loja;
                    System.out.println("Número e posição alterados!");
                    return true;
                } else {
                    System.out.println("Número inválido ou posição já ocupada.");
                    return false;
                }
            }
        }
        System.out.println("Loja não encontrada.");
        return false;
    }
}