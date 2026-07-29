import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ConversorMoeda conversor = new ConversorMoeda();

        double valorEmEuro = conversor.converter(100.0, "USD", "EUR");
        double valorEmReal = conversor.converter(50.0, "EUR", "BRL");

        System.out.println("=== Conversor de Moeda ===");
        System.out.printf("100.00 USD em EUR: %.2f%n", valorEmEuro);
        System.out.printf("50.00 EUR em BRL: %.2f%n", valorEmReal);

        AnaliseCredito analiseCredito = new AnaliseCredito();

        Cliente clienteAprovado = new Cliente("Ana", 12, 800.0, 5000.0);
        Cliente clienteReprovado = new Cliente("Bruno", 2, 3500.0, 4000.0);

        ResultadoCredito resultadoAna = analiseCredito.avaliar(
            clienteAprovado,
            10000.0
        );
        ResultadoCredito resultadoBruno = analiseCredito.avaliar(
            clienteReprovado,
            20000.0
        );

        System.out.println();
        System.out.println("=== Analise de Credito ===");
        System.out.println(resultadoAna);
        System.out.println(resultadoBruno);
    }
}

class ConversorMoeda {

    private Map<String, Double> taxasEmReal;

    ConversorMoeda() {
        taxasEmReal = new HashMap<String, Double>();
        taxasEmReal.put("BRL", 1.00);
        taxasEmReal.put("USD", 5.50);
        taxasEmReal.put("EUR", 6.20);
        taxasEmReal.put("GBP", 7.30);
    }

    double converter(double valor, String moedaOrigem, String moedaDestino) {
        if (valor <= 0) {
            throw new RuntimeException("O valor deve ser maior que zero.");
        }

        if (!taxasEmReal.containsKey(moedaOrigem)) {
            throw new RuntimeException("Moeda de origem nao cadastrada.");
        }

        if (!taxasEmReal.containsKey(moedaDestino)) {
            throw new RuntimeException("Moeda de destino nao cadastrada.");
        }

        double valorEmReais = valor * taxasEmReal.get(moedaOrigem);
        return valorEmReais / taxasEmReal.get(moedaDestino);
    }
}

class AnaliseCredito {

    ResultadoCredito avaliar(Cliente cliente, double valorEmprestimo) {
        if (cliente == null) {
            throw new RuntimeException("Cliente nao informado.");
        }

        if (cliente.salario <= 0) {
            throw new RuntimeException("Salario deve ser maior que zero.");
        }

        if (valorEmprestimo <= 0) {
            throw new RuntimeException(
                "Valor do emprestimo deve ser maior que zero."
            );
        }

        double parcelaEstimada = valorEmprestimo / 12;
        double comprometimentoAtual = cliente.dividasAtivas / cliente.salario;
        double comprometimentoComEmprestimo =
            (cliente.dividasAtivas + parcelaEstimada) / cliente.salario;

        boolean bomHistorico = cliente.historicoCompras >= 5;
        boolean dividasControladas = comprometimentoAtual <= 0.40;
        boolean parcelaPermitida = comprometimentoComEmprestimo <= 0.60;
        boolean valorCompativel = valorEmprestimo <= cliente.salario * 10;

        boolean aprovado =
            bomHistorico &&
            dividasControladas &&
            parcelaPermitida &&
            valorCompativel;

        String motivo;

        if (aprovado) {
            motivo = "Credito aprovado.";
        } else if (!bomHistorico) {
            motivo = "Credito negado: historico de compras insuficiente.";
        } else if (!dividasControladas) {
            motivo = "Credito negado: dividas ativas muito altas.";
        } else if (!parcelaPermitida) {
            motivo = "Credito negado: parcela compromete muito o salario.";
        } else {
            motivo = "Credito negado: valor solicitado muito alto.";
        }

        return new ResultadoCredito(
            cliente.nome,
            valorEmprestimo,
            parcelaEstimada,
            aprovado,
            motivo
        );
    }
}

class Cliente {

    String nome;
    int historicoCompras;
    double dividasAtivas;
    double salario;

    Cliente(
        String nome,
        int historicoCompras,
        double dividasAtivas,
        double salario
    ) {
        this.nome = nome;
        this.historicoCompras = historicoCompras;
        this.dividasAtivas = dividasAtivas;
        this.salario = salario;
    }
}

class ResultadoCredito {

    String nomeCliente;
    double valorEmprestimo;
    double parcelaEstimada;
    boolean aprovado;
    String motivo;

    ResultadoCredito(
        String nomeCliente,
        double valorEmprestimo,
        double parcelaEstimada,
        boolean aprovado,
        String motivo
    ) {
        this.nomeCliente = nomeCliente;
        this.valorEmprestimo = valorEmprestimo;
        this.parcelaEstimada = parcelaEstimada;
        this.aprovado = aprovado;
        this.motivo = motivo;
    }

    public String toString() {
        String status = aprovado ? "APROVADO" : "NEGADO";

        return String.format(
            "%s - %s | Emprestimo: R$ %.2f | Parcela estimada: R$ %.2f | %s",
            nomeCliente,
            status,
            valorEmprestimo,
            parcelaEstimada,
            motivo
        );
    }
}
