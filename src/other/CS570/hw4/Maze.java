package other.CS570.hw4;

import java.util.Stack;
import java.util.*;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 * @author Songhan Yu
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
        // COMPLETE HERE FOR PROBLEM 1
        // If the current cell being analyzed falls outside the grid, then false should be returned since there is no possible path through that cell.
        if (x < 0 || y < 0 || x > maze.getNCols()-1 || y > maze.getNCols()-1)
            return false;
        // If the current cell being analyzed does not have NON_BACKGROUND, then false should be returned since there is no possible path through that cell.
        else if (!maze.getColor(x, y).equals(NON_BACKGROUND)) {
            return false;
        }
        // If the current cell being analyzed is the exit cell,
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() -1) {
            // painter color PATH
            maze.recolor(x,y,PATH);
            return true;
        }
        // Otherwise the current cell may be assumed to be part of the path
        else {
            maze.recolor(x,y,PATH);
            // other.CS570.lai.Recursion: Each of the four neighboring cells must be explored to see if they too are part of a path
            if (findMazePath(x-1,y) || findMazePath(x,y-1)  || findMazePath(x+1,y) || findMazePath(x, y+1) )
                // If the result of exploring at least one of the neighbors is successful, then a path has been found.
                return true;
            else {
                // Otherwise, the cell is not part of a path: it is a dead end. Hence it must be marked so that it is not visited again.
                // For that it must be colored to color TEMPORARY
                maze.recolor(x,y,TEMPORARY);
                return false;
            }
        }
    }

    // ADD METHOD FOR PROBLEM 2 HERE
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
        Stack<PairInt> trace = new Stack<>();
        findMazePathStackBased(0, 0, result, trace);
        return result;
    }

    // helper function for PROBLEM 2
    // (x,y) are the coordinates currently being visited
    // result is the list of successful paths recorded up to now
    // trace is the trace of the current path being explored
    private void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
        // If the current cell being analyzed falls outside the grid, then false should be returned since there is no possible path through that cell.
        if (x < 0 || y < 0 || x > maze.getNCols()-1 || y > maze.getNCols()-1)
            return;
        // If the current cell being analyzed does not have NON_BACKGROUND, then false should be returned since there is no possible path through that cell.
        else if (!maze.getColor(x, y).equals(NON_BACKGROUND)) {
            return;
        }
        // If the current cell being analyzed is the exit cell,
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            // If the current cell being analyzed is the exit cell
            trace.push(new PairInt(x, y));
            ArrayList<PairInt> path = new ArrayList<>(trace);
            result.add(path);
            trace.pop();
            maze.recolor(x, y, NON_BACKGROUND);
            return;
        }
        else {
            trace.push(new PairInt(x, y));
            maze.recolor(x, y, PATH);
            findMazePathStackBased(x + 1, y, result, trace);
            findMazePathStackBased(x - 1, y, result, trace);
            findMazePathStackBased(x, y + 1, result, trace);
            findMazePathStackBased(x, y - 1, result, trace);
            maze.recolor(x, y, NON_BACKGROUND);
            trace.pop();
            return;
        }
    }

    // ADD METHOD FOR PROBLEM 3 HERE
    public ArrayList<PairInt> findMazePathMin(int x, int y) {
        // find all path
        ArrayList<ArrayList<PairInt>> paths = findAllMazePaths(x, y);
        int[] cnt = new int[paths.size()];
        int idxPathMin = 0;

        // store path size
        int i = 0;
        while (i < paths.size()) {
            cnt[i] = paths.get(i).size();
            i ++;
        }

        // compare the size of path from 1st element
        int sizePathMin = cnt[0];

        // find the index of Path Min
        int j=0;
        while (j < cnt.length) {
            if (sizePathMin > cnt[j]) {
                sizePathMin = cnt[j];  // store smaller size of path
                idxPathMin = j;  // store index of the shortest path
            }
            j++;
        }

        // find other.CS570.Maze Path Min through index
        return paths.get(idxPathMin);
    }

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
