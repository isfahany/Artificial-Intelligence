package utp;

import java.util.*;

public class Search {

    private Node startNode;
    private Node goalNode;

    public Search(Node start, Node goalNode) {
        startNode = start;
        this.goalNode = goalNode;
    }

    public boolean doSearch() {
        if (this.startNode.equals(goalNode)) {
            System.out.println("Start Node = Goal Node");
        }
        Stack<Node> stack = new Stack<>();
        stack.add(this.startNode);
        System.out.println("Node hasil penelusuran : ");
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.cityName);
            if (current.equals(this.goalNode)) {
                return true;
            } else {
                if (current.getChildren().isEmpty()) {
                    return false;
                } else {
                    stack.addAll(current.getChildren());
                }
            }
        }
        return false;
    }
}
