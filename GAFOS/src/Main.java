public class Main {
    public static void main(String[] args) {
        Grafo ciudad = new Grafo();

        // Nodos
        ciudad.agregarVertice("Quitumbe");
        ciudad.agregarVertice("El Recreo");
        ciudad.agregarVertice("La Magdalena");
        ciudad.agregarVertice("El Panecillo");
        ciudad.agregarVertice("El Centro");
        ciudad.agregarVertice("La Marín");
        ciudad.agregarVertice("La Floresta");
        ciudad.agregarVertice("González Suárez");
        ciudad.agregarVertice("La Carolina");
        ciudad.agregarVertice("UDLA Park");

        // Aristas con consumo en Wh (basado en pendientes)
        ciudad.agregarArista("Quitumbe",        "El Recreo",        70);
        ciudad.agregarArista("El Recreo",       "La Magdalena",     60);
        ciudad.agregarArista("La Magdalena",    "El Panecillo",    150);
        ciudad.agregarArista("La Magdalena",    "El Centro",        90);
        ciudad.agregarArista("El Panecillo",    "El Centro",       160);
        ciudad.agregarArista("El Centro",       "La Marín",         90);
        ciudad.agregarArista("El Panecillo",    "La Marín",        180);
        ciudad.agregarArista("La Marín",        "La Floresta",     110);
        ciudad.agregarArista("La Floresta",     "La Carolina",      80);
        ciudad.agregarArista("La Floresta",     "González Suárez", 170);
        ciudad.agregarArista("La Carolina",     "González Suárez", 130);
        ciudad.agregarArista("La Carolina",     "UDLA Park",        60);
        ciudad.agregarArista("González Suárez", "UDLA Park",       190);

        ciudad.mostrarGrafo();

        System.out.println("\nCalculando la ruta de menor consumo...\n");

        ResultadoRuta resultado = ciudad.dijkstra(
                "Quitumbe",
                "UDLA Park"
        );

        System.out.println(resultado);
    }
}