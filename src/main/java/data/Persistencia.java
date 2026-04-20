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