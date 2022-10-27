package 算法基础.class06;

import java.util.HashMap;
import java.util.HashSet;

//图结构描述
public class Graph {
    //拥有的点集
    public HashMap<Integer, Node> nodes;
    //拥有的边集
    public HashSet<Edge> edges;

    {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}