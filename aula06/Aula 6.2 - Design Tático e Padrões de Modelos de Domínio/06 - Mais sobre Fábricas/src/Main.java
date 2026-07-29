import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Nota nota = NotaFactory.emitir("Merco", new BigDecimal("125.00"));
        System.out.println(nota.cliente + " - total R$ " + nota.total);
    }
    static class Nota { String cliente; BigDecimal total; Nota(String c, BigDecimal t) { cliente=c; total=t; } }
    static class NotaFactory { static Nota emitir(String cliente, BigDecimal subtotal) { return new Nota(cliente, subtotal.multiply(new BigDecimal("1.08"))); } }
}
