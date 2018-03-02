package com.cadiducho.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Graph {

    private final Map<Node, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addNode(Node nodo) {
        vertices.put(nodo, nodo.getEnlaces());
    }

    public Path getShortestPath(Node start, Node finish) {
        long startTime = System.currentTimeMillis();
        final Map<Node, Integer> distances = new HashMap<>();
        final Map<Node, Vertex> previous = new HashMap<>();
        PriorityQueue<Vertex> nodes = new PriorityQueue<>();

        for (Node vertex : vertices.keySet()) {
            if (Objects.equals(vertex, start)) {
                distances.put(vertex, 0);
                nodes.add(new Vertex(vertex, 0));
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
                nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
            }
            previous.put(vertex, null);
        }

        while (!nodes.isEmpty()) {
            Vertex smallest = nodes.poll();
            if (Objects.equals(smallest.getTo(), finish)) {
                final Path path = new Path(start, finish);
                while (previous.get(smallest.getTo()) != null) {
                    path.addStep(smallest.getTo(), smallest.getDistance());
                    smallest = previous.get(smallest.getTo());
                }
                long endTime   = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                System.out.println(totalTime + "ms");
                return path;
            }

            if (distances.get(smallest.getTo()) == Integer.MAX_VALUE) {
                break;
            }

            for (Vertex neighbor : vertices.get(smallest.getTo())) {
                Integer alt = distances.get(smallest.getTo()) + neighbor.getDistance();
                if (alt < distances.get(neighbor.getTo())) {
                    distances.put(neighbor.getTo(), alt);
                    previous.put(neighbor.getTo(), smallest);

                    for (Vertex n : nodes) {
                        if (Objects.equals(n.getTo(), neighbor.getTo())) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break;
                        }
                    }
                }
            }
        }
        return new Path(start, finish);
    }

}
