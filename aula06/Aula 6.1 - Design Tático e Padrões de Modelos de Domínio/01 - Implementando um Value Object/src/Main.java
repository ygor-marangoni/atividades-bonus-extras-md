import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PeriodoReserva feriado = new PeriodoReserva(LocalDate.of(2026, 9, 4), LocalDate.of(2026, 9, 7));
        PeriodoReserva visita = new PeriodoReserva(LocalDate.of(2026, 9, 6), LocalDate.of(2026, 9, 9));
        System.out.println("Conflito: " + feriado.conflitaCom(visita));
    }
}
