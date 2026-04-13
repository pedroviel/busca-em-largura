import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> adjacencias = new HashMap<>();

        adjacencias.put("Manaus", Arrays.asList("Belém", "Fortaleza"));
        adjacencias.put("Belém", Arrays.asList("Manaus", "Recife", "Fortaleza"));
        adjacencias.put("Fortaleza", Arrays.asList("Manaus", "Belém", "Recife", "Salvador"));
        adjacencias.put("Recife", Arrays.asList("Belém", "Fortaleza", "Salvador", "BH"));
        adjacencias.put("Salvador", Arrays.asList("Fortaleza", "Recife", "BH", "Brasília"));
        adjacencias.put("BH", Arrays.asList("Recife", "Salvador", "RJ", "Brasília", "SP"));
        adjacencias.put("Brasília", Arrays.asList("Salvador", "BH", "SP", "Goiânia"));
        adjacencias.put("RJ", Arrays.asList("BH", "SP"));
        adjacencias.put("SP", Arrays.asList("BH", "Brasília", "RJ", "Curitiba", "Goiânia"));
        adjacencias.put("Goiânia", Arrays.asList("Brasília", "SP", "Curitiba"));
        adjacencias.put("Curitiba", Arrays.asList("SP", "Goiânia", "Porto Alegre"));
        adjacencias.put("Porto Alegre", Arrays.asList("Curitiba"));

        Grafo grafo = new Grafo(adjacencias);

        grafo.bfs("Manaus", "Porto Alegre");
        grafo.bfs("Belém", "Goiânia");
        grafo.bfs("Fortaleza", "RJ");
    }
}