import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Chamado chamado = new Chamado(UUID.fromString("198a51a6-bd44-4df9-8c17-0f5fad0b4cc1"), "Inspecionar máquina 12");
        chamado.concluir();
        System.out.println(chamado.id() + " - " + chamado.status());
    }
}
