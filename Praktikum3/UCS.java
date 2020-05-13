/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum3;

/**
 *
 * @author rockwell
 */
public class UCS {

    public static void main(String[] args) {
        Node station1 = new Node("Westminster",0, null,0, null);
        Node station2 = new Node("Waterloo", 5 ,station1,0, null);
        Node station3 = new Node("Trafalgar Square",12, station1,7, station2);
        Node station4 = new Node("Canary Wharf",1, station2,4, station3);
        Node station5 = new Node("London Bridge",6, station4,11, station3);
        Node station6 = new Node("Tottenham Court Road",8, station5,2, station4);

        station1.leftChild = station2;
        station1.leftChildCost = 6;
        station1.rightChild = station3;
        station1.rightChildCost = 11;

        station2.middleChild = station3;
        station2.middleChildCost = 9;
        station2.rightChild = station4;
        station2.rightChildCost = 3;

        station3.middleChild = station4;
        station3.middleChildCost = 6;
        station3.middleChild2 = station5;
        station3.middleChildCost2 = 1;

        station4.middleChild = station5;
        station4.middleChildCost = 3;
        station4.middleChild2 = station6;
        station4.middleChildCost2 = 10;

        station5.middleChild = station6;
        station5.middleChildCost = 4;

        UniformCostSearch ucs = new UniformCostSearch(station2, station1);

        if (ucs.compute()) {
            System.out.print("Path Found!");
        }
    }
}
