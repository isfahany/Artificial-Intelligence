package utp;

public class Main {

    public static void main(String[] args) {
        Node city1 = new Node("Malang");
        Node city2 = new Node("Blitar");
        Node city3 = new Node("Jombang");
        Node city4 = new Node("Mojokerto");
        Node city5 = new Node("Pasuruan");
        Node city6 = new Node("Sidoarjo");
        Node city7 = new Node("Surubaya"); 
        city1.setChildNode(city2,city3,city4,city5);
        city2.setChildNode();
        city3.setChildNode(city4);
        city4.setChildNode(city5,city6);
        city5.setChildNode(city6,city3);
        city6.setChildNode(city5,city7);
        city7.setChildNode();
        Search test = new Search(city1,city7);
        test.doSearch();
    }
}
