import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.Viewer;

public class GraphExplorer {

    Graph graph = new SingleGraph("Graf");

    public GraphExplorer() {

        graph.addAttribute("ui.stylesheet", styleSheet);
        graph.setAutoCreate(true);
        graph.setStrict(false);

        Viewer viewer = graph.display();
        viewer.disableAutoLayout();

    }

    public void createGraph (City[] cities, Population pop, Integer max)
    {
        addNodesToGraph(cities,max);
        addEdgesToGraph(pop,max);
    }

    public void addNodesToGraph (City[] cities, Integer max)
    {
        for(Integer i=0; i<max; i++) {
            addXYNodeToGraph(i,cities[i].x,cities[i].y);
        }
    }

    public void addEdgesToGraph (Population pop, Integer max)
    {
        for (Integer i = 0; i < max-1; i++) {
            addEdge(pop.paths.get(0)[i],pop.paths.get(0)[i+1]);
        }
        addEdge(pop.paths.get(0)[9],pop.paths.get(0)[0]);
    }

    private void addXYNodeToGraph (Integer id, double x, double y)
    {
        Node node = graph.addNode(id.toString());
        node.setAttribute("xy",x,y);
        node.addAttribute("ui.label", node.getId());
    }

    private void addEdge (Integer idA, Integer idB)
    {
        graph.addEdge("from"+idA.toString(),idA.toString(),idB.toString());
    }

    protected String styleSheet =
            "node {" +
                    "   fill-color: red;" +
                    "}" +
            "edge {" +
                    "   fill-color: blue;" +
                    "}";
}