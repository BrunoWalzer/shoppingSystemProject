package view;

import model.*;
import util.Teclado;

public class Principal {
    public static void main(String[] args) {
        Shopping meuShopping = configurarShopping();
        System.out.println("\nShopping criado com sucesso: " + meuShopping.getNome() + "\n");

        while (true) {
            System.out.println("\n(1) Gerenciar Lojas \n(2) Gadgets de lojas  \n(9) Sair");
            int opcao = Teclado.leInt("Digite a opção desejada: ");

            switch (opcao) {
                case 1:
                    menuGerenciarLojas(meuShopping);
                    break;
                case 2:
                    menuGadgetsLojas(meuShopping);
                    break;
                case 9:
                    System.out.println("Saindo do programa...");
                    return; // encerra o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para configurar o shopping
    public static Shopping configurarShopping() {
        System.out.println("\nPara a criação de um novo Shopping: " + "\n");
        System.out.println("=-=-=-=-=- Dados do Shopping -=-=-=-=-=");

        Endereco enderecoShopping = new Endereco(
                "Rua exemplo",
                "Cidade Exemplo",
                "Estado Exemplo",
                "País Exemplo",
                "12345-678",
                "123",
                "Complemento Exemplo"
        );

        // Cria o shopping com o endereço, a quantidade de lojas e o nome
        int quantLojas = Teclado.leInt("Digite a quantidade de lojas que o Shopping possui: ");

        return new Shopping("Shopping Teste", enderecoShopping, quantLojas);
    }

    // Método para exibir o menu principal
    private static void menuPrincipal(Shopping meuShopping) {
        while (true) {
            System.out.println("\n(1) Gerenciar Lojas \n(2) Gadgets de lojas \n(9) Sair");
            int opcao = Teclado.leInt("Digite a opção desejada: ");

            if (opcao == 1) {
                menuGerenciarLojas(meuShopping);
            } else if (opcao == 2) {
                menuGadgetsLojas(meuShopping);
            } else if (opcao == 9) {
                System.out.println("Saindo do programa...");
                break;
            } else {
                System.out.println("\nOpção inválida, tente novamente\n");
            }
        }
    }

    // Método para gerenciar lojas
    private static void menuGerenciarLojas(Shopping meuShopping) {
        while (true) {
            System.out.println("\n(1) Criar loja \n(2) Excluir loja \n(3) Editar loja existente \n(4) Procurar loja por nome \n(5) Imprimir lojas existentes \n(0) Voltar ao menu principal");
            int opcaoLoja = Teclado.leInt("Digite a opção desejada: ");

            switch (opcaoLoja) {
                case 1:
                    menuPrincipalCriarLoja(meuShopping);
                    break;
                case 2:
                    menuPrincipalExcluirLoja(meuShopping);
                    break;
                case 3:
                    editarLoja(meuShopping);
                    break;
                case 4:
                    meuShopping.procuraLojaPorNome(Teclado.leString("\nDigite o nome da loja que deseja procurar: "));
                    break;
                case 5:
                    meuShopping.imprimeLojas();
                case 0:
                    System.out.println("\nVoltando ao menu principal...\n");
                    return; // Volta ao menu anterior
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    // Método para editar loja
    private static void editarLoja(Shopping meuShopping) {
        String nomeLoja = Teclado.leString("Digite o nome da loja que deseja editar: ");
        Loja loja = null;
        for (Loja l : meuShopping.getLojas()) {
            if (l != null && l.getNome().equalsIgnoreCase(nomeLoja)) {
                loja = l;
                break;
            }
        }
        if (loja == null) {
            System.out.println("Loja não encontrada.");
            return;
        }

        while (true) {
            System.out.println("\n(1) Editar nome da loja");
            System.out.println("(2) Editar data de fundação");
            System.out.println("(3) Editar número da loja");
            if (loja instanceof Bijuteria) {
                System.out.println("(4) Editar meta de vendas");
            } else if (loja instanceof Cosmetico) {
                System.out.println("(4) Editar taxa de comercialização");
            } else if (loja instanceof Informatica) {
                System.out.println("(4) Editar valor do seguro eletrônico");
            } else if (loja instanceof Alimentacao) {
                System.out.println("(4) Editar preço do almoço livre");
            } else if (loja instanceof Vestuario) {
                System.out.println("(4) Editar se vende produtos importados");
            }
            System.out.println("(0) Voltar");

            int opcao = Teclado.leInt("Digite a opção desejada: ");
            switch (opcao) {
                case 1:
                    loja.setNome(Teclado.leString("Digite o novo nome da loja: "));
                    System.out.println("Nome alterado!");
                    break;
                case 2:
                    int dia = Teclado.leInt("Novo DIA de fundação: ");
                    int mes = Teclado.leInt("Novo MÊS de fundação: ");
                    int ano = Teclado.leInt("Novo ANO de fundação: ");
                    loja.setDataFundacao(new Data(dia, mes, ano));
                    System.out.println("Data de fundação alterada!");
                    break;
                case 3:
                    meuShopping.alteraValorNumeroLoja(nomeLoja);
                    break;
                case 4:
                    if (loja instanceof Bijuteria) {
                        int novaMeta = Teclado.leInt("Nova meta de vendas: ");
                        ((Bijuteria)loja).setMetaVendas(novaMeta);
                        System.out.println("Meta de vendas alterada!");
                    } else if (loja instanceof Cosmetico) {
                        double novaTaxa = Teclado.leDouble("Nova taxa de comercialização: ");
                        ((Cosmetico)loja).setTaxaComercializacao(novaTaxa);
                        System.out.println("Taxa alterada!");
                    } else if (loja instanceof Informatica) {
                        double novoSeguro = Teclado.leDouble("Novo valor do seguro: ");
                        ((Informatica)loja).setSeguroEletronicos(novoSeguro);
                        System.out.println("Seguro alterado!");
                    } else if (loja instanceof Alimentacao) {
                        double novoPreco = Teclado.leDouble("Novo preço do almoço livre: ");
                        ((Alimentacao)loja).setPrecoAlmocoLivre(novoPreco);
                        System.out.println("Preço alterado!");
                    } else if (loja instanceof Vestuario) {
                        boolean vendeImportado = Vestuario.perguntarSeVendeImportado();
                        ((Vestuario)loja).setProdutosImportados(vendeImportado);
                        System.out.println("Informação alterada!");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Método para criar loja
    private static void  menuPrincipalCriarLoja(Shopping meuShopping) {
        Loja criarLoja = null;

        while (true) {
            System.out.println("\nEscolha o tipo da loja:");
            System.out.println("(1) Alimentação \n(2) Bijuteria \n(3) Cosmético \n(4) Informática \n(5) Vestuário");
            int opcaoTipoDeLoja = Teclado.leInt("Digite a opção: ");

            TipoDeLoja tipo = TipoDeLoja.fromCodigo(opcaoTipoDeLoja);

            if (tipo == null) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            System.out.println("Você escolheu: " + tipo);

            Data dataFundacao = new Data(
                    Teclado.leInt("Digite o DIA de fundação: "),
                    Teclado.leInt("Digite o MÊS de fundação: "),
                    Teclado.leInt("Digite o ANO de fundação: ")
            );

            int numeroDaLoja = Teclado.leInt("Digite o numero da loja (ID): ");
            // Verifica se o número da loja é válido
            while (!meuShopping.verificaNumeroLojaValido(numeroDaLoja)) {
                numeroDaLoja = Teclado.leInt("\nDigite outro número para a loja (ID): ");
            }

            Endereco enderecoLojas = meuShopping.getEndereco();

            switch (tipo) {
                case ALIMENTACAO:
                    Data dataAlvara = new Data(
                            Teclado.leInt("Digite o DIA do alvará: "),
                            Teclado.leInt("Digite o MÊS do alvará: "),
                            Teclado.leInt("Digite o ANO do alvará: ")
                    );
                    criarLoja = new Alimentacao(
                            Teclado.leString("Digite o nome da loja: "),
                            Teclado.leInt("Digite a quantidade de funcionários: "),
                            Teclado.leInt("Digite o salário base do funcionário: "),
                            enderecoLojas,
                            numeroDaLoja,
                            dataFundacao,
                            dataAlvara,
                            Teclado.leDouble("Digite o preço do almoço livre: ")
                    );
                    meuShopping.insereLoja(criarLoja);
                    break;
                case BIJUTERIA:
                    criarLoja = new Bijuteria(
                            Teclado.leString("Digite o nome da loja: "),
                            Teclado.leInt("Digite a quantidade de funcionários: "),
                            Teclado.leInt("Digite o salário base do funcionário: "),
                            enderecoLojas,
                            numeroDaLoja,
                            dataFundacao,
                            Teclado.leInt("Digite a meta de vendas: ")
                    );
                    meuShopping.insereLoja(criarLoja);
                    break;
                case COSMETICO:
                    criarLoja = new Cosmetico(
                            Teclado.leString("Digite o nome da loja: "),
                            Teclado.leInt("Digite a quantidade de funcionários: "),
                            Teclado.leInt("Digite o salário base do funcionário: "),
                            enderecoLojas,
                            numeroDaLoja,
                            dataFundacao,
                            Teclado.leDouble("Digite a taxa de comecialização: ")
                    );
                    meuShopping.insereLoja(criarLoja);
                    break;
                case INFORMATICA:
                    criarLoja = new Informatica(
                            Teclado.leString("Digite o nome da loja: "),
                            Teclado.leInt("Digite a quantidade de funcionários: "),
                            Teclado.leInt("Digite o salário base do funcionário: "),
                            enderecoLojas,
                            numeroDaLoja,
                            dataFundacao,
                            Teclado.leDouble("Digite o valor de seguro eletrônico: ")
                    );
                    meuShopping.insereLoja(criarLoja);
                    break;
                case VESTUARIO:
                    boolean vendeVestuarioImportado = Vestuario.perguntarSeVendeImportado();
                    criarLoja = new Vestuario(
                            Teclado.leString("Digite o nome da loja: "),
                            Teclado.leInt("Digite a quantidade de funcionários: "),
                            Teclado.leInt("Digite o salário base do funcionário: "),
                            enderecoLojas,
                            numeroDaLoja,
                            dataFundacao,
                            vendeVestuarioImportado
                    );
                    meuShopping.insereLoja(criarLoja);
                    break;
            }

            if (opcaoTipoDeLoja != 1 && opcaoTipoDeLoja != 2 && opcaoTipoDeLoja != 3 && opcaoTipoDeLoja != 4 && opcaoTipoDeLoja != 5) {
                System.out.println("\nOpção inválida, tente novamente\n");
                continue;
            }

            if (criarLoja != null) {
                System.out.println("\nLoja criada com sucesso:");
                System.out.println(criarLoja);
            }

            break;
        }
    }

    // Método para excluir loja
    public static void menuPrincipalExcluirLoja(Shopping meuShopping) {
        while (true) {
            String nomeLoja = Teclado.leString("Digite o nome da loja que deseja remover: ");
            boolean removida = meuShopping.removeLoja(nomeLoja);

            if (removida) {
                System.out.println("Loja removida com sucesso!");
            } else {
                System.out.println("Loja não encontrada.");
            }

            break;
        }
    }

    // Método para alterar a data de fundação da loja
    public static void alteraDataDeFundacaoDaLoja(Shopping meuShopping) {
        String nomeLoja = Teclado.leString("Digite o nome da loja que deseja editar: ");
        Loja lojaParaEditar = null;
        for (Loja loja : meuShopping.getLojas()) {
            if (loja != null && loja.getNome().equalsIgnoreCase(nomeLoja)) {
                lojaParaEditar = loja;
                break;
            }
        }
        if (lojaParaEditar != null) {
            int dia = Teclado.leInt("Digite o novo DIA de fundação: ");
            int mes = Teclado.leInt("Digite o novo MÊS de fundação: ");
            int ano = Teclado.leInt("Digite o novo ANO de fundação: ");
            lojaParaEditar.setDataFundacao(new Data(dia, mes, ano));
            System.out.println("Data de fundação alterada com sucesso!");
        } else {
            System.out.println("Loja não encontrada.");
        }
    }


    // Métodos para Gadgets de lojas
    private static void menuGadgetsLojas(Shopping meuShopping) {
        while (true) {
            System.out.println("\n(1) Quantidade de lojas por tipo \n(2) Loja de Informática com seguro mais caro \n(3) Loja de Cosméticos com maior taxa de comercialização \n(0) Voltar ao menu principal");
            int opcaoLoja = Teclado.leInt("Digite a opção desejada: ");

            switch(opcaoLoja) {
                case 1:
                    menuGadgetsLojasPorTipo(meuShopping);
                    break;
                case 2:
                    menuGadgetsLojaInformaticaSeguroMaisCaro(meuShopping);
                    break;
                case 3:
                    menuGadgetsLojaCosmeticoTaxaMaisAlta(meuShopping);
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu principal...\n");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void menuGadgetsLojasPorTipo(Shopping meuShopping) {
        while (true) {
            System.out.println("\nTipos de loja existentes no Shopping: \nAlimentação \nBijuteria \nCosmético \nInformática \nVestuário \n");
            String tipoLoja = Teclado.leString("Digite o tipo de loja desejado: ");
            if(meuShopping.quantidadeLojasPorTipo(tipoLoja) == 0) {
                System.out.println("Não há lojas do tipo '" + tipoLoja + "' no shopping.");
            }
            int contadorTiposLojas = meuShopping.quantidadeLojasPorTipo(tipoLoja);
            System.out.println("Total de lojas do tipo '" + tipoLoja + "': " + contadorTiposLojas);

            break;
        }
    }

    public static void menuGadgetsLojaInformaticaSeguroMaisCaro(Shopping meuShopping) {
        while (true) {
            if (meuShopping.quantidadeLojasPorTipo("Informática") == 0) {
                System.out.println("Não há lojas de Informática no shopping.");
            } else {
                Loja lojaSeguroMaisCaro = meuShopping.lojaSeguroMaisCaro();
                if (lojaSeguroMaisCaro != null) {
                    System.out.println("Loja de Informática com seguro mais caro: " + lojaSeguroMaisCaro.getNome() +
                            " com seguro de R$ " + ((Informatica) lojaSeguroMaisCaro).getSeguroEletronicos());
                } else {
                    System.out.println("Nenhuma loja de Informática encontrada.");
                }
            }

            break;
        }
    }

    public static void menuGadgetsLojaCosmeticoTaxaMaisAlta(Shopping meuShopping) {
        while (true) {
            if(meuShopping.quantidadeLojasPorTipo("Cosmético") == 0) {
                System.out.println("Não há lojas de Cosméticos no shopping.");
            } else {
                Loja lojaTaxaComercializacaoMaisAlta = meuShopping.lojaComTaxaComercializacaoMaisAlta();
                if (lojaTaxaComercializacaoMaisAlta != null) {
                    System.out.println("Loja de Cosméticos com maior taxa de comercialização: " + lojaTaxaComercializacaoMaisAlta.getNome() +
                            " com taxa de " + ((Cosmetico) lojaTaxaComercializacaoMaisAlta).getTaxaComercializacao() + "%");
                } else {
                    System.out.println("Nenhuma loja de Cosméticos encontrada.");
                }
            }

            break;
        }
    }
}