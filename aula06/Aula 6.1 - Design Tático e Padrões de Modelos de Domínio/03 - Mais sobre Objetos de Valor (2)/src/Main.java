public class Main {
    public static void main(String[] args) {
        Temperatura temperatura = new Temperatura(25);
        System.out.printf("%.1f C equivale a %.1f F%n", temperatura.celsius(), temperatura.toFahrenheit());
    }
}
