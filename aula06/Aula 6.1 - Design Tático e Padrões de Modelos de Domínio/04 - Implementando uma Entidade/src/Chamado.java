import java.util.UUID;

public class Chamado {
    private final UUID id;
    private String descricao;
    private Status status = Status.ABERTO;

    public Chamado(UUID id, String descricao) {
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("Descrição obrigatória.");
        this.id = id;
        this.descricao = descricao;
    }
    public void concluir() { if (status == Status.ABERTO) status = Status.CONCLUIDO; }
    public UUID id() { return id; }
    public Status status() { return status; }
    public enum Status { ABERTO, CONCLUIDO }
}
