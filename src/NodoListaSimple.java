public class NodoListaSimple {
    String placa;
    String fechaIngreso;
    String horaIngreso;
    String fechaSalida;
    String horaSalida;
    NodoListaSimple siguiente;

    public NodoListaSimple(String placa, String fechaIngreso, String horaIngreso) {
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.fechaSalida = null;
        this.horaSalida = null;
    }
}
