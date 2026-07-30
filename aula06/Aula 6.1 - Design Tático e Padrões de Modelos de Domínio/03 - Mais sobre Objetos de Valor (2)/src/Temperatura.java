public record Temperatura(double celsius) {
    private static final double ZERO_ABSOLUTO = -273.15;

    public Temperatura {
        if (celsius < ZERO_ABSOLUTO) {
            throw new IllegalArgumentException("Temperatura abaixo do zero absoluto.");
        }
    }

    public double toFahrenheit() {
        return celsius * 9 / 5 + 32;
    }
}
