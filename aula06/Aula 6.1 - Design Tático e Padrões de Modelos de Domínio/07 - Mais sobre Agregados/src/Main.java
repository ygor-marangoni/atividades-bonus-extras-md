import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(new BigDecimal("100.00"));
        conta.sacar(new BigDecimal("35.00"));
        System.out.println("Saldo: " + conta.saldo());

        Biblioteca biblioteca = new Biblioteca();
        Isbn isbn = new Isbn("9788535902775");
        biblioteca.adicionarLivro(isbn, "Domain-Driven Design");
        biblioteca.emprestar(isbn);
        System.out.println("Livro disponivel: " + biblioteca.estaDisponivel(isbn));
    }
}
