import java.util.LinkedList;
import java.util.List;

public class BellandFord {
    private double[] distTo;
    private WeightedEdge[] edgeTo;
    private int s;
    private boolean cicloNegative;
    private EdgeWeightedIntDigraph G;

    public BellandFord(EdgeWeightedIntDigraph G , int s){
        this.G = G;
        this.s = s;
        distTo = new double[G.V()];
        edgeTo = new WeightedEdge[G.V()];
        for(int i = 0 ; i < G.V() ; i++){
            if( s != i){
                distTo[i] = Double.POSITIVE_INFINITY;
            }else{
                distTo[s] = 0.0;
            }
        }

        for(int i = 1 ; i < G.V();i++){
            for(int j = 0 ; j < G.V(); j++){
                for(WeightedEdge e: G.adj(j)){
                relax(e);
            }
          }
        }
    }

    public boolean bellandFord(){
        for(int j = 0 ; j < G.V() ; j++){
            for(WeightedEdge e : G.adj(j)){
                if(distTo[e.to] > distTo[e.from] + e.weight){
                    cicloNegative = true;
                }
            }
        }
        return cicloNegative;
    }

    private void relax(WeightedEdge e){
        int v = e.from;
        int w = e.to;
        if(distTo[w] > distTo[v] + e.weight){
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;
        }
    }

     public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public List<WeightedEdge> pathTo(int v){
        if(!hasPathTo(v)){
            throw new IllegalArgumentException();
        }
        List<WeightedEdge> aux = new LinkedList<>();

        for(WeightedEdge e = edgeTo[v] ; e != null ; e = edgeTo[e.from]){
            aux.addFirst(e);
        }
        return aux;
    }

    public static void main(String[] args) {
    // Crear un grafo con 5 vértices
    EdgeWeightedIntDigraph G = new EdgeWeightedIntDigraph(5);

    // Agregar aristas con pesos (podés probar con aristas que formen ciclo negativo para testear)
    G.addEdge(new WeightedEdge(0, 1, 2.0));
    G.addEdge(new WeightedEdge(1, 2, 3.0));
    G.addEdge(new WeightedEdge(2, 0, 4.0));


    // Ejecutar Bellman-Ford desde el nodo 0
    BellandFord bf = new BellandFord(G, 0);

    // Verificar si hay ciclo negativo
   System.out.println(bf.bellandFord());

   for (int v = 0; v < 5; v++) {
        if (bf.hasPathTo(v)) {
            System.out.print("Distancia hasta " + v + ": " + bf.distTo[v] + ". Camino: ");
            List< WeightedEdge> path = bf.pathTo(v);
            for ( WeightedEdge node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            System.out.println("No hay camino hasta " + v);
        }
    }
}



}
