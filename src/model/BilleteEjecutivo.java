package model;

import java.util.ArrayList;

public class BilleteEjecutivo extends Billete{
    private boolean accesoSalaVip;
    private boolean cateringPersonalizado;
    private float capacidadEquipajeAdicional;

    public BilleteEjecutivo(boolean accesoSalaVip, boolean cateringPersonalizado, float capacidadEquipajeAdicional, Vuelo vuelo, Persona persona, String asiento, int grupo, float precioAñadido) {
        super(vuelo, persona, asiento, grupo, precioAñadido);
        this.accesoSalaVip = accesoSalaVip;
        this.cateringPersonalizado = cateringPersonalizado;
        this.capacidadEquipajeAdicional = capacidadEquipajeAdicional;
    }

    public boolean isAccesoSalaVip() {
        return accesoSalaVip;
    }

    public void setAccesoSalaVip(boolean accesoSalaVip) {
        this.accesoSalaVip = accesoSalaVip;
    }

    public boolean isCateringPersonalizado() {
        return cateringPersonalizado;
    }

    public void setCateringPersonalizado(boolean cateringPersonalizado) {
        this.cateringPersonalizado = cateringPersonalizado;
    }

    public float getCapacidadEquipajeAdicional() {
        return capacidadEquipajeAdicional;
    }

    public void setCapacidadEquipajeAdicional(float capacidadEquipajeAdicional) {
        this.capacidadEquipajeAdicional = capacidadEquipajeAdicional;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BilleteEjecutivo{");
        sb.append(super.toString());
        sb.append("accesoSalaVip=").append(accesoSalaVip);
        sb.append(", cateringPersonalizado=").append(cateringPersonalizado);
        sb.append(", capacidadEquipajeAdicional=").append(capacidadEquipajeAdicional);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
