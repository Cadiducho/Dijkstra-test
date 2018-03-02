package com.cadiducho.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Node {
    
    private final String name;
    private final List<Vertex> enlaces;
    
    public Node(String name) {
        this.name = name;
        this.enlaces = new ArrayList<>();
    }
    
    public void link(Node node, Integer distance) {
       this.getEnlaces().add(new Vertex(node, distance));
       node.getEnlaces().add(new Vertex(this, distance));
    }
    
    public String getName() {
        return name;
    }
    
    public List<Vertex> getEnlaces() {
        return enlaces;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
}
