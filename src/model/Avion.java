/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.data.EnumModelos;
import model.data.EnumTipoAvion;

/**
 *
 * @author erickpaugar
 */
public class Avion {
    private EnumTipoAvion tipoAvion;
    private EnumModelos modeloAvion;
    private float distaciaMax;
    private String matricula;
    private boolean status;


    public Avion(EnumTipoAvion tipoAvion, EnumModelos modeloAvion, float distaciaMax, String matricula) {
        this.tipoAvion = tipoAvion;
        this.modeloAvion = modeloAvion;
        this.distaciaMax = distaciaMax;
        this.matricula = matricula;
        this.status = true;
    }

    public Avion(){
        
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public EnumTipoAvion getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(EnumTipoAvion tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public EnumModelos getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(EnumModelos modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public float getDistaciaMax() {
        return distaciaMax;
    }

    public void setDistaciaMax(float distaciaMax) {
        this.distaciaMax = distaciaMax;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Avion{");
        sb.append("tipoAvion=").append(tipoAvion);
        sb.append(", modeloAvion=").append(modeloAvion);
        sb.append(", distaciaMax=").append(distaciaMax);
        sb.append(", matricula=").append(matricula);
        sb.append('}');
        return sb.toString();
    }
    
}
