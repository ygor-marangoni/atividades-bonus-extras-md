import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final String numero;
    private final List<ItemPedido> itens = new ArrayList<>();
    public Pedido(String numero) { this.numero = numero; }
    public void adicionarItem(String produto, BigDecimal preco, int quantidade) {
        if (quantidade <= 0 || preco.signum() < 0) throw new IllegalArgumentException("Item inválido.");
        itens.add(new ItemPedido(produto, preco, quantidade));
    }
    public BigDecimal total() { return itens.stream().map(ItemPedido::subtotal).reduce(BigDecimal.ZERO, BigDecimal::add); }
    private record ItemPedido(String produto, BigDecimal preco, int quantidade) {
        BigDecimal subtotal() { return preco.multiply(BigDecimal.valueOf(quantidade)); }
    }
}
