/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum5;

import java.util.ArrayList;
import java.util.List;

public class MainMap {

    /**
     * The problem we are solving.
     */
    public ColoringMap ColoringMap;

    /**
     * The initial assignment state.
     */
    public Assignment initial = Assignment.blank();

    /**
     * Setup from an input file.
     */
    public MainMap(int banyakWarna) {
        initial = Assignment.blank();
        ColoringMap = new ColoringMap(banyakWarna);
    }

    public static void main(String[] args) {
        ArrayList<String> listWarna = new ArrayList<String>();
        listWarna.add("\tRed");
        listWarna.add("\tGreen");
        listWarna.add("\tBlue");

        MainMap m = new MainMap(listWarna.size());

        Assignment solution = m.solve();

        if (solution == null) {
            System.out.println("Failed to find a solution!");
            System.exit(1);
        }

        System.out.println("Solution:");
        List<Variable> vars = m.ColoringMap.variables();
        
        for (Variable v : vars) {
            System.out.println(v.description() + "=" + listWarna.get(((Integer) solution.getValue(v)) - 1));
        }

    }

    public Assignment solve() {
        MRVBacktrack solve = new MRVBacktrack(ColoringMap, initial);
        return solve.solve();
    }
}
