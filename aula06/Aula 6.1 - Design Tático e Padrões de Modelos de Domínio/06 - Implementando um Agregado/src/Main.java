import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("PX-42");
        pedido.adicionarItem("Pizza vegetariana", new BigDecimal("48.00"), 2);
        System.out.println("Total: R$ " + pedido.total());
    }
}
