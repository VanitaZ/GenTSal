import java.util.*;

class Population {
    public City[] cities;
    public ArrayList<int[]> paths;
    
    Random rng;
    
    public Population(City[] c) {
        this.cities = c;
        this.paths = new ArrayList<int[]>();
        this.rng = new Random();
    }
    
    public void init(int size) {
        for (int i = 0; i < size; i++) {
            this.paths.add(defaultPath());
        }
    }
    
    public void iterate() {
        int[] p, np;
        int len = this.paths.size();
        for (int i = 0; i < len; i++) {
            p = this.paths.get(i);
            np = p.clone();
            mutate(p);
            mutate(np);
            this.paths.add(np);
        }
        cull(len);
    }
    
    public void sort() {
        Collections.sort(this.paths, this.new PathCmp());
    }
    
    void cull(int size) {
        Collections.sort(this.paths, this.new PathCmp());
        if (size >= this.paths.size()) {
            return;
        }
        this.paths.subList(size-1, this.paths.size()).clear();
    }
    
    class PathCmp implements Comparator<int[]> {
        public int compare(int[] x, int[] y) {
            double s1 = pathScore(x);
            double s2 = pathScore(y);
            if (s1 > s2) { return 1; }
            if (s1 < s2) { return -1; }
            return 0;
        }
    }
    
    // lower score is better
    double pathScore(int[] path) {
        double score;
        City c1, c2;
        double dx, dy, dz;
        
        score = 0;
        for (int i = 0; i < path.length-1; i++) {
            c1 = this.cities[path[i]];
            c2 = this.cities[path[i+1]];
            dx = c2.x - c1.x;
            dy = c2.y - c1.y;
            dz = c2.z - c1.z;
            score += Math.sqrt(dx*dx + dy*dy + dz*dz);
        }
        return score;
    }
    
    int[] defaultPath() {
        int[] p = new int[this.cities.length];
        for (int i = 0; i < this.cities.length; i++) {
            p[i] = i;
        }
        return p;
    }
    
    void mutate(int[] path) {
        int t, r1, r2;
        r1 = rng.nextInt(path.length);
        do {
            r2 = this.rng.nextInt(path.length);
        } while (r2 == r1);
        t = path[r1];
        path[r1] = path[r2];
        path[r2] = t;
    }
}
