import java.util.UUID;

public class Voo {
    private final UUID id = UUID.randomUUID();
    private final int capacidade;
    private int assentosConfirmados;

    public Voo(int capacidade) {
        if (capacidade <= 0) throw new IllegalArgumentException("Capacidade deve ser positiva.");
        this.capacidade = capacidade;
    }
    public boolean estaLotado() { return assentosConfirmados >= capacidade; }
    void ocuparAssento() {
        if (estaLotado()) throw new IllegalStateException("Voo lotado.");
        assentosConfirmados++;
    }
    public UUID id() { return id; }
}
