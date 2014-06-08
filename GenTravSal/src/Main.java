
public class Main {
    public static void main(String[] args) {
    	City[] cities = new City[1000];
    	for (int i = 0; i < 1000; i++) {
    		cities[i] = City.random();
    	}

        Chart ch = new Chart();

        Population pop = new Population(cities);
        pop.init(10);
        for (int i = 0; i <= 4000; i++) {
        	pop.iterate();
            if (i % 100 == 0)
            ch.addSeries(i,pop.pathScore(pop.paths.get(0))-5,pop.pathScore(pop.paths.get(4)),pop.pathScore(pop.paths.get(9))+5);
        }


        
        /*int[] arr = pop.paths.get(0);
        for (int i : arr) {
        	System.out.println(i);
        }*/
    }
}
