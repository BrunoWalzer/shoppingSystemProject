package model;

public enum TipoDeLoja {
    ALIMENTACAO(1),
    BIJUTERIA(2),
    COSMETICO(3),
    INFORMATICA(4),
    VESTUARIO(5);

    private int codigo;

    TipoDeLoja(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    // Método para obter o enum a partir do código
    public static TipoDeLoja fromCodigo(int codigo) {
        for (TipoDeLoja tipo : TipoDeLoja.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        return null;
    }
}