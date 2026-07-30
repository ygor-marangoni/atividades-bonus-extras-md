public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("978-85-359-0277-5", "Eric Evans", "Domain-Driven Design", "Alta Books", 2016);
        livro.alterarTitulo("Domain-Driven Design: Atacando a Complexidade");
        System.out.println("ISBN: " + livro.isbn());
        System.out.println(livro.citacaoAbnt());
    }
}
