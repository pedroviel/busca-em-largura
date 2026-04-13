import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Grafo {
    private Map<String, List<String>> adjacencias;

    public Grafo(Map<String, List<String>> adjacencias) {
        this.adjacencias = adjacencias;
    }

    public void bfs(String s, String destino) {
        Map<String, String> cor = new HashMap<>();
        Map<String, Integer> d = new HashMap<>();
        Map<String, String> pi = new HashMap<>();

        for (String u : adjacencias.keySet()) {
            if (!u.equals(s)) {
                cor.put(u, "Branco");
                d.put(u, Integer.MAX_VALUE);
                pi.put(u, null);
            }
        }

        cor.put(s, "Cinza");
        d.put(s, 0);
        pi.put(s, null);

        Queue<String> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            String u = q.poll();

            for (String v : adjacencias.getOrDefault(u, new ArrayList<>())) {
                if (cor.get(v).equals("Branco")) {
                    cor.put(v, "Cinza");
                    d.put(v, d.get(u) + 1);
                    pi.put(v, u);
                    q.add(v);
                }
            }
            cor.put(u, "Preto");
        }

        exibirResultado(s, destino, d, pi);
    }

    private void exibirResultado(String origem, String destino, Map<String, Integer> d, Map<String, String> pi) {
        System.out.println("Rota: " + origem + " -> " + destino);

        String caminhoFinal = "";
        String atual = destino;

        while (atual != null) {
            if (caminhoFinal.equals("")) {
                caminhoFinal = atual;
            } else {
                caminhoFinal = atual + " -> " + caminhoFinal;
            }
            atual = pi.get(atual);
        }

        System.out.println("Caminho percorrido: " + caminhoFinal);
        System.out.println("Número de paradas: " + d.get(destino) + "\n");
    }
}