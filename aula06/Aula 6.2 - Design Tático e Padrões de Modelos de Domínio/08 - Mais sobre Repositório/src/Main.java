import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String arquivo = "produtos.dat";
        ProdutoRepositorioArquivo repositorio = new ProdutoRepositorioArquivo(arquivo);
        repositorio.salvar(List.of(
            new Produto(1L, "Teclado", new BigDecimal("120.00")),
            new Produto(2L, "Mouse", new BigDecimal("80.00")),
            new Produto(3L, "Headset", new BigDecimal("250.00"))
        ));

        for (Produto produto : repositorio.buscarPorFaixaDePreco(
            new BigDecimal("100.00"), new BigDecimal("300.00")
        )) {
            System.out.println(produto.nome + " - R$ " + produto.preco);
        }
    }

    static class Produto implements Serializable {
        private static final long serialVersionUID = 1L;
        final Long id;
        final String nome;
        final BigDecimal preco;

        Produto(Long id, String nome, BigDecimal preco) {
            if (id == null || nome == null || nome.trim().isEmpty() || preco == null || preco.signum() < 0) {
                throw new IllegalArgumentException("Produto inválido.");
            }
            this.id = id;
            this.nome = nome;
            this.preco = preco;
        }
    }

    interface ProdutoRepositorio {
        List<Produto> buscarPorFaixaDePreco(BigDecimal minimo, BigDecimal maximo);
    }

    static class ProdutoRepositorioArquivo implements ProdutoRepositorio {
        private final String arquivo;

        ProdutoRepositorioArquivo(String arquivo) {
            this.arquivo = arquivo;
        }

        void salvar(List<Produto> produtos) {
            try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arquivo))) {
                saida.writeObject(produtos);
            } catch (Exception e) {
                throw new IllegalStateException("Não foi possível salvar os produtos.", e);
            }
        }

        public List<Produto> buscarPorFaixaDePreco(BigDecimal minimo, BigDecimal maximo) {
            if (minimo == null || maximo == null || minimo.compareTo(maximo) > 0) {
                throw new IllegalArgumentException("Faixa de preço inválida.");
            }
            List<Produto> resultado = new ArrayList<Produto>();
            for (Produto produto : carregar()) {
                if (produto.preco.compareTo(minimo) >= 0 && produto.preco.compareTo(maximo) <= 0) {
                    resultado.add(produto);
                }
            }
            return resultado;
        }

        @SuppressWarnings("unchecked")
        private List<Produto> carregar() {
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arquivo))) {
                return (List<Produto>) entrada.readObject();
            } catch (Exception e) {
                return new ArrayList<Produto>();
            }
        }
    }
}
