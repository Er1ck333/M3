package view.console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Aeropuerto;
import model.Avion;
import model.Billete;
import model.BilleteEjecutivo;
import model.BilletePrimeraClase;
import model.BilleteTurista;    
import model.Persona;
import model.Ruta;
import model.Vuelo;
import model.data.EnumCiudades;
import model.data.EnumModelos;
import model.data.EnumStatus;
import model.data.EnumTipoAvion;

// IMPORTS PDF
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.property.HorizontalAlignment;
import java.io.File;
import javax.swing.SwingUtilities;

// Importar excepciones personalizadas
import model.exceptions.SeatBookedException;
import model.exceptions.MatriculaRepetidaException;
import view.gui.NewJFrame;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static ArrayList<Avion> aviones = new ArrayList<Avion>();
    public static ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();    
    public static ArrayList<Billete> billetes = new ArrayList<Billete>();
    public static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
        // Añadir aviones validando matrícula duplicada
        try {
            addAvion(new Avion(EnumTipoAvion.RUTAS_CORTAS, EnumModelos.AIRBUS_A320, 2000, "651AS"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_CORTAS, EnumModelos.BOEING_737, 2000, "8FD5E"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_CORTAS, EnumModelos.AIRBUS_A320, 2000, "S5DF4"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_CORTAS, EnumModelos.BOEING_737, 2000, "HYH85"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_CORTAS, EnumModelos.AIRBUS_A320, 2000, "S5D4D"));
            // Intento de añadir un avión con matrícula duplicada
            addAvion(new Avion(EnumTipoAvion.RUTAS_CORTAS, EnumModelos.BOEING_737, 2000, "8FD5E"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_MEDIAS, EnumModelos.AIRBUS_A330, 2000, "GF65F"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_MEDIAS, EnumModelos.BOEING_757, 2000, "ASD45"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_LARGAS, EnumModelos.BOEING_747, 2000, "ASD45"));
            addAvion(new Avion(EnumTipoAvion.RUTAS_LARGAS, EnumModelos.AIRBUS_A380, 2000, "ASD45"));
        } catch (Exception e) {
            System.out.println("Error al añadir avión: " + e.getMessage());
        }

        // Aeropuertos
        aeropuertos.add(new Aeropuerto("El Prat", "LEBL", EnumCiudades.BARCELONA));
        aeropuertos.add(new Aeropuerto("Adolfo Suárez Madrid-Barajas", "LEMD", EnumCiudades.MADRID));
        aeropuertos.add(new Aeropuerto("Sevilla", "LEZL", EnumCiudades.SEVILLA));
        aeropuertos.add(new Aeropuerto("Charles de Gaulle", "LFPG", EnumCiudades.PARIS));
        aeropuertos.add(new Aeropuerto("Fiumicino", "LIRF", EnumCiudades.ROMA));
        aeropuertos.add(new Aeropuerto("Berlin Brandenburg", "EDDB", EnumCiudades.BERLIN));
        aeropuertos.add(new Aeropuerto("Colonia/Bonn", "EDDK", EnumCiudades.COLONIA));
        aeropuertos.add(new Aeropuerto("Heathrow", "EGLL", EnumCiudades.LONDRES));
        aeropuertos.add(new Aeropuerto("Humberto Delgado", "LPPT", EnumCiudades.LISBOA));
        aeropuertos.add(new Aeropuerto("Vienna International", "LOWW", EnumCiudades.VIENA));
        aeropuertos.add(new Aeropuerto("Brussels Airport", "EBBR", EnumCiudades.BRUSELAS));
        aeropuertos.add(new Aeropuerto("Eleftherios Venizelos", "LGAV", EnumCiudades.ATENAS));
        aeropuertos.add(new Aeropuerto("Arlanda", "ESSA", EnumCiudades.ESTOCOLMO));
        aeropuertos.add(new Aeropuerto("John F. Kennedy", "KJFK", EnumCiudades.NUEVA_YORK));
        aeropuertos.add(new Aeropuerto("Toronto Pearson", "CYYZ", EnumCiudades.TORONTO));
        aeropuertos.add(new Aeropuerto("General Mariano Escobedo", "MMMY", EnumCiudades.MONTERREY));
        aeropuertos.add(new Aeropuerto("Ministro Pistarini", "SAEZ", EnumCiudades.BUENOS_AIRES));
        aeropuertos.add(new Aeropuerto("Jorge Chávez", "SPJC", EnumCiudades.LIMA));
        aeropuertos.add(new Aeropuerto("Haneda", "RJTT", EnumCiudades.TOKIO));
        aeropuertos.add(new Aeropuerto("Kansai", "RJBB", EnumCiudades.OSAKA));
        aeropuertos.add(new Aeropuerto("Hong Kong International", "VHHH", EnumCiudades.HONG_KONG));
        aeropuertos.add(new Aeropuerto("Changi", "WSSS", EnumCiudades.SINGAPUR));
        aeropuertos.add(new Aeropuerto("Istanbul", "LTFM", EnumCiudades.ESTAMBUL));

        String opcion;
        do {
            cls();
            System.out.println("");
            System.out.println("1.- Buscar vuelos");
            System.out.println("2.- Ver billetes anteriores");
            System.out.println("0- Salir");
            System.out.print("Opcion: ");
            opcion = scan.next();
            cls();

            switch (opcion) {
                case "1":
                    nuevoVuelo();
                    break;
                case "2":
                    mostrarBilletes();
                    break;
                case "3":
                    test();
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
                    break;
            }
        } while (!opcion.equals("0"));
    }
    
    // Método auxiliar para añadir aviones con validación de matrícula duplicada
    private static void addAvion(Avion avion) throws MatriculaRepetidaException {
        for (Avion a : aviones) {
            if (a.getMatricula().equals(avion.getMatricula())) {
                throw new MatriculaRepetidaException("La matrícula " + avion.getMatricula() + " ya existe.");
            }
        }
        aviones.add(avion);
    }
    
    public static void mostrarBilletes(){
        for (Billete billete : billetes) {
            System.out.println(billete.toString());
        }
    }
    
    public static void test() {
        Ruta rutaSeleccionada = new Ruta(aeropuertos.get(0), aeropuertos.get(1));
        Vuelo testVuelo = new Vuelo(aviones, rutaSeleccionada, LocalDateTime.now(), EnumStatus.EN_HORA, true);
        
        System.out.println("Selecciona el asiento (1A)");
        testVuelo.mostrarAsientos();
        System.out.print(">> ");
        String asientioSelec = scan.next();
        
        try {
            if (!testVuelo.ocuparAsiento(asientioSelec)) {
                throw new SeatBookedException("El asiento " + asientioSelec + " ya está ocupado.");
            }
            System.out.println("Asiento reservado: " + asientioSelec);
        } catch (SeatBookedException e) {
            System.out.println(e.getMessage());
        }
        
        testVuelo.mostrarAsientos();
    }

    private static void recorrerCiudades() {
        int i = 1;
        for (Aeropuerto aeropuerto : aeropuertos) {
            System.out.println(i + "- " + aeropuerto.getCiudad().getNombre());
            i++;
        }
    }

    private static void cls(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
    
    public static void nuevoVuelo() {
        // Selección de la ciudad de salida
        boolean val = true;
        String posCiudadSalida = "";
        while (val) {
            System.out.println("\nSeleccione la ciudad de salida ");
            recorrerCiudades();
            System.out.print(">> ");
            try {
                posCiudadSalida = scan.next();
                int pos = Integer.parseInt(posCiudadSalida);
                if (pos > 0 && pos <= aeropuertos.size()) {
                    val = false;
                } else {
                    System.out.println("Ciudad no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no es un número. Por favor, introduzca un número.");
            }
        }

        // Selección de la ciudad de destino
        val = true;
        String posCiudadDestino = "";
        while (val) {
            System.out.println("\nSeleccione la ciudad de destino ");
            recorrerCiudades();
            System.out.print(">> ");
            try {
                posCiudadDestino = scan.next();
                int pos = Integer.parseInt(posCiudadDestino);
                if (pos > 0 && pos <= aeropuertos.size()) {
                    if (posCiudadDestino.equals(posCiudadSalida)) {
                        System.out.println("\nNo puedes seleccionar la misma ciudad");
                    } else {
                        val = false;
                    }
                } else {
                    System.out.println("Ciudad no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no es un número. Por favor, introduzca un número.");
            }
        }

        Ruta rutaSeleccionada = new Ruta(aeropuertos.get(Integer.parseInt(posCiudadDestino) - 1), 
                                          aeropuertos.get(Integer.parseInt(posCiudadSalida) - 1));

        // Introducir fecha
        val = true;
        LocalDate fecha = null;
        while (val) {
            System.out.print("\nIntroduce la fecha deseada (dd/MM/yyyy)\n>> ");
            String stringFecha = scan.next();
            try {
                fecha = LocalDate.parse(stringFecha, formatter);
                if (fecha.isBefore(LocalDate.now())) {
                    System.out.println("\nERROR: Introduce una fecha válida\n");
                } else {
                    val = false;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Usa el formato (dd/MM/yyyy).");
            }
        }

        // Selección de la hora
        val = true;
        LocalDateTime fechaHora = null;
        while (val) {
            System.out.print("\n Selecciona una hora\n1- 9:00\n2- 17:00\n3- 21:00\n>> ");
            String opcHora = scan.next();
            if (opcHora.equals("1")) {
                fechaHora = fecha.atStartOfDay().plusHours(9);
                val = false;
            } else if (opcHora.equals("2")) {
                fechaHora = fecha.atStartOfDay().plusHours(17);
                val = false;
            } else if (opcHora.equals("3")) {
                fechaHora = fecha.atStartOfDay().plusHours(21);
                val = false;
            } else {
                System.out.println("Seleccione una opción válida");
            }
        }

        // Buscar o crear el vuelo
        Vuelo vuelo = null;
        boolean vueloEncontrado = false;
        for (Vuelo vueloR : vuelos) {
            if (vueloR.getRuta().equals(rutaSeleccionada) &&
                vueloR.getHoraSalida().isEqual(fechaHora)) {
                vueloEncontrado = true;
                vuelo = vueloR;
                break;
            }
        }
        
        if (!vueloEncontrado) {
            vuelo = new Vuelo(aviones, rutaSeleccionada, fechaHora, EnumStatus.EN_HORA, true);
        }
        
        // Selección y reserva del asiento
        String asientioSelec = "";
        val = true;
        while(val) {
            System.out.println("Selecciona el asiento (ej: 1A)");
            vuelo.mostrarAsientos();
            System.out.print(">> ");
            asientioSelec = scan.next();
            try {
                boolean res = vuelo.ocuparAsiento(asientioSelec);
                if (!res) {
                    throw new SeatBookedException("El asiento " + asientioSelec + " ya está ocupado.");
                }
                val = false;
            } catch (SeatBookedException e) {
                System.out.println(e.getMessage());
                System.out.println("\nIntentelo de nuevo:");
            }
        }
       
        // Si el vuelo es nuevo se añade, si ya existe se mantiene
        if (!vueloEncontrado) {
            vuelos.add(vuelo);
        }
        
        // Selección de clase
        val = true;
        int opc = 0;
        while(val) {
            cls();
            System.out.println("Selecciona la clase: ");
            System.out.println("1- Primera clase");
            System.out.println("2- Ejecutivo");
            System.out.println("3- Turista");
            System.out.print(">> ");
            try {
                opc = Integer.parseInt(scan.next());
                if (opc > 0 && opc <= 3) {
                    val = false;
                } else {
                    System.out.println("\nSelecciona una opción válida\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no es un número. Por favor, introduzca un número.");
            }
        }
        
        // Recoger datos del pasajero
        System.out.println("Introduce tus datos:");
        System.out.print("\nNombre: ");
        String nombre = scan.next();
        System.out.print("\nApellidos: ");
        String apellidos = scan.next();
        System.out.print("\nDNI: ");
        String DNI = scan.next();
        System.out.print("\nFecha de nacimiento: ");
        String fechaNacimiento = scan.next();
        System.out.print("\nEmail: ");
        String email = scan.next();
        System.out.print("\nTeléfono: ");
        String telefono = scan.next();
        System.out.print("\nPaís de residencia: ");
        String pais = scan.next();
        cls();
        Persona persona = new Persona(nombre, apellidos, DNI, fechaNacimiento, email, telefono, pais);

        // Creación del billete según la clase seleccionada
        if (opc == 1) {
            BilletePrimeraClase primerClase = new BilletePrimeraClase(true, "si", true, vuelo, persona, asientioSelec, 1, 300);
            billetes.add(primerClase);
        } else if (opc == 2) {
            BilleteEjecutivo ejecutivo = new BilleteEjecutivo(true, true, 29, vuelo, persona, asientioSelec, 1, 100);
            billetes.add(ejecutivo);
        } else {
            BilleteTurista turista = new BilleteTurista(false, 0, vuelo, persona, asientioSelec, 2, 0);
            billetes.add(turista);
        }
        
        // Generar PDF del billete
        String destinoArchivo = "Informacion_Billete.pdf";
        try {
            PdfWriter writer = new PdfWriter(destinoArchivo);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc, PageSize.A4);

            // Título
            document.add(new Paragraph("BILLETE")
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(18));

            // Datos del pasajero y vuelo
            document.add(new Paragraph("Nombre del pasajero: " + persona.getNombre() + " " + persona.getApellidos()));
            document.add(new Paragraph("Salida desde: " + rutaSeleccionada.getAeropuertoOrigen()));
            document.add(new Paragraph("Destino: " + rutaSeleccionada.getAeropuertoDestino()));
            document.add(new Paragraph("Aerolínea: ClasesVueling"));
            document.add(new Paragraph("Fecha: " + vuelo.getHoraSalida()));
            document.add(new Paragraph("Asiento: " + asientioSelec));

            // Generar código de barras y añadirlo al documento
            Barcode128 barcode = new Barcode128(pdfDoc);
            barcode.setCode("1234563434242285789"); // Código de ejemplo
            barcode.setFont(null);
            Image image = new Image(barcode.createFormXObject(pdfDoc));
            image.setHorizontalAlignment(HorizontalAlignment.CENTER);
            document.add(image);

            document.close();
            System.out.println("PDF generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Tu reserva se ha completado con éxito");        
        System.out.println("Pulsa ENTER para volver al menú");
        scan.next();
        cls();
    }
}
