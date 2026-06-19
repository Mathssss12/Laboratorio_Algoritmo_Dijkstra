public class Arista {
    private String destino;
    private int consumo;

    public Arista(String destino, int consumo) {
        this.destino = destino;
        this.consumo = consumo;
    }

    public String getDestino() {
        return destino;
    }

    public int getConsumo() {
        return consumo;
    }

    @Override
    public String toString() {
        return destino + " (" + consumo + " Wh)";
    }
}