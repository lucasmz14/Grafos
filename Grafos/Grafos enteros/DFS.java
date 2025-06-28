import java.util.LinkedList;
import java.util.List;

public class DFS {
    private boolean[] marked;
    private Boolean isConexo;
    private int count;
    private int[] edgeTo;
    private AdjacencyListIntGraph G;
    private int s;

    public DFS(AdjacencyListIntGraph G, int s){
        this.G = G;
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G , s);
    }


    private void dfs(AdjacencyListIntGraph G,int s){
        marked[s] = true;
        count++;
        for(int i : G.adj(s)){
            if(!marked[i]){
                edgeTo[i] = s;
                dfs(G , i);
            }
        }
    }

    public boolean isConexo(){
        return (count == G.V());
    }

    public boolean hasPathTo(int v){
        return marked[v];
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


}
