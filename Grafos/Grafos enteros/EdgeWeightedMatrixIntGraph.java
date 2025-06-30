import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedMatrixIntGraph implements EdgeGraph{
    private int V;
    private int E;
    private Edge[][] adj;


    public EdgeWeightedMatrixIntGraph(int v){
        if(v < 0){
            throw new IllegalArgumentException();
        }
        V = v;
        adj = new Edge[v][v]; 
    }
    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(Edge e) {
       if(e.from < V || e.from >= V){
            throw new IllegalArgumentException();
       }
       if(e.to < V || e.to >= V){
            throw new IllegalArgumentException();
       }
       adj[e.from][e.to] = e;
       adj[e.to][e.from] = e; 
       E++;
    }

    @Override
    public List<Edge> adj(int v) {
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }

        List<Edge> aux = new LinkedList<>();

        for(int i = 0 ; i < V() ; i++){
            if(adj[v][i] != null){
                aux.add(adj[v][i]);
            }
        }

        return aux;
    }
    
}

