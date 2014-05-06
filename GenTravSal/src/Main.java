import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    	City[] cities = new City[10];
    	for (int i = 0; i < 10; i++) {
    		cities[i] = City.random();
    	}
    	
        Population pop = new Population(cities);
        pop.init(20);
        pop.iterate();
        
        int[] arr = pop.paths.get(0);
        for (int i : arr) {
        	System.out.println(i);
        }
    }
}
