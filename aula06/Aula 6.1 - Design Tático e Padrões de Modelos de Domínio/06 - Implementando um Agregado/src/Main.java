import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Voo voo = new Voo(1);
        Reserva reserva = new Reserva(new Passageiro(UUID.randomUUID(), "Ana Silva"), voo);
        reserva.confirmar();
        System.out.println("Reserva confirmada: " + reserva.confirmada());
    }
}
