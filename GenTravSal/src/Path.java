import java.util.*;

class Path {
   public CityGraph graph;
   public ArrayList<Integer> nodes;
   
   public Path(CityGraph g, String p) {
      this.graph = g;
      this.nodes = new ArrayList<Integer>();
      for (String s : p.split("[ \t\n]*->[ \t\n]*")) {
         this.append(Integer.parseInt(s));
      }
   }
   
   public void append(int n) {
   City c = new City(n);
      if (!graph.containsVertex(c)) {
         String err = String.format("can't append %d to path: no such node in graph", n);
         throw new RuntimeException(err);
      }
      this.nodes.add(n);
   }
   
   public void render() {
   }
}
