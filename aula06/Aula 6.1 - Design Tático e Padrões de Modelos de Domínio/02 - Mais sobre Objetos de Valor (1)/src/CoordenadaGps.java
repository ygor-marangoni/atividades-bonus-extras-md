public record CoordenadaGps(double latitude, double longitude) {
    public CoordenadaGps {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude deve estar entre -90 e 90.");
        }
        if (longitude < 0 || longitude > 180) {
            throw new IllegalArgumentException("Longitude deve estar entre 0 e 180.");
        }
    }

    /** Distancia aproximada em quilometros, pela formula de Haversine. */
    public double distanceTo(CoordenadaGps outra) {
        double raioTerraKm = 6371.0;
        double deltaLatitude = Math.toRadians(outra.latitude - latitude);
        double deltaLongitude = Math.toRadians(outra.longitude - longitude);
        double a = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2)
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(outra.latitude))
                * Math.sin(deltaLongitude / 2) * Math.sin(deltaLongitude / 2);
        return raioTerraKm * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }
}
