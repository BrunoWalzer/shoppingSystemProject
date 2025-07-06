package view;

import model.*;
import util.Teclado;

public class Principal {
    public static void main(String[] args) {
        Loja criarLoja = null;

        System.out.println("\nPara a criação de um novo Shopping: " + "\n");
        System.out.println("=-=-=-=-=- Dados do Shopping -=-=-=-=-=");
        // Comentado a solicitação de dados do usuário para o endereço do shopping para testes mais eficientes e práticos!
        /*Endereco enderecoShopping = new Endereco(
                    Teclado.leString("Digite a rua: "),
                    Teclado.leString("Digite a cidade: "),
                    Teclado.leString("Digite o estado: "),
                    Teclado.leString("Digite o país: "),
                    Teclado.leString("Digite o cep: "),
                    Teclado.leString("Digite o número: "),
                    Teclado.leString("Digite o complemento: ")
                );
         */
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
        Shopping meuShopping = new Shopping(
            "Shopping Teste",
            enderecoShopping,
            quantLojas
        );

        while(true) {
            System.out.println("\n(1) Criar uma Loja \n(2) Remover uma loja  \n(3) Lista de lojas do Shopping \n(4) Procurar loja existente \n(5) Quantidade dos tipos de lojas \n(6) Loja de informática com seguro mais caro \n(7) Loja de cosméticos com maior taxa de comercialização \n(8)  \n(9) Sair");
            int opcao = Teclado.leInt("Digite a opção desejada: ");

            if(opcao == 1) {
                System.out.println("\nEscolha o tipo da loja:");
                System.out.println("(1) Alimentação \n(2) Bijuteria \n(3) Cosmético \n(4) Informática \n(5) Vestuário");
                int opcaoTipoDeLoja = Teclado.leInt("Digite a opção: ");

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

                Endereco enderecoLojas = enderecoShopping;

                switch(opcaoTipoDeLoja) {
                    case 1:
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
                                dataAlvara
                            );
                            meuShopping.insereLoja(criarLoja);
                            break;
                    case 2:
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
                    case 3:
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
                    case 4:
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
                    case 5:
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

            if(opcaoTipoDeLoja != 1 && opcaoTipoDeLoja != 2 && opcaoTipoDeLoja != 3 && opcaoTipoDeLoja != 4 && opcaoTipoDeLoja != 5) {
                System.out.println("\nOpção inválida, tente novamente\n");
                continue;
            }

            if(criarLoja != null){
                System.out.println("\nLoja criada com sucesso:");
                System.out.println(criarLoja);
            }

            } else if(opcao == 2) {
                String nomeLoja = Teclado.leString("Digite o nome da loja que deseja remover: ");
                boolean removida = meuShopping.removeLoja(nomeLoja);

                if (removida) {
                    System.out.println("Loja removida com sucesso!");
                } else {
                    System.out.println("Loja não encontrada.");
                }

            } else if (opcao == 3) {
                System.out.println("\nLojas no shopping:");
                meuShopping.imprimeLojas();

            } else if (opcao == 4) {
                meuShopping.procuraLojaPorNome(Teclado.leString("\nDigite o nome da loja que deseja procurar: "));

            } else if (opcao == 5) {
                System.out.println("\nTipos de loja existentes: \nAlimentação \nBijuteria \nCosmético \nInformática \nVestuário \n");
                String tipoLoja = Teclado.leString("Digite o tipo de loja desejado: ");
                if(meuShopping.quantidadeLojasPorTipo(tipoLoja) == 0) {
                    System.out.println("Não há lojas do tipo '" + tipoLoja + "' no shopping.");
                }
                int contadorTiposLojas = meuShopping.quantidadeLojasPorTipo(tipoLoja);
                System.out.println("Total de lojas do tipo '" + tipoLoja + "': " + contadorTiposLojas);

            } else if (opcao == 6) {
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

            } else if (opcao == 7) {
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

            } else if(opcao == 9) {
                break;

            } else {
                System.out.println("\\n" + //
                                    "Opção inválida, tente novamente\\n" + //
                                    "");
            }
        }
    }
}