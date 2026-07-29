import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Marina", new BigDecimal("3200.00"));
        FolhaPagamento folha = FolhaPagamentoFactory.gerar(funcionario, 172);

        System.out.println("Funcionário: " + folha.funcionario.nome);
        System.out.println("Horas extras: " + folha.horasExtras);
        System.out.println("Salário bruto: R$ " + folha.salarioBruto);
        System.out.println("Imposto: R$ " + folha.imposto);
        System.out.println("Salário líquido: R$ " + folha.salarioLiquido);
    }

    static class Funcionario {
        final String nome;
        final BigDecimal salarioBase;

        Funcionario(String nome, BigDecimal salarioBase) {
            if (nome == null || nome.trim().isEmpty() || salarioBase.signum() <= 0) {
                throw new IllegalArgumentException("Dados do funcionário inválidos.");
            }
            this.nome = nome;
            this.salarioBase = salarioBase;
        }
    }

    static class FolhaPagamento {
        final Funcionario funcionario;
        final int horasExtras;
        final BigDecimal salarioBruto;
        final BigDecimal imposto;
        final BigDecimal salarioLiquido;

        FolhaPagamento(Funcionario funcionario, int horasExtras, BigDecimal salarioBruto,
                       BigDecimal imposto, BigDecimal salarioLiquido) {
            this.funcionario = funcionario;
            this.horasExtras = horasExtras;
            this.salarioBruto = salarioBruto;
            this.imposto = imposto;
            this.salarioLiquido = salarioLiquido;
        }
    }

    static class FolhaPagamentoFactory {
        private static final int CARGA_MENSAL = 160;
        private static final BigDecimal ADICIONAL_HORA_EXTRA = new BigDecimal("1.50");
        private static final BigDecimal ALIQUOTA_IMPOSTO = new BigDecimal("0.10");

        static FolhaPagamento gerar(Funcionario funcionario, int horasTrabalhadas) {
            if (horasTrabalhadas < 0) {
                throw new IllegalArgumentException("Horas trabalhadas inválidas.");
            }
            int horasExtras = Math.max(0, horasTrabalhadas - CARGA_MENSAL);
            BigDecimal valorHora = funcionario.salarioBase.divide(
                BigDecimal.valueOf(CARGA_MENSAL), 2, RoundingMode.HALF_UP
            );
            BigDecimal adicional = valorHora.multiply(ADICIONAL_HORA_EXTRA)
                .multiply(BigDecimal.valueOf(horasExtras));
            BigDecimal bruto = funcionario.salarioBase.add(adicional);
            BigDecimal imposto = bruto.multiply(ALIQUOTA_IMPOSTO);
            return new FolhaPagamento(funcionario, horasExtras, bruto, imposto, bruto.subtract(imposto));
        }
    }
}
