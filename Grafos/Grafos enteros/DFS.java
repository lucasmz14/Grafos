import java.util.LinkedList;
import java.util.List;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private AdjacencyListIntGraph G;
    private int count;

    public DFS(AdjacencyListIntGraph G , int s){
        this.G = G;
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G , s);
    }


    public void dfs(AdjacencyListIntGraph G ,int s){
        count++;
        marked[s] = true;
        for(int e : G.adj(s)){
            if(!marked[e]){
            edgeTo[e] = s;
            dfs(G,e);
            }
        }
    }

    public boolean isConexo(){
        return count == G.V();
    }


    public Boolean hashTo(int v){
        return marked[v];
    }


    public List<Integer> pathTo(int v){
        if(!marked[v]){
            throw new IllegalArgumentException();
        }

        List<Integer> aux = new LinkedList<>();

        for(int i = v ; i != s; i = edgeTo[i]){
            aux.addFirst(i);
        }

        aux.addFirst(s);

        return aux;
    }
}
