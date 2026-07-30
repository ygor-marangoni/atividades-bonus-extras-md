import java.util.UUID;

public record Passageiro(UUID id, String nome) {
    public Passageiro {
        if (id == null || nome == null || nome.isBlank()) throw new IllegalArgumentException("Passageiro invalido.");
    }
}
