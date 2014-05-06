public class City {
    public double x, y, z;

    public City(double ix, double iy, double iz) {
        x = ix; y = iy; z = iz;
    }
    
    public static City random() {
    	double x, y, z;
    	x = Math.random();
    	y = Math.random();
    	z = Math.random() * 0.1;
    	return new City(x, y, z);
    }
}
