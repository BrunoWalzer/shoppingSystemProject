package model;
import util.Teclado;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor com validação de data
    public Data(int dia, int mes, int ano) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida! Atribuindo data padrão 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    // Getters e Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Método toString
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    // Verifica se o ano é bissexto
    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método auxiliar para validar bissexto para um ano específico (sem alterar o atributo ano)
    private boolean verificaAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método auxiliar para verificar se uma data é válida
    private boolean dataValida(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) return false;
        if (dia < 1) return false;

        int[] diasNoMes = { 31, verificaAnoBissexto(ano) ? 29 : 28, 31, 30, 31, 30,
                            31, 31, 30, 31, 30, 31 };

        return dia <= diasNoMes[mes - 1];
    }

    public boolean maiorQue(Data dataOutra) {
        if (this.ano > dataOutra.ano) return true;
        if (this.ano == dataOutra.ano && this.mes > dataOutra.mes) return true;
        if (this.ano == dataOutra.ano && this.mes == dataOutra.mes && this.dia > dataOutra.dia) return true;
        return false;
    }
}
