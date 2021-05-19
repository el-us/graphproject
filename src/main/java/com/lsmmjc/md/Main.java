package com.lsmmjc.md;//package com.lsmmjc.md;
//
//import com.lsmmjc.md.mappers.GraphMapper;
//import com.lsmmjc.md.searchalgorithms.BreadthFirstSearch;
//import com.lsmmjc.md.searchalgorithms.DepthFirstSearch;
//import com.lsmmjc.md.graph.Graph;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Graph graph = new Graph(6);
//
//        graph.printAdjacencyMatrix();
//        graph.printIncidenceMatrix();
//        graph.printIncidenceList();
//
//        graph.addEdge(1, 1);
//        graph.printAdjacencyMatrix();
//        graph.printIncidenceMatrix();
//        graph.printIncidenceList();
//
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 5);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 3);
//        graph.printAdjacencyMatrix();
//        graph.printIncidenceMatrix();
//        graph.printIncidenceList();
//
//        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);
//        depthFirstSearch.runAlgorithm();
//
//        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
//        breadthFirstSearch.runAlgorithm();
//
//        GraphMapper.mapToGraphDTO(graph);
//
//
////        graph.wyszukajWglab();
//
//
///*        Lista lista = new Lista();
//        lista.dodajWezel(new Lista());
//        lista.dodajWezel(new Lista());
//        lista.dodajWezel(new Lista());
//        lista.wypiszListe();
//        lista.wezListe(1).dodajWezel(new Lista());*/
//
//    }
//}
