package 算法基础.class06;

import java.util.ArrayList;

// 点结构的描述
public class Node {
    //值
    public int value;
    //入度
    public int in;
    //出度
    public int out;
    //相邻的点集
    public ArrayList<Node> nexts;
    //相邻的边集
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }
}