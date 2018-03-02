package com.cadiducho.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Path {
    
    private final LinkedHashMap<Node, Integer> ruta;
    private int maxDistance = -1;
    private final Node from;
    private final Node to;
    
    public Path(Node from, Node to) {
        this.from = from;
        this.to = to;
        this.ruta = new LinkedHashMap<>();
    }
    
    public void addStep(Node node, Integer distance) {
        System.out.println("Agregando " + node + " a " + distance);
        if (ruta.isEmpty()) {
            maxDistance = distance;
        }
        ruta.put(node, distance);
    }
    
    public Integer getTotalDistance() {
        return maxDistance;
    }
    
    public Integer getDistanceFrom(Node origin) {
        return ruta.get(origin);
    }
    
    public Integer getDistanceBetween(Node origin, Node destination) {
        return Math.abs(ruta.get(origin) - ruta.get(destination));
    }
    
    public ArrayList<Node> getOrderedRoute() {
        ArrayList<Node> nodos = new ArrayList(ruta.keySet());
        Collections.reverse(nodos);
        return nodos;
    }
    
    @Override
    public String toString() {
        String str = "Desde " + from + " hasta " + to;
       
        str += "\nRuta: ";
        str = getOrderedRoute().stream().map((nodo) -> nodo.getName() + ", ").reduce(str, String::concat);
        str += "\nDistancia total: " + getTotalDistance();
        
        return str;
    }
    
}
