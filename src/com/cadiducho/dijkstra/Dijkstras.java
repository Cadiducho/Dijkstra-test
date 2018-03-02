package com.cadiducho.dijkstra;

public class Dijkstras {

    public static void main(String[] args) {
        funcion(111, 100000);
        
       Graph g = new Graph();
        
        //Creo los puntos, las ciudades
        Node madrid = new Node("Madrid");
        Node toledo = new Node("Toledo");
        Node zgz = new Node("Zaragoza");
        Node girona = new Node("Girona");
        Node ibiza = new Node("Ibiza");
        Node bcn = new Node("Barcelona");
        Node lleida = new Node("Lleida");
        Node tarra = new Node("Tarragona");
        Node mallorca = new Node("Mallorca");
        
        //Las uno mediante distancias
        madrid.link(toledo, 7);
        madrid.link(zgz, 8);
        zgz.link(lleida, 4);
        lleida.link(bcn, 5);
        lleida.link(tarra, 3);
        bcn.link(tarra, 2);
        bcn.link(girona, 3);
        bcn.link(mallorca, 5);
        mallorca.link(ibiza, 1);
        
        //Agrego los nodos al grafo
        g.addNode(madrid);
        g.addNode(toledo);
        g.addNode(zgz);
        g.addNode(girona);
        g.addNode(ibiza);
        g.addNode(lleida);
        g.addNode(bcn);
        g.addNode(tarra);
        g.addNode(mallorca);
        
        //Muestro resultados
        Path path = g.getShortestPath(ibiza, madrid);
        System.out.println(path);
        System.out.println("Distancia entre " + bcn + " y " + zgz + ": " + path.getDistanceBetween(bcn, zgz));
    }
}
