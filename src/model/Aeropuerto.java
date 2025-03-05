package model;

import java.util.ArrayList;
import model.data.EnumCiudades;

public class Aeropuerto {
    private String nombre;
    private String codigo;
    private EnumCiudades ciudad;
    private ArrayList puertas;

    public Aeropuerto(String nombre, String codigo, EnumCiudades ciudad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ciudad = ciudad;

    }

    public ArrayList getPuertas() {
        return puertas;
    }

    public void setPuertas(ArrayList puertas) {
        this.puertas = puertas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public EnumCiudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(EnumCiudades ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aeropuerto{");
        sb.append("nombre=").append(nombre);
        sb.append(", codigo=").append(codigo);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", puertas=").append(puertas);
        sb.append('}');
        return sb.toString();
    }
    
    
}
