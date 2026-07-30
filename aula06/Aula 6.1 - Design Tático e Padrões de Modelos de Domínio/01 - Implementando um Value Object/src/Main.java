public class Main {
    public static void main(String[] args) {
        Cpf cpf = new Cpf("123.456.789-01");
        CpfRecord cpfComRecord = new CpfRecord("12345678901");
        System.out.println("Classe: " + cpf.valor());
        System.out.println("Record: " + cpfComRecord.valor());
        System.out.println("Mesmo valor: " + cpf.equals(new Cpf(cpfComRecord.valor())));
    }
}
