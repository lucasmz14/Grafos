public class WeightedEdge implements Comparable<WeightedEdge>{
    final int from;
    final int to;
    final double weight;


    public WeightedEdge(int from,int to,double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge other) {
       return Double.compare(this.weight, other.weight);
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

    public String toString(){
        return "(" + from + "->" + to + ", " + weight + ")";
    }
}
