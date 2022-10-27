package 算法基础.class06;

//边结构描述
public class Edge {
    //边的长度
    public int weight;
    //从那个点来
    public Node from;
    //指向那个点
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}