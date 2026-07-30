public class Main {
    public static void main(String[] args) {
        ReservaHotel reserva = new ReservaHotel();
        reserva.cancelar();
        System.out.println("Reserva " + reserva.id() + " cancelada: " + reserva.cancelada());
    }
}
