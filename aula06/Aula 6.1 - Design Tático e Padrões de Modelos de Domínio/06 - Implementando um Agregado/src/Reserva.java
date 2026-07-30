import java.util.UUID;

/** Raiz do agregado de reserva de passagens. */
public class Reserva {
    private final UUID id = UUID.randomUUID();
    private final Passageiro passageiro;
    private final Voo voo;
    private boolean confirmada;

    public Reserva(Passageiro passageiro, Voo voo) {
        if (passageiro == null || voo == null) throw new IllegalArgumentException("Passageiro e voo obrigatorios.");
        this.passageiro = passageiro;
        this.voo = voo;
    }
    public void confirmar() {
        if (confirmada) throw new IllegalStateException("Reserva ja confirmada.");
        if (voo.estaLotado()) throw new IllegalStateException("Nao e possivel confirmar: voo lotado.");
        voo.ocuparAssento();
        confirmada = true;
    }
    public boolean confirmada() { return confirmada; }
    public UUID id() { return id; }
    public Passageiro passageiro() { return passageiro; }
}
