import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import javax.swing.*;
import java.awt.*;

public class ProgramMainWindow {
    JFrame mainWindow;
    CityGraph graph;
    Layout<City, Road> layout;
    VisualizationViewer<City, Road> vv;

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

        layout = new CircleLayout<City, Road>(graph);
        layout.setSize(new Dimension(650,650));

        vv = new VisualizationViewer<City, Road>(layout);
        vv.setPreferredSize(new Dimension(700,700));

        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<City>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Road>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position.N);
        vv.getRenderContext().setLabelOffset(20);

        mainWindow.getContentPane().add(vv);
        mainWindow.pack();
    }

}
