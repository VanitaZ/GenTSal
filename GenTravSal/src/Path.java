import java.util.*;

class Path {
    public CityGraph graph;
    public ArrayList<Integer> nodes;
    
    public Path(CityGraph g) {
        this.graph = g;
        this.nodes = new ArrayList<Integer>();
    }
    
    public static Path fromString(CityGraph g, String p) {
        Path thePath = new Path(g);
        for (String s : p.split("[ \t\n]*->[ \t\n]*")) {
            thePath.append(Integer.parseInt(s));
        }
        return thePath;
    }

   public static class Cmp implements Comparator<Path> {
        public int compare(Path x, Path y) {
            double v1, v2;
            v1 = x.score();
            v2 = y.score();
            if (v1 > v2) { return 1; }
            if (v1 < v2) { return -1; }
            return 0;
        }
    }
    
    public void append(int n) {
        if (!graph.containsVertex(n)) {
            String err = String.format("can't append %d to path: no such node in graph", n);
            throw new RuntimeException(err);
        }
        
        if (this.nodes.size() > 0) {
            int c = this.nodes.get(this.nodes.size()-1);
            Road r = this.graph.findEdge(c, n);
            if (r == null) {
                String err = String.format("broken path: %d -> %d", c, n);
                throw new RuntimeException(err);
            }
        }
        this.nodes.add(n);
    }
    
    public double score() {
        if (nodes.size() == 0) { return 0; }
        if (nodes.size() == 1) {
            return this.graph.cities.get(this.nodes.get(0)).value;
        }
        
        double val = 0;
        City c1, c2;
        Road r;
        c1 = this.graph.cities.get(this.nodes.get(0));
        for (int i = 1; i < this.nodes.size(); i++) {
            c2 = this.graph.cities.get(this.nodes.get(i));
            val += c2.value;
            r = this.graph.findEdge(c1.id, c2.id);
            val += r.value;
        }
        
        return val;
    }
}
