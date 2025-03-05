package model;

import java.time.LocalDate;


public class Persona {
    private String nombre;
    private String apellidos;
    private String DNI;
    private String fechaNacimiento;
    private String email;
    private String telefono;
    private String pais;

    public Persona(String nombre, String apellidos, String DNI, String fechaNacimiento,  String email, String telefono, String pais) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", DNI=").append(DNI);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append(", pais=").append(pais);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
