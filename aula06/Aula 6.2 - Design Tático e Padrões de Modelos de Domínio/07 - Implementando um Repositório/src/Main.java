import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoRepositorio repositorio = new ProdutoRepositorioMemoria(List.of(new Produto("Filtro", new BigDecimal("75.00")), new Produto("Correia", new BigDecimal("180.00"))));
        System.out.println(repositorio.buscarEntre(new BigDecimal("100"), new BigDecimal("200")));
    }
    record Produto(String nome, BigDecimal preco) { }
    interface ProdutoRepositorio { List<Produto> buscarEntre(BigDecimal minimo, BigDecimal maximo); }
    record ProdutoRepositorioMemoria(List<Produto> produtos) implements ProdutoRepositorio {
        public List<Produto> buscarEntre(BigDecimal minimo, BigDecimal maximo) { return produtos.stream().filter(p -> p.preco().compareTo(minimo) >= 0 && p.preco().compareTo(maximo) <= 0).toList(); }
    }
}
