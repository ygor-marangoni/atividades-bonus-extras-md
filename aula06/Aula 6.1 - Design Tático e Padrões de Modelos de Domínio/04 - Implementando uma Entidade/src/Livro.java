import java.util.Objects;

/** Entidade: a identidade e o ISBN, mesmo que os demais dados mudem. */
public class Livro {
    private final String isbn;
    private final String autor;
    private String titulo;
    private String editora;
    private int ano;

    public Livro(String isbn, String autor, String titulo, String editora, int ano) {
        this.isbn = validarIsbn(isbn);
        this.autor = obrigatorio(autor, "Autor");
        this.titulo = obrigatorio(titulo, "Titulo");
        this.editora = obrigatorio(editora, "Editora");
        if (ano <= 0) throw new IllegalArgumentException("Ano invalido.");
        this.ano = ano;
    }

    public void alterarTitulo(String novoTitulo) { this.titulo = obrigatorio(novoTitulo, "Titulo"); }
    public String isbn() { return isbn; }
    public String citacaoAbnt() {
        String[] partes = autor.trim().split("\\s+", 2);
        String sobrenome = partes[partes.length - 1].toUpperCase();
        String nomes = partes.length == 2 ? partes[0] : "";
        return sobrenome + ", " + nomes + ". " + titulo + ". " + editora + ", " + ano + ".";
    }

    private static String validarIsbn(String valor) {
        if (valor == null) throw new IllegalArgumentException("ISBN obrigatorio.");
        String digitos = valor.replaceAll("[-\\s]", "");
        if (!digitos.matches("\\d{13}")) throw new IllegalArgumentException("ISBN-13 deve ter 13 digitos.");
        int soma = 0;
        for (int i = 0; i < 12; i++) soma += Character.digit(digitos.charAt(i), 10) * (i % 2 == 0 ? 1 : 3);
        int verificador = (10 - soma % 10) % 10;
        if (verificador != Character.digit(digitos.charAt(12), 10)) throw new IllegalArgumentException("ISBN invalido.");
        return digitos;
    }
    private static String obrigatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + " obrigatorio.");
        return valor.trim();
    }
    @Override public boolean equals(Object outro) { return outro instanceof Livro livro && isbn.equals(livro.isbn); }
    @Override public int hashCode() { return Objects.hash(isbn); }
}
