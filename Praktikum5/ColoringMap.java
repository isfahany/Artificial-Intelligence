package Praktikum5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ColoringMap extends CSPProblem {

    int boardSize = 8;

    // List of variable tiles
    List<Variable> tiles;

    // List of all constraints
    List<Constraint> constraints;

    // List of tile domain
    List<Object> domain = new LinkedList<Object>();

    List<String> warna = new ArrayList<String>();

    public List<Variable> variables() {
        if (tiles.size() == 0) {
            tiles.add(new MapTile(0, "Aceh            \t"));
            tiles.add(new MapTile(1, "Sumatera Utara  \t"));
            tiles.add(new MapTile(2, "Riau            \t"));
            tiles.add(new MapTile(3, "Sumatera Barat  \t"));
            tiles.add(new MapTile(4, "Jambi           \t"));
            tiles.add(new MapTile(5, "Bengkulu        \t"));
            tiles.add(new MapTile(6, "Sumatera Selatan\t"));
            tiles.add(new MapTile(7, "Lampung         \t"));
        }
        return tiles;
    }

    /**
     * Returns a list of constraints associated with the problem.
     */
    public List<Constraint> constraints() {
        if (constraints.size() == 0) {
            // Add the row constraints
            AllDiff constr;

            //ACEH->Sumatera Utara
            constr = new AllDiff();
            constr.variables.add(tiles.get(0));
            constr.variables.add(tiles.get(1));
            constraints.add(constr);

            //Sumatera Utara->Riau
            constr = new AllDiff();
            constr.variables.add(tiles.get(1));
            constr.variables.add(tiles.get(2));
            constraints.add(constr);

            //Sumatera Utara->Sumatera Barat
            constr = new AllDiff();
            constr.variables.add(tiles.get(1));
            constr.variables.add(tiles.get(3));
            constraints.add(constr);

            //Riau->Sumatera Barat
            constr = new AllDiff();
            constr.variables.add(tiles.get(2));
            constr.variables.add(tiles.get(3));
            constraints.add(constr);

            //Riau->Jambi
            constr = new AllDiff();
            constr.variables.add(tiles.get(2));
            constr.variables.add(tiles.get(4));
            constraints.add(constr);

            //Sumatera Barat->Jambi
            constr = new AllDiff();
            constr.variables.add(tiles.get(3));
            constr.variables.add(tiles.get(4));
            constraints.add(constr);

            //Sumatera Barat->Bengkulu
            constr = new AllDiff();
            constr.variables.add(tiles.get(3));
            constr.variables.add(tiles.get(5));
            constraints.add(constr);

            //Jambi->Sumatera Selatan
            constr = new AllDiff();
            constr.variables.add(tiles.get(4));
            constr.variables.add(tiles.get(6));
            constraints.add(constr);

            //Bengkulu->Sumatera Selatan
            constr = new AllDiff();
            constr.variables.add(tiles.get(5));
            constr.variables.add(tiles.get(6));
            constraints.add(constr);

            //Sumatera Selatan->Lampung
            constr = new AllDiff();
            constr.variables.add(tiles.get(6));
            constr.variables.add(tiles.get(7));
            constraints.add(constr);

        }
        return constraints;
    }

    /**
     * Implements each tile as a variable in a CSP
     */
    public class MapTile extends Variable {

        public int tileNumber;
        public String nama;

        public MapTile(int i, String nama) {
            tileNumber = i;
            this.nama = nama;
        }

        public String description() {
            return nama;
        }

        public List<Object> domain() {
            return domain;
        }
    }

    public ColoringMap(int size) {
        // Generate everything
        boardSize = size;
        for (int i = 1; i <= boardSize; i++) {
            domain.add(i);
        }
        tiles = new ArrayList<Variable>();
        constraints = new ArrayList<Constraint>();
        variables();
        constraints();
    }

    public class AllDiff extends Constraint {

        public List<Variable> variables = new LinkedList<Variable>();

        public boolean satisfied(Assignment asign) {
            boolean[] seen = new boolean[boardSize + 1];
            for (Variable v : variables) {
                Integer val = (Integer) asign.getValue(v);
                if (val == null || seen[val]) {
                    return false;
                }
                seen[val] = true;

            }
            return true;
        }
        
        public boolean consistent(Assignment asign) {
            boolean[] seen = new boolean[boardSize + 1];
            boolean[] avail = new boolean[boardSize + 1];
            int constraintDomain = 0;

            for (Variable v : variables) {
                // Check if this variable adds to the domain of the constraint
                for (Object val : domainValues(asign, v)) {
                    if (!avail[(Integer) val]) {
                        constraintDomain++;
                        avail[(Integer) val] = true;

                    }
                }

                // Check for a duplicate value
                Integer val = (Integer) asign.getValue(v);
                if (val != null) {
                    if (seen[val]) {
                        return false;
                    }
                    seen[val] = true;
                }
            }

            // Check if there are not enough values
            if (variables.size() > constraintDomain) {
                return false;
            }
            return true;
        }

        public List<Variable> reliesOn() {
            return variables;
        }

        public String description() {
            String desc = "Processing... ";
            for (Variable v : variables) {
                desc += "\t" + v.description();
            }
            desc += "\n";
            return desc;
        }
    }
}
