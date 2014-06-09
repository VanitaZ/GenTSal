
public class Main {
    public static void main(String[] args) {
        GraphExplorer gr = new GraphExplorer();
    	City[] cities = new City[10];
    	for (Integer i = 0; i < 10; i++) {
    		cities[i] = City.random();
    	}

        //Chart ch = new Chart();

        Population pop = new Population(cities);
        pop.init(10);
        for (int i = 0; i <= 4000; i++) {
        	pop.iterate();
            //if (i % 100 == 0)
            //ch.addSeries(i,pop.pathScore(pop.paths.get(0)),pop.pathScore(pop.paths.get(4)),pop.pathScore(pop.paths.get(9)));
        }


        gr.createGraph(cities,pop,10);

        /*int[] arr = pop.paths.get(0);
        for (int i : arr) {
        	System.out.println(i);
        }*/
    }
}
