import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReservaRepositorio repositorio = new ReservaRepositorioMemoria();
        repositorio.salvar(new Reserva("R-17", "CONFIRMADA"));
        System.out.println(repositorio.porCodigo("R-17").status);
    }
    static class Reserva { String codigo, status; Reserva(String c, String s) { codigo=c; status=s; } }
    interface ReservaRepositorio { void salvar(Reserva reserva); Reserva porCodigo(String codigo); }
    static class ReservaRepositorioMemoria implements ReservaRepositorio {
        private final Map<String, Reserva> dados = new HashMap<>();
        public void salvar(Reserva reserva) { dados.put(reserva.codigo, reserva); }
        public Reserva porCodigo(String codigo) { return dados.get(codigo); }
    }
}
