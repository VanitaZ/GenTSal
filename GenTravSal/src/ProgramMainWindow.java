import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import org.apache.commons.collections15.Transformer;

import javax.swing.*;
import java.awt.*;

public class ProgramMainWindow {
/*    JFrame mainWindow;
    CityGraph graph;
    Layout<Integer, Road> layout;
    VisualizationViewer<Integer, Road> vv;

    public ProgramMainWindow(){

        //Main JFrame
        mainWindow = new JFrame("Crossword generator");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setSize(700,700);
        mainWindow.setResizable(false);

        mainWindow.setVisible(true);
    }

    public JFrame getFrame(){
        return mainWindow;
    }

    public void setGraph(CityGraph graph){
        this.graph = graph;

        layout = new CircleLayout<Integer, Road>(graph);
        layout.setSize(new Dimension(650,650));

        vv = new VisualizationViewer<Integer, Road>(layout);
        vv.setPreferredSize(new Dimension(700,700));

        Transformer<Road, Paint> roadPainter = new Transformer<Road, Paint>(){
            @Override
            public Paint transform(Road road) {
                if(road.value <5){
                    return Color.GREEN;
                }
                if(road.value < 20){
                    return Color.YELLOW;
                }
                return Color.RED;
            }
        };

        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Road>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position.N);
        vv.getRenderContext().setLabelOffset(20);
        vv.getRenderContext().setEdgeDrawPaintTransformer(roadPainter);

        DefaultModalGraphMouse<Integer, Road> mouse = new DefaultModalGraphMouse<Integer, Road>();
        vv.setGraphMouse(mouse);

        JMenuBar menuBar = new JMenuBar();
        JMenu modeMenu = mouse.getModeMenu();
        modeMenu.setText("Mouse Mode");
        modeMenu.setIcon(null);
        modeMenu.setPreferredSize(new Dimension(80,20));
        menuBar.add(modeMenu);
        mainWindow.setJMenuBar(menuBar);

        mainWindow.getContentPane().add(vv);
        mainWindow.pack();
    }
*/
}
