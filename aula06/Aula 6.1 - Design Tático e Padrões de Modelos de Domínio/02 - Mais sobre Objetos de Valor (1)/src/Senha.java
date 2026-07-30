import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Senha {
    private final String hash;

    public Senha(String textoPuro) {
        if (textoPuro == null || textoPuro.length() < 8) {
            throw new IllegalArgumentException("Senha deve ter no minimo 8 caracteres.");
        }
        this.hash = sha256(textoPuro);
    }

    public boolean confere(String tentativa) { return hash.equals(sha256(tentativa)); }
    public String hash() { return hash; }

    private static String sha256(String texto) {
        try {
            byte[] bytes = MessageDigest.getInstance("SHA-256").digest(texto.getBytes(StandardCharsets.UTF_8));
            StringBuilder resultado = new StringBuilder();
            for (byte b : bytes) resultado.append(String.format("%02x", b));
            return resultado.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 indisponivel.", e);
        }
    }
}
