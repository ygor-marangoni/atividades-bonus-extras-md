public class Chamado {
    private final String codigo;
    private String descricao;
    private Status status = Status.ABERTO;

    public Chamado(String codigo, String descricao) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("Código obrigatório.");
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("Descrição obrigatória.");
        this.codigo = codigo;
        this.descricao = descricao;
    }
    public void concluir() { if (status == Status.ABERTO) status = Status.CONCLUIDO; }
    public String codigo() { return codigo; }
    public Status status() { return status; }
    public enum Status { ABERTO, CONCLUIDO }
}
