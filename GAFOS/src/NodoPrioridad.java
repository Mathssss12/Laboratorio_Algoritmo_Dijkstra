public class NodoPrioridad implements Comparable<NodoPrioridad> {
    private String nombre;
    private int costoAcumulado;

    public NodoPrioridad(String nombre, int costoAcumulado) {
        this.nombre = nombre;
        this.costoAcumulado = costoAcumulado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoAcumulado() {
        return costoAcumulado;
    }

    @Override
    public int compareTo(NodoPrioridad otro) {
        return Integer.compare(this.costoAcumulado, otro.costoAcumulado);
    }
}