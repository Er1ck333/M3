package model;

import java.util.ArrayList;

public class BilleteTurista extends Billete{
    private boolean incluyeComida;
    private float pesoEquipaje;


    public BilleteTurista(boolean incluyeComida, float pesoEquipaje, Vuelo vuelo, Persona persona, String asiento, int grupo, float precioAñadido) {
        super(vuelo, persona, asiento, grupo, precioAñadido);
        this.incluyeComida = incluyeComida;
        this.pesoEquipaje = pesoEquipaje;
    }
    
    

    public boolean isIncluyeComida() {
        return incluyeComida;
    }

    public void setIncluyeComida(boolean incluyeComida) {
        this.incluyeComida = incluyeComida;
    }

    public float getPesoEquipaje() {
        return pesoEquipaje;
    }

    public void setPesoEquipaje(float pesoEquipaje) {
        this.pesoEquipaje = pesoEquipaje;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BilleteTurista{");
        sb.append(super.toString());
        sb.append("incluyeComida=").append(incluyeComida);
        sb.append(", pesoEquipaje=").append(pesoEquipaje);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
