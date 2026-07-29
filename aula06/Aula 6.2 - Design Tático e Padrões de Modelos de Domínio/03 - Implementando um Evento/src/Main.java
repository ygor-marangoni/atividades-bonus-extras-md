import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        Reserva reserva = new Reserva(
            "RES-001",
            "Ygor",
            LocalDate.of(2026, 7, 10),
            LocalDate.of(2026, 7, 15),
            280.00
        );

        ReservaConfirmada evento = reserva.gerarConfirmacao();

        System.out.println("=== Evento de Reserva Confirmada ===");
        System.out.println(evento);
    }
}

class Reserva {

    private String idReserva;
    private String nomeCliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorDiaria;
    private boolean confirmada;

    Reserva(
        String idReserva,
        String nomeCliente,
        LocalDate dataEntrada,
        LocalDate dataSaida,
        double valorDiaria
    ) {
        if (idReserva == null || idReserva.trim().isEmpty()) {
            throw new RuntimeException("Identificacao da reserva obrigatoria.");
        }

        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new RuntimeException("Nome do cliente obrigatorio.");
        }

        if (dataEntrada == null || dataSaida == null) {
            throw new RuntimeException("Datas da reserva sao obrigatorias.");
        }

        if (!dataSaida.isAfter(dataEntrada)) {
            throw new RuntimeException(
                "Data de saida deve ser posterior a data de entrada."
            );
        }

        if (valorDiaria <= 0) {
            throw new RuntimeException("Valor da diaria deve ser maior que zero.");
        }

        this.idReserva = idReserva;
        this.nomeCliente = nomeCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorDiaria = valorDiaria;
        this.confirmada = false;
    }

    ReservaConfirmada gerarConfirmacao() {
        if (confirmada) {
            throw new RuntimeException("Reserva ja confirmada.");
        }

        confirmada = true;

        return new ReservaConfirmada(
            idReserva,
            nomeCliente,
            dataEntrada,
            dataSaida,
            calcularCustoTotal()
        );
    }

    private double calcularCustoTotal() {
        long quantidadeDiarias = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        return quantidadeDiarias * valorDiaria;
    }
}

class ReservaConfirmada {

    private String idReserva;
    private String nomeCliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double custoTotal;

    ReservaConfirmada(
        String idReserva,
        String nomeCliente,
        LocalDate dataEntrada,
        LocalDate dataSaida,
        double custoTotal
    ) {
        this.idReserva = idReserva;
        this.nomeCliente = nomeCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.custoTotal = custoTotal;
    }

    public String toString() {
        return String.format(
            "Reserva: %s%nCliente: %s%nEntrada: %s%nSaida: %s%nCusto total: R$ %.2f",
            idReserva,
            nomeCliente,
            dataEntrada,
            dataSaida,
            custoTotal
        );
    }
}
