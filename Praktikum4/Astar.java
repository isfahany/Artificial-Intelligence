package Praktikum4;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Astar {

    public static void main(String[] args) {
        Node a = new Node("A", 50);
        Node b = new Node("B", 47);
        Node c = new Node("C", 10);
        Node d = new Node("D", 0);
        Node e = new Node("E", 15);
        Node f = new Node("F", 45);
        Node g = new Node("G", 31);

        a.adjacencies = new Edge[]{
            new Edge(b, 22),
            new Edge(g, 19),
            new Edge(f, 24)
        };
        b.adjacencies = new Edge[]{
            new Edge(a, 22),
            new Edge(g, 15),
            new Edge(d, 48),
            new Edge(c, 30)
        };
        c.adjacencies = new Edge[]{
            new Edge(b, 30),
            new Edge(d, 16)
        };
        d.adjacencies = new Edge[]{
            new Edge(c, 16),
            new Edge(b, 48),
            new Edge(f, 50),
            new Edge(e, 17)
        };
        e.adjacencies = new Edge[]{
            new Edge(d, 17),
            new Edge(f, 36)
        };
        f.adjacencies = new Edge[]{
            new Edge(e, 36),
            new Edge(d, 50),
            new Edge(g, 14),
            new Edge(a, 24)
        };
        g.adjacencies = new Edge[]{
            new Edge(b, 15),
            new Edge(a, 19),
            new Edge(f, 14)
        };
        AstarSearch(a,d);

        List<Node> path = printPath(d);

        System.out.println("Path: " + path);
        System.out.println();

    }

    public static List<Node> printPath(Node target) {
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

    public static void AstarSearch(Node source, Node goal) {

        Set<Node> explored = new HashSet<Node>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {
            public int compare(Node i, Node j) {
                if (i.f_scores > j.f_scores) {
                    return 1;
                } else if (i.f_scores < j.f_scores) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        );

        source.g_scores = 0;
        queue.add(source);
        boolean found = false;
        while ((!queue.isEmpty()) && (!found)) {
            Node current = queue.poll();

            explored.add(current);

            if (current.value.equals(goal.value)) {
                found = true;
                break;
            }

            System.out.println("Current Node: " + current);

            for (Edge e : current.adjacencies) {
                Node child = e.target;
                double cost = e.cost;
                double temp_g_scores = current.g_scores + cost;
                double temp_f_scores = temp_g_scores + child.h_scores;
                System.out.println("f(n): " + current + "--->" + e.target + "\t" + temp_g_scores + "\t+\t" + child.h_scores + "\t=\t" + (temp_g_scores + child.h_scores));

                if ((explored.contains(child)) && (temp_f_scores >= child.f_scores)) {
                    continue;
                } else if ((!queue.contains(child)) || (temp_f_scores < child.f_scores)) {
                    child.parent = current;
                    child.g_scores = temp_g_scores;
                    child.f_scores = temp_f_scores;

                    if (queue.contains(child)) {
                        queue.remove(child);
                    }
                    queue.add(child);
                }
            }
        }
    }
}

class Node {

    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val, double hVal) {
        value = val;
        h_scores = hVal;
    }

    public String toString() {
        return value;
    }

}

class Edge {

    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal) {
        target = targetNode;
        cost = costVal;
    }
}
