import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> adjacencias = new HashMap<>();

        List<String> listaManaus = new ArrayList<>();
        listaManaus.add("Belém");
        listaManaus.add("Fortaleza");
        adjacencias.put("Manaus", listaManaus);

        List<String> listaBelem = new ArrayList<>();
        listaBelem.add("Manaus");
        listaBelem.add("Recife");
        listaBelem.add("Fortaleza");
        adjacencias.put("Belém", listaBelem);

        List<String> listaFortaleza = new ArrayList<>();
        listaFortaleza.add("Manaus");
        listaFortaleza.add("Belém");
        listaFortaleza.add("Recife");
        listaFortaleza.add("Salvador");
        adjacencias.put("Fortaleza", listaFortaleza);

        List<String> listaRecife = new ArrayList<>();
        listaRecife.add("Belém");
        listaRecife.add("Fortaleza");
        listaRecife.add("Salvador");
        listaRecife.add("BH");
        adjacencias.put("Recife", listaRecife);

        List<String> listaSalvador = new ArrayList<>();
        listaSalvador.add("Fortaleza");
        listaSalvador.add("Recife");
        listaSalvador.add("BH");
        listaSalvador.add("Brasília");
        adjacencias.put("Salvador", listaSalvador);

        List<String> listaBH = new ArrayList<>();
        listaBH.add("Recife");
        listaBH.add("Salvador");
        listaBH.add("RJ");
        listaBH.add("Brasília");
        listaBH.add("SP");
        adjacencias.put("BH", listaBH);

        List<String> listaBrasilia = new ArrayList<>();
        listaBrasilia.add("Salvador");
        listaBrasilia.add("BH");
        listaBrasilia.add("SP");
        listaBrasilia.add("Goiânia");
        adjacencias.put("Brasília", listaBrasilia);

        List<String> listaRJ = new ArrayList<>();
        listaRJ.add("BH");
        listaRJ.add("SP");
        adjacencias.put("RJ", listaRJ);

        List<String> listaSP = new ArrayList<>();
        listaSP.add("BH");
        listaSP.add("Brasília");
        listaSP.add("RJ");
        listaSP.add("Curitiba");
        listaSP.add("Goiânia");
        adjacencias.put("SP", listaSP);

        List<String> listaGoiania = new ArrayList<>();
        listaGoiania.add("Brasília");
        listaGoiania.add("SP");
        listaGoiania.add("Curitiba");
        adjacencias.put("Goiânia", listaGoiania);

        List<String> listaCuritiba = new ArrayList<>();
        listaCuritiba.add("SP");
        listaCuritiba.add("Goiânia");
        listaCuritiba.add("Porto Alegre");
        adjacencias.put("Curitiba", listaCuritiba);

        List<String> listaPortoAlegre = new ArrayList<>();
        listaPortoAlegre.add("Curitiba");
        adjacencias.put("Porto Alegre", listaPortoAlegre);

        Grafo grafo = new Grafo(adjacencias);

        grafo.bfs("Manaus", "Porto Alegre");
        grafo.bfs("Belém", "Goiânia");
        grafo.bfs("Fortaleza", "RJ");
    }
}