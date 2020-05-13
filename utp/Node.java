package utp;

import java.util.ArrayList;
import java.util.Collections;

public class Node {

    public String cityName;
    private ArrayList<Node> childNodes;

    public Node(String cityName, Node... child) {
        this.cityName = cityName;
        childNodes = new ArrayList<>();
        Collections.addAll(childNodes, child);
    }

    public ArrayList<Node> getChildren() {
        return childNodes;
    }

    public void setChildNode(Node... child) {
        childNodes = new ArrayList<>();
        Collections.addAll(childNodes, child);
    }
}
