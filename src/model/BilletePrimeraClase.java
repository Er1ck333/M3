package model;

import java.util.ArrayList;

public class BilletePrimeraClase extends Billete{
    
    private boolean asientoReclinableTotal;
    private String kitDeLujo;
    private boolean servicioChofer;

    public BilletePrimeraClase(boolean asientoReclinableTotal, String kitDeLujo, boolean servicioChofer, Vuelo vuelo, Persona persona, String asiento, int grupo, float precioAñadido) {
        super(vuelo, persona, asiento, grupo, precioAñadido);
        this.asientoReclinableTotal = asientoReclinableTotal;
        this.kitDeLujo = kitDeLujo;
        this.servicioChofer = servicioChofer;
    }

    public boolean isServicioChofer() {
        return servicioChofer;
    }

    public void setServicioChofer(boolean servicioChofer) {
        this.servicioChofer = servicioChofer;
    }

    public boolean isAsientoReclinableTotal() {
        return asientoReclinableTotal;
    }

    public void setAsientoReclinableTotal(boolean asientoReclinableTotal) {
        this.asientoReclinableTotal = asientoReclinableTotal;
    }

    public String getKitDeLujo() {
        return kitDeLujo;
    }

    public void setKitDeLujo(String kitDeLujo) {
        this.kitDeLujo = kitDeLujo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BilletePrimeraClase{");
        sb.append(super.toString());
        sb.append("asientoReclinableTotal=").append(asientoReclinableTotal);
        sb.append(", kitDeLujo=").append(kitDeLujo);
        sb.append(", servicioChofer=").append(servicioChofer);
        sb.append('}');
        return sb.toString();
    }
    
    
}
