import java.util.List;

public class ResultadoRuta {
    private List<String> ruta;
    private int consumoTotal;
    private String origen;
    private String destino;

    public ResultadoRuta(List<String> ruta, int consumoTotal, String origen, String destino) {
        this.ruta = ruta;
        this.consumoTotal = consumoTotal;
        this.origen = origen;
        this.destino = destino;
    }

    public List<String> getRuta() {
        return ruta;
    }

    public int getConsumoTotal() {
        return consumoTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RESULTADO ===\n");
        sb.append("Origen:  ").append(origen).append("\n");
        sb.append("Destino: ").append(destino).append("\n");
        sb.append("Ruta óptima:\n  ");
        sb.append(String.join(" → ", ruta));
        sb.append("\nConsumo total: ").append(consumoTotal).append(" Wh");
        return sb.toString();
    }
}