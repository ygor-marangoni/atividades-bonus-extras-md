import java.time.LocalDate;
import java.util.Objects;

public final class PeriodoReserva {
    private final LocalDate entrada;
    private final LocalDate saida;

    public PeriodoReserva(LocalDate entrada, LocalDate saida) {
        if (entrada == null || saida == null || !saida.isAfter(entrada)) {
            throw new IllegalArgumentException("A saída deve ser posterior à entrada.");
        }
        this.entrada = entrada;
        this.saida = saida;
    }

    public boolean conflitaCom(PeriodoReserva outro) {
        return entrada.isBefore(outro.saida) && outro.entrada.isBefore(saida);
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof PeriodoReserva outro && entrada.equals(outro.entrada) && saida.equals(outro.saida);
    }
    @Override public int hashCode() { return Objects.hash(entrada, saida); }
    @Override public String toString() { return entrada + " a " + saida; }
}
