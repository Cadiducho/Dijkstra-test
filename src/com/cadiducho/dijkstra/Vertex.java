package com.cadiducho.dijkstra;

public class Vertex implements Comparable<Vertex> {

    private Node to;
    private Integer distance;

    public Vertex(Node to, Integer distance) {
        super();
        this.to = to;
        this.distance = distance;
    }

    public Node getTo() {
        return to;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setNode(Node to) {
        this.to = to;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((distance == null) ? 0 : distance.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        if (distance == null) {
            if (other.distance != null) {
                return false;
            }
        } else if (!distance.equals(other.distance)) {
            return false;
        }
        if (to == null) {
            if (other.to != null) {
                return false;
            }
        } else if (!to.equals(other.to)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vertex {id=" + to + ", distance=" + distance + "}";
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance) {
            return -1;
        } else if (this.distance > o.distance) {
            return 1;
        } else {
            return this.getTo().getName().compareTo(o.getTo().getName());
        }
    }    
}
