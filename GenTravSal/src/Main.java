import java.io.IOException;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        CityGraph graph = new CityGraph();
        graph.parse("<test>", new StringReader("0 -> 1 -> 2 -> 3 -> 0 -> 2 ; 1 -> 3"));
        
        /*graph.addEdge(new Road(5),city0, city1);
        graph.addEdge(new Road(3),city1, city2);
        graph.addEdge(new Road(6),city2, city3);
        graph.addEdge(new Road(2),city3, city0);
        graph.addEdge(new Road(7),city0, city2);
        graph.addEdge(new Road(3),city1, city3);*/
        ProgramMainWindow window = new ProgramMainWindow();
        window.setGraph(graph);
        System.out.println(graph.toString());

    }
}
