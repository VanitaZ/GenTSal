import java.io.IOException;
import java.io.StringReader;
import java.util.Random;

public class GraphGenerator {
    static Random rnd;
    static CityGraph generate(int n) throws IOException{
        rnd = new Random();
        CityGraph graph = new CityGraph();
        String graphString = "0 ";
        for(int i=1;i<n;i++){
            graphString += "-> "+i+ ' ';
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i!=j) graphString += "; "+i+" -> "+j+ ' ';
            }
        }

        graph.parse("<test>", new StringReader(graphString));
        for(Road r : graph.getEdges()){
            r.value = rnd.nextInt(30)+1;
        }

        return graph;
    }
}
