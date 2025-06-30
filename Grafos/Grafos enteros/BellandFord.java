import java.util.LinkedList;
import java.util.List;

public class BellandFord {
    private double[] distTo;
    private int[] edgeTo;
    private int s;
    private boolean cicloNegative;
    private EdgeWeightedIntDigraph G;

    public BellandFord(EdgeWeightedIntDigraph G , int s){
        this.G = G;
        distTo = new double[G.V()];
        edgeTo = new int[G.V()];

        for(int i = 0 ; i < G.V(); i++){
            if(s != i){
            distTo[i] = Double.POSITIVE_INFINITY;
            }
        }

        distTo[s] = 0.0;
         for(int t = 1 ; t < G.V(); t++){
          for(int i = 0 ; i < G.V(); i++){
            for(Edge e : G.adj(i)){
                relax(e);
            }
          }
        }
    }

    public boolean bellandFord(){
        for(int j = 0 ; j < G.V() ; j++){
            for(Edge e : G.adj(j)){
                if(distTo[e.to] > distTo[e.from] + e.weight){
                    cicloNegative = true;
                }
            }
        }
        return cicloNegative;
    }

    private void relax(Edge e){
        int v = e.from;
        int w = e.to;
        if(distTo[w] > distTo[v] + e.weight){
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = v;
        }
    }

     public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }


    public List<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        List<Integer> aux = new LinkedList<>();

        for(int i = v ; i != s ; i = edgeTo[i]){
            aux.addFirst(i);
        }
        aux.addFirst(s);
        return aux;
    }

    public static void main(String[] args) {
    // Crear un grafo con 5 vértices
    EdgeWeightedIntDigraph G = new EdgeWeightedIntDigraph(5);

    // Agregar aristas con pesos (podés probar con aristas que formen ciclo negativo para testear)
    G.addEdge(new Edge(0, 1, -2.0));
    G.addEdge(new Edge(1, 2, -3.0));
    G.addEdge(new Edge(2, 0, -4.0));


    // Ejecutar Bellman-Ford desde el nodo 0
    BellandFord bf = new BellandFord(G, 0);

    // Verificar si hay ciclo negativo
   System.out.println(bf.bellandFord());

   for (int v = 0; v < 5; v++) {
        if (bf.hasPathTo(v)) {
            System.out.print("Distancia hasta " + v + ": " + bf.distTo[v] + ". Camino: ");
            List<Integer> path = bf.pathTo(v);
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            System.out.println("No hay camino hasta " + v);
        }
    }
}



}
