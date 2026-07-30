import java.util.HashMap;
import java.util.Map;

/** Raiz do agregado. Livro nao e emprestado diretamente por objetos externos. */
public class Biblioteca {
    private final Map<Isbn, LivroInterno> livros = new HashMap<>();

    public void adicionarLivro(Isbn isbn, String titulo) {
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Titulo obrigatorio.");
        if (livros.putIfAbsent(isbn, new LivroInterno(titulo)) != null) {
            throw new IllegalArgumentException("Livro ja cadastrado.");
        }
    }
    public void emprestar(Isbn isbn) {
        LivroInterno livro = obter(isbn);
        if (livro.emprestado) throw new IllegalStateException("Livro indisponivel.");
        livro.emprestado = true;
    }
    public void devolver(Isbn isbn) { obter(isbn).emprestado = false; }
    public boolean estaDisponivel(Isbn isbn) { return !obter(isbn).emprestado; }
    private LivroInterno obter(Isbn isbn) {
        LivroInterno livro = livros.get(isbn);
        if (livro == null) throw new IllegalArgumentException("Livro nao encontrado.");
        return livro;
    }
    private static final class LivroInterno {
        private final String titulo;
        private boolean emprestado;
        private LivroInterno(String titulo) { this.titulo = titulo; }
    }
}
