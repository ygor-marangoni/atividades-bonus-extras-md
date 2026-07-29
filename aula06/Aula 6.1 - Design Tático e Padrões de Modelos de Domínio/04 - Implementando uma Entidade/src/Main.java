public class Main {
    public static void main(String[] args) {
        Chamado chamado = new Chamado("CH-001", "Inspecionar máquina 12");
        chamado.concluir();
        System.out.println(chamado.codigo() + " - " + chamado.status());
    }
}
