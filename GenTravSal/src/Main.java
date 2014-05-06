import java.io.IOException;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) {
    	City[] cities = new City[1000];
    	for (int i = 0; i < 1000; i++) {
    		cities[i] = City.random();
    	}
    	
        Population pop = new Population(cities);
        pop.init(10);
        for (int i = 0; i <= 4000; i++) {
        	pop.iterate();
        	if (i % 1000 == 0) {
        		int[] arr = pop.paths.get(0);
        		System.out.printf("iteration %d: %f\n", i, pop.pathScore(arr));
        	}
        }
        
        /*int[] arr = pop.paths.get(0);
        for (int i : arr) {
        	System.out.println(i);
        }*/
    }
}
