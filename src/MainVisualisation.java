import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Graph<String, Integer> g = new UndirectedSparseGraph<String, Integer>();
        g.addVertex("Vert1");
        g.addVertex("Vert2");
        g.addVertex("Vert3");

        g.addEdge(5,"Vert1", "Vert2");
        g.addEdge(2,"Vert2", "Vert3");
        g.addEdge(7,"Vert3", "Vert1");

        Layout<String, Integer> layout = new CircleLayout<String, Integer>(g);
        layout.setSize(new Dimension(300,300));

        VisualizationViewer<String, Integer> vv = new VisualizationViewer<String, Integer>(layout);
        vv.setPreferredSize(new Dimension(350,350));

        Transformer<String, Paint> vertexPaint = new Transformer<String, Paint>() {
            @Override
            public Paint transform(String s) {
                return Color.GREEN;
            }
        };

        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Integer>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.N);
        vv.getRenderContext().setLabelOffset(20);
        final Random random = new Random();
        Factory<String> vertexFactory = new Factory<String>() {
            @Override
            public String create() {
                return "E"+random.nextInt();
            }
        };
        Factory<Integer> edgeFactory = new Factory<Integer>() {
            @Override
            public Integer create() {
                return random.nextInt();
            }
        };
        EditingModalGraphMouse<String, Integer> gm = new EditingModalGraphMouse<String, Integer>(vv.getRenderContext(),vertexFactory,edgeFactory);
        vv.setGraphMouse(gm);

        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);

        JMenuBar menuBar = new JMenuBar();
        JMenu modeMenu = gm.getModeMenu();
        modeMenu.setText("Mouse Mode");
        modeMenu.setIcon(null);
        modeMenu.setPreferredSize(new Dimension(80,20));
        menuBar.add(modeMenu);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);

    }
}
