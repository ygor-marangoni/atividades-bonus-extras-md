import java.util.UUID;

public class ReservaHotel {
    private final UUID id = UUID.randomUUID();
    private boolean checkInRealizado;
    private boolean cancelada;

    public UUID id() { return id; }
    public void realizarCheckIn() {
        if (cancelada) throw new IllegalStateException("Reserva cancelada nao pode receber check-in.");
        checkInRealizado = true;
    }
    public void cancelar() {
        if (checkInRealizado) throw new IllegalStateException("Nao e possivel cancelar apos o check-in.");
        cancelada = true;
    }
    public boolean cancelada() { return cancelada; }
}
