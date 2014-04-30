import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class Main {
    public static void main(String[] args){
        Graph<City, Road> graph = new UndirectedSparseGraph<City, Road>();

        City city0 = new City(0);
        City city1 = new City(1);
        City city2 = new City(2);
        City city3 = new City(3);

        graph.addVertex(city0);
        graph.addVertex(city1);
        graph.addVertex(city2);
        graph.addVertex(city3);

        graph.addEdge(new Road(5),city0, city1);
        graph.addEdge(new Road(3),city1, city2);
        graph.addEdge(new Road(6),city2, city3);
        graph.addEdge(new Road(2),city3, city0);
        graph.addEdge(new Road(7),city0, city2);
        graph.addEdge(new Road(3),city1, city3);

        System.out.println(graph.toString());

        Walker w = new Walker(graph);
        w.test(0);

    }
}
