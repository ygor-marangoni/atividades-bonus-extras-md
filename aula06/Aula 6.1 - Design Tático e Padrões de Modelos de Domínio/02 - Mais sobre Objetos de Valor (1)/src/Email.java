import java.util.Locale;

public record Email(String valor) {
    private static final String FORMATO = "[A-Za-z0-9._]+@[A-Za-z0-9._]+";

    public Email {
        if (valor == null || !valor.matches(FORMATO)) {
            throw new IllegalArgumentException("E-mail deve seguir usuario@dominio.");
        }
        valor = valor.toLowerCase(Locale.ROOT);
    }
}
