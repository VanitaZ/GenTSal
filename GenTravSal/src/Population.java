import java.util.*;

class Population {
    public CityGraph graph;
    public ArrayList<Path> paths;
    
    public Population(CityGraph g) {
        this.graph = g;
        this.paths = new ArrayList<Path>();
    }
    
    public void init(int size) {
        // TODO: Make an initial batch of random paths.
    }
    
    public void cull(int size) {
        Collections.sort(this.paths, new Path.Cmp());
        if (size >= this.paths.size()) {
            return;
        }
        this.paths.subList(size-1, this.paths.size()).clear();  // I cry every time.
    }
}
