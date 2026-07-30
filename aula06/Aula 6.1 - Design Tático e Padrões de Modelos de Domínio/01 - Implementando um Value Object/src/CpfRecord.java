/** A mesma regra de CPF usando record. O componente ja e final por definicao. */
public record CpfRecord(String valor) {
    public CpfRecord {
        if (valor == null) throw new IllegalArgumentException("CPF obrigatorio.");
        valor = valor.replaceAll("\\D", "");
        if (valor.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter exatamente 11 digitos.");
        }
    }
}
