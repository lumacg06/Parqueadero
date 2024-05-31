public class Parqueadero {
    private PilaParking pilaParking;

    public Parqueadero() {
        pilaParking = new PilaParking();
    }

    public void inicializarPila() {
        pilaParking = new PilaParking();
    }

    public void ingresarVehiculo(String placa, String fechaIngreso, String horaIngreso) {
        pilaParking.ingresar(placa, fechaIngreso, horaIngreso);
    }

    public void retirarVehiculo(String placa, String fechaSalida, String horaSalida) {
        NodoListaSimple vehiculo = pilaParking.retirar(placa, fechaSalida, horaSalida);
        if (vehiculo != null) {
            long costo = pilaParking.calcularCosto(vehiculo);
            System.out.println("Vehículo retirado: " + vehiculo.placa);
            System.out.println("Costo del parqueo: $" + costo + " pesos.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    public void buscarVehiculo(String placa) {
        String resultado = pilaParking.buscarVehiculo(placa);
        System.out.println(resultado);
    }

    public void mostrarPila() {
        pilaParking.mostrarPila();
    }
}

