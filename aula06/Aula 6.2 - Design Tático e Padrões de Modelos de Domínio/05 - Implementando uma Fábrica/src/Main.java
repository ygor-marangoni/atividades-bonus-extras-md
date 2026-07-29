import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = PedidoFactory.criar("PX-92", List.of(
            new Item("Calabresa", new BigDecimal("42.00"), 1),
            new Item("Suco", new BigDecimal("8.00"), 2)
        ));
        System.out.println(pedido.numero() + " - R$ " + pedido.total());
    }
    record Item(String nome, BigDecimal preco, int quantidade) { }
    record Pedido(String numero, List<Item> itens) {
        BigDecimal total() { return itens.stream().map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade()))).reduce(BigDecimal.ZERO, BigDecimal::add); }
    }
    static class PedidoFactory {
        static Pedido criar(String numero, List<Item> itens) {
            if (numero.isBlank() || itens.isEmpty()) throw new IllegalArgumentException("Pedido inválido");
            return new Pedido(numero, List.copyOf(itens));
        }
    }
}
