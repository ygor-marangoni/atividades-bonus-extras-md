import java.math.BigDecimal;

/** Raiz do agregado bancario: somente ela altera o saldo. */
public class ContaBancaria {
    private BigDecimal saldo = BigDecimal.ZERO;

    public void depositar(BigDecimal valor) {
        validarValorPositivo(valor);
        saldo = saldo.add(valor);
    }
    public void sacar(BigDecimal valor) {
        validarValorPositivo(valor);
        if (saldo.compareTo(valor) < 0) throw new IllegalStateException("Saldo insuficiente.");
        saldo = saldo.subtract(valor);
    }
    public BigDecimal saldo() { return saldo; }
    private static void validarValorPositivo(BigDecimal valor) {
        if (valor == null || valor.signum() <= 0) throw new IllegalArgumentException("Valor deve ser positivo.");
    }
}
