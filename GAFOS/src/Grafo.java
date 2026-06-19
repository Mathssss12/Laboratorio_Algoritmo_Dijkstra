import java.util.*;

public class Grafo {
    private Map<String, List<Arista>> adyacencias;

    public Grafo() {
        adyacencias = new HashMap<>();
    }

    public void agregarVertice(String nombre) {
        adyacencias.putIfAbsent(nombre, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino, int consumo) {
        adyacencias.get(origen).add(new Arista(destino, consumo));
        adyacencias.get(destino).add(new Arista(origen, consumo));
    }

    public void mostrarGrafo() {
        System.out.println("\n=== RED VIAL ===");
        for (String nodo : adyacencias.keySet()) {
            System.out.println(nodo + " -> " + adyacencias.get(nodo));
        }
    }

    public ResultadoRuta dijkstra(String origen, String destino) {
        Map<String, Integer> distancia = new HashMap<>();
        Map<String, String> anterior = new HashMap<>();
        PriorityQueue<NodoPrioridad> cola = new PriorityQueue<>();

        // Inicialización
        for (String nodo : adyacencias.keySet()) {
            distancia.put(nodo, Integer.MAX_VALUE);
        }
        distancia.put(origen, 0);
        cola.add(new NodoPrioridad(origen, 0));

        Set<String> visitados = new HashSet<>();

        while (!cola.isEmpty()) {
            NodoPrioridad actual = cola.poll();
            String nombreActual = actual.getNombre();

            // Si ya fue procesado, se salta
            if (visitados.contains(nombreActual)) {
                continue;
            }
            visitados.add(nombreActual);

            for (Arista arista : adyacencias.get(nombreActual)) {
                String vecino = arista.getDestino();

                // Costo alternativo pasando por el nodo actual
                int nuevoCosto = distancia.get(nombreActual) + arista.getConsumo();

                // Si encontramos una ruta mejor, actualizamos
                if (nuevoCosto < distancia.get(vecino)) {
                    distancia.put(vecino, nuevoCosto);
                    anterior.put(vecino, nombreActual);
                    cola.add(new NodoPrioridad(vecino, nuevoCosto));
                }
            }
        }

        // Reconstrucción del camino desde destino hacia origen
        LinkedList<String> ruta = new LinkedList<>();
        String paso = destino;
        while (paso != null) {
            ruta.addFirst(paso);
            paso = anterior.get(paso);
        }

        return new ResultadoRuta(ruta, distancia.get(destino), origen, destino);
    }
}