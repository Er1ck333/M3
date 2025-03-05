package model;

import java.util.Objects;
import model.data.EnumCiudades;

public class Ruta {

    double distancia;

    Aeropuerto aeropuertoOrigen;
    Aeropuerto aeropuertoDestino;
    double tiempoDeVuelo;

    public Ruta(Aeropuerto aeropuertoDestino, Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.tiempoDeVuelo = tiempoDeVuelo;
        
        
        this.distancia = calcDistancia(this.aeropuertoDestino.getCiudad(),this.aeropuertoOrigen.getCiudad());
        
            this.tiempoDeVuelo =  this.distancia * 0.140;
        }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }



    public double getTiempoDeVuelo() {
        return tiempoDeVuelo;
    }

    public void setTiempoDeVuelo(int tiempoDeVuelo) {
        this.tiempoDeVuelo = tiempoDeVuelo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ruta{");
        sb.append("distancia=").append(distancia);
        sb.append(", aeropuertoOrigen=").append(aeropuertoOrigen);
        sb.append(", aeropuertoDestino=").append(aeropuertoDestino);
        sb.append(", tiempoDeVuelo=").append(tiempoDeVuelo);
        sb.append('}');
        return sb.toString();
    }

    
    private double calcDistancia(EnumCiudades ciudad1, EnumCiudades ciudad2) {

        // Coordenadas de las ciudades
        double lat1 = ciudad1.getLatitud();
        double lon1 = ciudad1.getLongitud();
        double lat2 = ciudad2.getLatitud();
        double lon2 = ciudad2.getLongitud();

        // Radio de la Tierra en kilómetros
        final double R = 6371.0;

        // Convertir grados a radianes
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double deltaPhi = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);

        // Fórmula de Haversine
        double a = Math.sin(deltaPhi / 2.0) * Math.sin(deltaPhi / 2.0)
                + Math.cos(phi1) * Math.cos(phi2) * Math.sin(deltaLambda / 2.0) * Math.sin(deltaLambda / 2.0);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distancia en kilómetros
        return R * c;

    }
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ruta other = (Ruta) obj;
        return aeropuertoOrigen.equals(other.aeropuertoOrigen) &&
               aeropuertoDestino.equals(other.aeropuertoDestino);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.aeropuertoOrigen);
        hash = 79 * hash + Objects.hashCode(this.aeropuertoDestino);
        return hash;
    }

}
