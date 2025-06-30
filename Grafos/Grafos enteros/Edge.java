public class Edge {
    final int from;
    final int to;
    final double weight;


    public Edge(int from,int to,double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from(){
        return from;
    }

    public int to(){
        return to;
    }

    public double weight(){
        return weight;
    }
}
