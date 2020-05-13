package Praktikum3;

import java.util.ArrayList;

public class Node {

    public String stationName;
    int leftChildCost;
    int rightChildCost;
    int middleChildCost;
    int middleChildCost2;
    Node leftChild;
    Node rightChild;
    Node middleChild;
    Node middleChild2;

    public Node(String stationName, int leftChildCost, Node firstChild, int rightChildCost, Node secondChild) {
        this.stationName = stationName;
        this.leftChildCost = leftChildCost;
        this.leftChild = firstChild;
        this.rightChildCost = rightChildCost;
        this.rightChild = secondChild;
    }

    public ArrayList<Node> getChildren() {
        ArrayList<Node> childNodes = new ArrayList<>();

        if (this.leftChild != null && leftChildCost < rightChildCost && leftChildCost < middleChildCost && leftChildCost < middleChildCost2) {
            leftChild.leftChildCost += this.leftChildCost;
            leftChild.rightChildCost += this.leftChildCost;
            leftChild.middleChildCost += this.leftChildCost;
            leftChild.middleChildCost2 += this.leftChildCost;
            childNodes.add(leftChild);
        } else if (this.rightChild != null && rightChildCost < leftChildCost && rightChildCost < middleChildCost && rightChildCost < middleChildCost2) {
            rightChild.leftChildCost += this.rightChildCost;
            rightChild.rightChildCost += this.rightChildCost;
            rightChild.middleChildCost += this.rightChildCost;
            rightChild.middleChildCost2 += this.rightChildCost;
            childNodes.add(rightChild);
        } else if (this.middleChild != null && middleChildCost < leftChildCost && middleChildCost < rightChildCost && middleChildCost < middleChildCost2) {
            middleChild.leftChildCost += this.middleChildCost;
            middleChild.rightChildCost += this.middleChildCost;
            middleChild.middleChildCost += this.middleChildCost;
            middleChild.middleChildCost2 += this.middleChildCost;
            childNodes.add(middleChild);
        } else if (this.middleChild2 != null && middleChildCost2 < leftChildCost && middleChildCost2 < rightChildCost && middleChildCost2 < middleChildCost) {
            middleChild2.leftChildCost += this.middleChildCost2;
            middleChild2.rightChildCost += this.middleChildCost2;
            middleChild2.middleChildCost += this.middleChildCost2;
            middleChild2.middleChildCost2 += this.middleChildCost2;
            childNodes.add(middleChild2);
        }
        return childNodes;
    }
    public boolean removeChild(Node n) {
        return false;
    }
}
