public record Isbn(String valor) {
    public Isbn {
        if (valor == null) throw new IllegalArgumentException("ISBN obrigatorio.");
        valor = valor.replaceAll("[-\\s]", "");
        if (!valor.matches("\\d{13}")) throw new IllegalArgumentException("ISBN deve ter 13 digitos.");
    }
}
