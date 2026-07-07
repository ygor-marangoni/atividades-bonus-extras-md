import java.time.LocalDate;

class Main {

    public static void main(String[] args) {
        Livro livro = new Livro("Java para Iniciantes", true);
        Usuario usuario = new Usuario("Ygor", "aluno", true);

        ServicoEmprestimo servico = new ServicoEmprestimo();

        try {
            Emprestimo emprestimo = servico.emprestarLivro(livro, usuario);
            System.out.println("Empréstimo realizado com sucesso!");
            System.out.println(emprestimo);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

class Livro {

    String titulo;
    boolean disponivel;

    Livro(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
    }
}

class Usuario {

    String nome;
    String tipo;
    boolean regular;

    Usuario(String nome, String tipo, boolean regular) {
        this.nome = nome;
        this.tipo = tipo;
        this.regular = regular;
    }
}

class Emprestimo {

    Livro livro;
    Usuario usuario;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;

    Emprestimo(
        Livro livro,
        Usuario usuario,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
    ) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public String toString() {
        return (
            "Livro: " +
            livro.titulo +
            "\nUsuário: " +
            usuario.nome +
            "\nData do empréstimo: " +
            dataEmprestimo +
            "\nData de devolução: " +
            dataDevolucao
        );
    }
}

class ServicoEmprestimo {

    Emprestimo emprestarLivro(Livro livro, Usuario usuario) {
        if (!livro.disponivel) {
            throw new RuntimeException("Livro indisponível para empréstimo.");
        }

        if (!usuario.regular) {
            throw new RuntimeException(
                "Usuário irregular. Empréstimo não permitido."
            );
        }

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao;

        if (usuario.tipo.equalsIgnoreCase("professor")) {
            dataDevolucao = dataEmprestimo.plusDays(15);
        } else {
            dataDevolucao = dataEmprestimo.plusDays(7);
        }

        livro.disponivel = false;

        return new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
    }
}
