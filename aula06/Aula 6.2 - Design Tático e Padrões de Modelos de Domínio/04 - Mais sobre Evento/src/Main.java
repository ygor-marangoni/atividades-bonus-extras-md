public class Main {

    public static void main(String[] args) {
        ProdutoEstoque produtoComEstoqueBaixo = new ProdutoEstoque(
            "PROD-001",
            3,
            10
        );

        ProdutoEstoque produtoComEstoqueOk = new ProdutoEstoque(
            "PROD-002",
            15,
            10
        );

        System.out.println("=== Verificacao de Estoque ===");
        verificarProduto(produtoComEstoqueBaixo);
        verificarProduto(produtoComEstoqueOk);
    }

    private static void verificarProduto(ProdutoEstoque produto) {
        EstoqueAbaixoDoMinimo evento = produto.verificarEstoque();

        if (evento != null) {
            System.out.println(evento);
        } else {
            System.out.println(
                "Produto " +
                produto.getProdutoId() +
                ": estoque dentro do minimo permitido."
            );
        }
    }
}

class ProdutoEstoque {

    private String produtoId;
    private int quantidadeAtual;
    private int quantidadeMinima;

    ProdutoEstoque(
        String produtoId,
        int quantidadeAtual,
        int quantidadeMinima
    ) {
        if (produtoId == null || produtoId.trim().isEmpty()) {
            throw new RuntimeException("ProdutoId obrigatorio.");
        }

        if (quantidadeAtual < 0) {
            throw new RuntimeException("Quantidade atual nao pode ser negativa.");
        }

        if (quantidadeMinima < 0) {
            throw new RuntimeException(
                "Quantidade minima nao pode ser negativa."
            );
        }

        this.produtoId = produtoId;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
    }

    EstoqueAbaixoDoMinimo verificarEstoque() {
        if (quantidadeAtual < quantidadeMinima) {
            return new EstoqueAbaixoDoMinimo(
                produtoId,
                quantidadeAtual,
                quantidadeMinima
            );
        }

        return null;
    }

    String getProdutoId() {
        return produtoId;
    }
}

class EstoqueAbaixoDoMinimo {

    private String produtoId;
    private int quantidadeAtual;
    private int quantidadeMinima;

    EstoqueAbaixoDoMinimo(
        String produtoId,
        int quantidadeAtual,
        int quantidadeMinima
    ) {
        this.produtoId = produtoId;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
    }

    public String toString() {
        return (
            "Evento EstoqueAbaixoDoMinimo disparado" +
            "\nProdutoId: " +
            produtoId +
            "\nQuantidade atual: " +
            quantidadeAtual +
            "\nQuantidade minima: " +
            quantidadeMinima
        );
    }
}
