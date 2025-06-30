import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedIntGraph  implements EdgeGraph{
    private int V;
    private int E;
    private List<WeightedEdge>[] adj;

    public EdgeWeightedIntGraph(int v){
        if(v < 0){
            throw new IllegalArgumentException();
        }
        V = v;
        adj = new LinkedList[v];
        for(int i = 0 ; i < v ;i++){
            adj[i] = new LinkedList<>();
        }
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
    public void addEdge(WeightedEdge e) {
       if(e.from < 0 || e.from >= V){
         throw new IllegalArgumentException();
       }
       if(e.to < 0 || e.to >= V){
         throw new IllegalArgumentException();
       }
       adj[e.from].add(e);
       adj[e.to].add(e);
       E++;
    }

    @Override
    public List<WeightedEdge> adj(int v) {
        return adj[v];
        
    }
    
    public List<WeightedEdge> edges(){
      List<WeightedEdge> aux = new LinkedList<>();
      for(int i = 0; i < V() ; i++){
        for(WeightedEdge e : adj(i)){
            int w = e.to;
            if(i < w){
              aux.add(e);
            }
        }
      }
      return aux;
    }

    
}

