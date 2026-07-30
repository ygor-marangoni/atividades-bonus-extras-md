import java.util.Objects;

/** Value Object imutavel usando uma classe Java tradicional. */
public final class Cpf {
    private final String digitos;

    public Cpf(String valor) {
        this.digitos = normalizarEValidar(valor);
    }

    public String valor() {
        return digitos;
    }

    private static String normalizarEValidar(String valor) {
        if (valor == null) throw new IllegalArgumentException("CPF obrigatorio.");
        String somenteDigitos = valor.replaceAll("\\D", "");
        if (somenteDigitos.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter exatamente 11 digitos.");
        }
        return somenteDigitos;
    }

    @Override public boolean equals(Object outro) {
        return outro instanceof Cpf cpf && digitos.equals(cpf.digitos);
    }
    @Override public int hashCode() { return Objects.hash(digitos); }
    @Override public String toString() { return digitos; }
}
