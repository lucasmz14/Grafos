import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private AdjacencyListIntGraph G;

    public BFS(AdjacencyListIntGraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        this.G = G;
        bfs(G,s);
    }


    private void bfs(AdjacencyListIntGraph G,int s){
        Queue<Integer> q = new LinkedList<>();
        marked[s] = true;
        q.add(s);

        while(!q.isEmpty()){
             int v = q.remove();

             for(int w : G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.add(w);
                }

             }

        }

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

