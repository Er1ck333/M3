package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import model.data.EnumStatus;
import model.data.EnumTipoAvion;
import java.util.Random;

/**
 *
 * @author erickpaugar
 */
public class Vuelo {
    private Ruta ruta;
    private Avion avion;
    private LocalDateTime horaLlegada;
    private LocalDateTime horaSalida;
    private EnumStatus status;
    private boolean wifiGratis;
    private ArrayList<ArrayList<Integer>> matriz;

    public Vuelo(ArrayList<Avion> listaAviones, Ruta ruta, LocalDateTime horaSalida, EnumStatus status, boolean wifiGratis) {
        this.ruta = ruta;
        this.horaSalida = horaSalida;        
        this.horaLlegada = horaSalida.plusMinutes((long) ruta.getTiempoDeVuelo());

        this.status = status;
        this.wifiGratis = wifiGratis;
        
        // OBTENER EL AVION 
        ArrayList<Avion> avionesTipOK = new ArrayList<Avion>();
        
        if (ruta.distancia < 1300) {
            for (Avion elemento : listaAviones) {
                if (elemento.getTipoAvion() == EnumTipoAvion.RUTAS_CORTAS) {
                    if (elemento.isStatus()) {
                       avionesTipOK.add(elemento); 
                    }
                }
            }
        } else if (ruta.distancia < 3400) {
            for (Avion elemento : listaAviones) {
                if (elemento.getTipoAvion() == EnumTipoAvion.RUTAS_MEDIAS) {
                    if (elemento.isStatus()) {
                       avionesTipOK.add(elemento); 
                    }
                }
            }
        } else {       
            for (Avion elemento : listaAviones) {
                if (elemento.getTipoAvion() == EnumTipoAvion.RUTAS_LARGAS) {
                    if (elemento.isStatus()) {
                       avionesTipOK.add(elemento); 
                    }
                }
            }
        }
        
        Random random = new Random();
        if (!avionesTipOK.isEmpty()) {
            int num = random.nextInt(avionesTipOK.size());
            this.avion = avionesTipOK.get(num);
            this.avion.setStatus(false);
        }
       
         
         
         
         // GENERAR EL ARRAYLIST BIDIMENSIONAL
        ArrayList<ArrayList<Integer>> matrizs = new ArrayList<>();
        
        for (int i = 0; i < this.avion.getModeloAvion().getRows(); i++) {
            ArrayList<Integer> fila = new ArrayList<>();
            for (int j = 0; j < this.avion.getModeloAvion().getColumns(); j++) {
                fila.add(1); 
            }
            matrizs.add(fila);
        }
        this.matriz = matrizs;

        
        
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public boolean isWifiGratis() {
        return wifiGratis;
    }

    public void setWifiGratis(boolean wifiGratis) {
        this.wifiGratis = wifiGratis;
    }
    
    
    public void mostrarAsientos(){
        String[] letras = {"A","B","C","D","E","F","G","H","I",};
        int separador = matriz.get(0).size() / 2;
        int val = 0;
        int numFilas = 1;
        for (ArrayList<Integer> fila : matriz) {
            
            if (val != 0) {
                int i = 0;
                if (numFilas < 10) {
                    System.out.print(numFilas + "   ");

                }else{
                    System.out.print(numFilas + "  ");

                }
                

                for (Integer valor : fila) {
                    if (i == separador) {
                        System.out.print("   ");
                    }
                    System.out.print( valor + " ");
                    i++;
                    val++;
                }
                numFilas++;
                
            }else{
                System.out.print("    ");
                for (int i = 0; i < separador * 2; i++) {
                    if (i == separador) {
                        System.out.print("   ");
                    }
                    System.out.print(letras[i] + " ");
                }
                val++;
            }
            System.out.println("");
        }
    }
    
    public boolean esValido(String input) {
        return input.matches("^[0-9]{1,2}[A-Ia-i]$");
    }

    
public boolean ocuparAsiento(String asiento) {
    if (!esValido(asiento)) {
        System.out.println("Asiento no valido");
        return false;
    }

    int fila = Integer.parseInt(asiento.substring(0, asiento.length() - 1)) - 1;  
    char letra = asiento.charAt(asiento.length() - 1);
    int col = Character.toUpperCase(letra) - 'A';

    // Valida rla posicion en la matriz
    if (fila < 0 || fila >= matriz.size() || col < 0 || col >= matriz.get(0).size()) {
        System.out.println("Asiento no valido");
        return false;
    }
    
    if (matriz.get(fila + 1).get(col) == 0) {
        System.out.println("\nAsiento ocupado");
        return false;
    }
    
    matriz.get(fila + 1).set(col , 0);  // Ocupar el asiento

    return true;
}
    
}