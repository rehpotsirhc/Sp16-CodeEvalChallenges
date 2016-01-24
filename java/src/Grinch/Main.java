package Grinch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chris on 1/3/2016.
 */
public class Main {


    /*


    This is a single-source shortest distance problem with directed edges

    Uses Dijkstra's algorithm

     */

    /*
    Even though the problem has integers for distance, this class will work with doubles to make it more flexible
     */
    private static class Node implements Comparable<Node> {

        // the total distance from the source(origin) node to this node
        // infinity if no path exists
        // zero if this is the source
        // while the algorithm progresses, this will hold partial distances
        double distanceToSource = Double.POSITIVE_INFINITY;

        boolean visited;


        //unique id of this node
        int id;

        public Node(int id) {
            this.id = id;
        }


        // holds the neighbors of this node that can be reached from this node and their distances from this node
        // (a directed edge from this node to each of these nodes exists)
        Map<Node, Double> neighbors = new HashMap<>();


        @Override
        public int compareTo(Node o) {
            if (this.distanceToSource < o.distanceToSource) return -1;
            else if (this.distanceToSource > o.distanceToSource) return 1;
            else return this.id - o.id; //this ensures a consistent ordering among nodes with the same distance from the origin
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return id == node.id;

        }

        @Override
        public int hashCode() {
            return id;
        }
    }


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //holds the nodes that we want to check next
        //if a node gets added to this set, there's a path from the source to it
        //it gets removed from this set once we have added all of its neighbors to this set
        SortedSet<Node>    discoveredNodes;
        Map<Integer, Node> graph;

        String   line;
        String[] mapOD;
        String[] mapParts;
        String[] pointParts;
        String[] od;
        int      originId;
        int      destId;
        while ((line = br.readLine()) != null) {


            discoveredNodes = new TreeSet<>();
            graph = new TreeMap<>();

            //parse input and populate the graph
            mapOD = line.split("\\|");
            mapParts = mapOD[0].trim().split(",");

            for (String s : mapParts) {
                pointParts = s.trim().split(" ");

                int nodeId1 = Integer.parseInt(pointParts[0]);
                int nodeId2 = Integer.parseInt(pointParts[1]);
                double distance = Double.parseDouble(pointParts[2]);

                Node existing1 = graph.get(nodeId1);
                Node existing2 = graph.get(nodeId2);

                if (existing1 == null) {
                    existing1 = new Node(nodeId1);
                    graph.put(nodeId1, existing1);
                }
                if (existing2 == null) {
                    existing2 = new Node(nodeId2);
                    graph.put(nodeId2, existing2);
                }

                // assuming the route is one-way from node 1 to node 2
                existing1.neighbors.put(existing2, distance);
                existing2.neighbors.put(existing1, distance);

            }
            od = mapOD[1].trim().split(" ");
            originId = Integer.parseInt(od[0]);
            destId = Integer.parseInt(od[1]);

            //do dijkstra's algorithm


            Node origin = graph.get(originId);
            Node dest = graph.get(destId);


            if (origin == null || dest == null) {
                System.out.println(false);
                continue;
            }


            if (origin.neighbors.containsKey(origin)) origin.distanceToSource = origin.neighbors.get(origin);
            else origin.distanceToSource = 0.0;

            //set the origin as visited
            discoveredNodes.add(origin);


            Node closest;

            //of the nodes discovered, continually retrieve the one closest to the origin
            //then check its neighbors to see if going through it is a faster path to any of these neighbors
            while (!discoveredNodes.isEmpty()) {
                closest = discoveredNodes.first();
                discoveredNodes.remove(closest);
                closest.visited = true;

                // check all of the adjacent nodes

                for (Node neighbor : closest.neighbors.keySet()) {
                    if (!neighbor.visited) {
                        //check to see if we've found a shorter way to get to the neighbor node
                        double weightToNeighborFromCurrent = closest.neighbors.get(neighbor);
                        double distanceFromSourceToCurrent = closest.distanceToSource;
                        double tenativeDistanceFromSourceToNeighbor = weightToNeighborFromCurrent + distanceFromSourceToCurrent;

                        double distanceFromSourceToNeighbor = neighbor.distanceToSource;

                        //if we find a shorter way, record it and add it to the discovered nodes
                        if (tenativeDistanceFromSourceToNeighbor < distanceFromSourceToNeighbor) {

                            discoveredNodes.remove(neighbor);

                            neighbor.distanceToSource = tenativeDistanceFromSourceToNeighbor;
                            discoveredNodes.add(neighbor);

                        }
                    }


                }
            }

            if (!Double.isInfinite(dest.distanceToSource)) {

                if (Math.floor(dest.distanceToSource) == dest.distanceToSource)
                    System.out.println((int) dest.distanceToSource);
                else
                    System.out.println(dest.distanceToSource);
            } else System.out.println(false);


        }


    }


}
