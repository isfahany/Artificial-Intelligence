package UNIFORM;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UniformCostSearchAlgo {
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");
        Node K = new Node("K");
        Node L = new Node("L");
        Node M = new Node("M");
        Node N = new Node("N");
        Node O = new Node("O");
        Node P = new Node("P");
        Node Q = new Node("Q");
        Node R = new Node("R");
        Node S = new Node("S");
        Node T = new Node("T");
        Node U = new Node("U");
        Node V = new Node("V");
        Node X = new Node("X");

        A.adjacencies = new Edge[]{
            new Edge(B, 145),
            new Edge(V, 167),
            new Edge(X, 55),
            new Edge(I, 148)
        };

        B.adjacencies = new Edge[]{
            new Edge(A, 145),
            new Edge(C, 98)
        };

        C.adjacencies = new Edge[]{
            new Edge(B, 98),
            new Edge(D, 212)
        };

        D.adjacencies = new Edge[]{
            new Edge(C, 212),
            new Edge(K, 102),
            new Edge(E, 102)
        };
        E.adjacencies = new Edge[]{
            new Edge(D, 102),
            new Edge(L, 95),
            new Edge(M, 73),
            new Edge(N, 97),
            new Edge(F, 152)
        };

        F.adjacencies = new Edge[]{
            new Edge(E, 152),
            new Edge(G, 83),};

        G.adjacencies = new Edge[]{
            new Edge(F, 83),
            new Edge(H, 75),};

        H.adjacencies = new Edge[]{
            new Edge(G, 75),};

        I.adjacencies = new Edge[]{
            new Edge(A, 148),
            new Edge(J, 75),
            new Edge(Q, 25)
        };

        J.adjacencies = new Edge[]{
            new Edge(I, 75),
            new Edge(K, 95)
        };

        K.adjacencies = new Edge[]{
            new Edge(J, 95),
            new Edge(D, 102)
        };

        L.adjacencies = new Edge[]{
            new Edge(E, 95),};

        M.adjacencies = new Edge[]{
            new Edge(E, 73),};

        N.adjacencies = new Edge[]{
            new Edge(E, 97),
            new Edge(P, 65),
            new Edge(O, 25)
        };
        O.adjacencies = new Edge[]{
            new Edge(N, 25)
        };
        P.adjacencies = new Edge[]{
            new Edge(N, 65)
        };
        Q.adjacencies = new Edge[]{
            new Edge(I, 25),
            new Edge(X, 30)
        };
        R.adjacencies = new Edge[]{
            new Edge(X, 57),
            new Edge(S, 93)
        };
        S.adjacencies = new Edge[]{
            new Edge(R, 93),
            new Edge(T, 112)
        };
        T.adjacencies = new Edge[]{
            new Edge(V, 25),
            new Edge(U, 75),
            new Edge(S, 112)
        };
        U.adjacencies = new Edge[]{
            new Edge(T, 75),
            new Edge(V, 85)
        };
        V.adjacencies = new Edge[]{
            new Edge(U, 85),
            new Edge(T, 25),
            new Edge(A, 167)
        };
        X.adjacencies = new Edge[]{
            new Edge(R, 57),
            new Edge(A, 55),
            new Edge(Q, 30)
        };

        Node start = null;
        Node end = null;
        System.out.print("INPUT STARTING POINT: ");
        String a = in.nextLine();
        System.out.print("INPUT GOAL POINT : ");
        String b = in.nextLine();

        switch (a) {
            case "T":
                start = T;
                break;
            case "U":
                start = U;
                break;
            case "S":
                start = S;
                break;
            case "V":
                start = V;
                break;
            case "R":
                start = R;
                break;
            case "A":
                start = A;
                break;
            case "X":
                start = X;
                break;
            case "Q":
                start = Q;
                break;
            case "I":
                start = T;
                break;
            case "B":
                start = B;
                break;
            case "C":
                start = C;
                break;
            case "D":
                start = D;
                break;
            case "J":
                start = J;
                break;
            case "K":
                start = K;
                break;
            case "E":
                start = E;
                break;
            case "M":
                start = M;
                break;
            case "L":
                start = L;
                break;
            case "N":
                start = N;
                break;
            case "P":
                start = P;
                break;
            case "O":
                start = O;
                break;
            case "F":
                start = F;
                break;
            case "G":
                start = G;
                break;
            case "H":
                start = H;
                break;
            default:
                return;
        }
        switch (b) {
            case "T":
                end = T;
                break;
            case "U":
                end = U;
                break;
            case "S":
                end = S;
                break;
            case "V":
                end = B;
                break;
            case "R":
                end = R;
                break;
            case "A":
                end = A;
                break;
            case "X":
                end = X;
                break;
            case "Q":
                end = Q;
                break;
            case "I":
                end = T;
                break;
            case "B":
                end = B;
                break;
            case "C":
                end = C;
                break;
            case "D":
                end = D;
                break;
            case "J":
                end = J;
                break;
            case "K":
                end = K;
                break;
            case "E":
                end = E;
                break;
            case "M":
                end = M;
                break;
            case "L":
                end = L;
                break;
            case "N":
                end = N;
                break;
            case "P":
                end = P;
                break;
            case "O":
                end = O;
                break;
            case "F":
                end = F;
                break;
            case "G":
                end = G;
                break;
            case "H":
                end = H;
                break;
            default:
                return;
        }
        UniformCostSearch(start, end);
        List<Node> path = printPath(end);
        System.out.println("Path: " + path);
        System.out.println();
    }

    public static void UniformCostSearch(Node source, Node goal) {
        source.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {

            public int compare(Node i, Node j) {
                if (i.pathCost > j.pathCost) {
                    return 1;
                } else if (i.pathCost < j.pathCost) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        );

        queue.add(source);
        Set<Node> explored = new HashSet<Node>();
        boolean found = false;
        do {

            Node current = queue.poll();
            explored.add(current);

            if (current.value.equals(goal.value)) {
                found = true;

            }

            for (Edge e : current.adjacencies) {
                Node child = e.target;
                double cost = e.cost;
                child.pathCost = current.pathCost + cost;

                if (!explored.contains(child) && !queue.contains(child)) {

                    child.parent = current;
                    queue.add(child);

                    System.out.println(child);
                    System.out.println(queue);
                    System.out.println();
                    System.out.println(child.pathCost);

                } else if ((queue.contains(child)) && (child.pathCost > current.pathCost)) {
                    child.parent = current;
                    queue.remove(child);
                    queue.add(child);
                }
            }
        } while (!queue.isEmpty());
    }

    public static List<Node> printPath(Node target) {
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }
}

class Node {

    public final String value;
    public double pathCost;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val) {
        value = val;
    }

    public String toString() {
        return value;
    }
}

class Edge {

    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal) {
        cost = costVal;
        target = targetNode;
    }
}
