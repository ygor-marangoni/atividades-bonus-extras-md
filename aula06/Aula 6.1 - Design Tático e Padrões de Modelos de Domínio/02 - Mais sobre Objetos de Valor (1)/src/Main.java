public class Main {
    public static void main(String[] args) {
        CoordenadaGps uberlandia = new CoordenadaGps(-18.9186, 48.2772);
        CoordenadaGps brasilia = new CoordenadaGps(-15.7939, 47.8828);
        Senha senha = new Senha("senha-segura");
        Email email = new Email("Aluno.Exemplo_1@Universidade.br");

        System.out.printf("Distancia: %.1f km%n", uberlandia.distanceTo(brasilia));
        System.out.println("Senha confere: " + senha.confere("senha-segura"));
        System.out.println("Email: " + email.valor());
    }
}
