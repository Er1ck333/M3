
package model;

import java.util.ArrayList;


public abstract class  Billete {
    private Vuelo vuelo;
    private Persona persona;
    private String asiento;
    private int grupo;
    private float precioAñadido;
    private String puerta;

    public Billete(Vuelo vuelo, Persona persona, String asiento, int grupo, float precioAñadido) {
        this.vuelo = vuelo;
        this.persona = persona;
        this.asiento = asiento;
        this.grupo = grupo;
        this.precioAñadido = precioAñadido;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Persona getPersonas() {
        return persona;
    }

    public void setPersonas(Persona persona) {
        this.persona = persona;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public float getPrecioAñadido() {
        return precioAñadido;
    }

    public void setPrecioAñadido(float precioAñadido) {
        this.precioAñadido = precioAñadido;
    }

    @Override
    public String toString() {
        return "Billete{" + "vuelo=" + vuelo + ", personas=" + persona + ", asiento=" + asiento + ", grupo=" + grupo + ", precioA\u00f1adido=" + precioAñadido + '}';
    }
    
    
    
    
    
    
    
    
}
