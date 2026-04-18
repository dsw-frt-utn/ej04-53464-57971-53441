package data;

import domain.Marca;
import domain.Sucursal;
import domain.Vehiculo;
import domain.VehiculoCombustible;
import domain.VehiculoElectrico;
import java.util.ArrayList;
import java.util.Optional;

public class Persistencia {

    // Estas son nuestras "tablas" de la base de datos en memoria
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Sucursal> sucursales = new ArrayList<>();

    // Esto se ejecuta apenas arranca el programa
    static {
        inicializarDatos();
    }

    private static void inicializarDatos() {
        // 1. Creamos un responsable (porque la clase Sucursal lo exige)
        domain.Responsable resp = new domain.Responsable("Juan Perez", "20-12345678-9", "3814556677");

        // 2. Creamos las sucursales (necesarias para poder asignar una al cargar un vehículo)
        Sucursal s1 = new Sucursal("Sucursal Centro", "San Martín 123", "San Miguel de Tucumán", resp);
        Sucursal s2 = new Sucursal("Sucursal Norte", "Av. Avellaneda 450", "San Miguel de Tucumán", resp);
        
        sucursales.add(s1);
        sucursales.add(s2);

        // 3. Dejamos las marcas creadas (opcional, para que el sistema tenga base de datos inicial)
        Marca renault = new Marca("Renault", "Francia");
        Marca ford = new Marca("Ford", "EEUU");
        
        // El punto 3.a pide eliminar los vehículos creados por código.
        // La lista 'vehiculos' queda vacía para ser llenada solo desde la ventana 'Agregar'.
    }

    // Métodos para que el Controlador pueda sacar los datos
    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public static ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    // El método que usa tu ventana "Agregar" para guardar
    public static void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    // Este lo usa el controlador para buscar por patente al calcular consumos
    public static Optional<Vehiculo> getVehiculo(String patente) {
        return vehiculos.stream()
                .filter(v -> v.getPatente().equalsIgnoreCase(patente))
                .findFirst();
    }
}