public interface Graph <T extends Comparable<? super T>>{
    
public int V();

public int E();

public T nameOf(int v);

public int indexOf(T v);

public void addVertex(T v);

public boolean containsVertex(T v);

public void addEdge(T v, T w);


    
}
