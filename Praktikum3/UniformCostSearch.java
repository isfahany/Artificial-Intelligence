/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UniformCostSearch {

    Node startNode;
    Node goalNode;

    public UniformCostSearch(Node start, Node goalNode) {
        this.startNode = start;
        this.goalNode = goalNode;
    }
    /*
    Ambil startingNode , Cabangkan, Cek nilai tiap cabang. Ambil Cabang Terkecil(x).
    x dicabangkan. Jumlahkan nilai dari x ke tiap cabang. Cek Nilai Tiap Child Cabang.
    Child Cabang(y) terkecil dicabangkan.
    Jika leaf goal <= dari leaf yang lain.
    print goal dan semua ancestornya hingga ke starting Node.
    
    
    ?????QUSTION?????
    apa yang harus di queue in?
    
    
    */

    public boolean compute() {

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        queue.add(this.startNode);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (current.equals(this.goalNode)) {
                explored.add(current);
                System.out.println("Explored Node : ");
                explored.stream().forEach((item) -> {
                    System.out.println(item.stationName + " ");
                });
                return true;
            } 
            else {
                if (current.getChildren().isEmpty()) {
                    return false;
                } else {
                    queue.addAll(current.getChildren());
                }
            }
            explored.add(current);
        }

        return false;
    }
}
