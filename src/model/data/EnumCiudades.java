package model.data;

public enum EnumCiudades {
    
    BARCELONA("BCN", "Barcelona", 41.3851, 2.1734),
    MADRID("MAD", "Madrid", 40.4168, -3.7038),
    SEVILLA("SVQ", "Sevilla", 37.3886, -5.9823),
    PARIS("CDG", "Paris", 48.8566, 2.3522),
    ROMA("FCO", "Roma", 41.9028, 12.4964),
    BERLIN("BER", "Berlin", 52.5200, 13.4050),
    COLONIA("CGN", "Colonia", 50.9375, 6.9603),
    LONDRES("LHR", "Londres", 51.5074, -0.1278),
    LISBOA("LIS", "Lisboa", 38.7169, -9.1399),
    VIENA("VIE", "Viena", 48.2082, 16.3738),
    BRUSELAS("BRU", "Bruselas", 50.8503, 4.3517),
    ATENAS("ATH", "Atenas", 37.9838, 23.7275),
    ESTOCOLMO("ARN", "Estocolmo", 59.3293, 18.0686),
    NUEVA_YORK("JFK", "Nueva York", 40.7128, -74.0060),
    TORONTO("YYZ", "Toronto", 43.6511, -79.3470),
    MONTERREY("MTY", "Monterrey", 25.6866, -100.3161),
    BUENOS_AIRES("EZE", "Buenos Aires", -34.6037, -58.3816),
    LIMA("LIM", "Lima", -12.0464, -77.0428),
    TOKIO("HND", "Tokio", 35.6895, 139.6917),
    OSAKA("KIX", "Osaka", 34.6937, 135.5023),
    HONG_KONG("HKG", "Hong Kong", 22.3193, 114.1694),
    SINGAPUR("SIN", "Singapur", 1.3521, 103.8198),
    ESTAMBUL("IST", "Estambul", 41.0082, 28.9784);

    private final String letras;
    private final String nombre;
    private final double latitud;
    private final double longitud;

    EnumCiudades(String letras, String nombre, double latitud, double longitud) {
        this.letras = letras;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getLetras() {
        return letras;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}