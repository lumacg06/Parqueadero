import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PilaParking {
    private NodoListaSimple top;
    private int tamano;

    public PilaParking() {
        this.top = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return top == null;
    }

    public void ingresar(String placa, String fechaIngreso, String horaIngreso) {
        NodoListaSimple nuevoNodo = new NodoListaSimple(placa, fechaIngreso, horaIngreso);
        nuevoNodo.siguiente = top;
        top = nuevoNodo;
        tamano++;
    }

    public NodoListaSimple retirar(String placa, String fechaSalida, String horaSalida) {
        NodoListaSimple actual = top;
        NodoListaSimple anterior = null;
        NodoListaSimple nodoRetirado = null;

        while (actual != null && !actual.placa.equals(placa)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            actual.fechaSalida = fechaSalida;
            actual.horaSalida = horaSalida;
            nodoRetirado = actual;
            if (anterior != null) {
                anterior.siguiente = actual.siguiente;
            } else {
                top = actual.siguiente;
            }
            tamano--;
        }

        return nodoRetirado;
    }

    public String buscarVehiculo(String placa) {
        NodoListaSimple actual = top;
        int posicion = 0;

        while (actual != null) {
            if (actual.placa.equals(placa)) {
                return "Vehículo encontrado en la posición: " + posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }

        return "Vehículo no encontrado.";
    }

    public void mostrarPila() {
        NodoListaSimple actual = top;
        while (actual != null) {
            System.out.println("Placa: " + actual.placa + ", Fecha Ingreso: " + actual.fechaIngreso + ", Hora Ingreso: " + actual.horaIngreso);
            actual = actual.siguiente;
        }
    }

    public long calcularCosto(NodoListaSimple vehiculo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date fechaHoraIngreso = sdf.parse(vehiculo.fechaIngreso + " " + vehiculo.horaIngreso);
            Date fechaHoraSalida = sdf.parse(vehiculo.fechaSalida + " " + vehiculo.horaSalida);

            long diffInMillies = Math.abs(fechaHoraSalida.getTime() - fechaHoraIngreso.getTime());
            long diffInHours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if (diffInHours <= 4) {
                return diffInHours * 1000;
            } else if (diffInHours <= 24) {
                return 6000;
            } else {
                long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                return diffInDays * 150000;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
