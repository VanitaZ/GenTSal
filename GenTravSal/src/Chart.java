
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Chart {

    private XYSeries bestSeries = new XYSeries("Best");
    private XYSeries averageSeries = new XYSeries("Average");
    private XYSeries worstSeries = new XYSeries("Worst");

    private JFreeChart chartXY;

    public Chart()
    {

    // Add the series to data set
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(bestSeries);
    dataset.addSeries(averageSeries);
    dataset.addSeries(worstSeries);

    // Generate the graph
    chartXY = ChartFactory.createXYLineChart(
            "Długość ścieżki", // Title
            "Iteracje", // x-axis Label
            "Przystosowanie", // y-axis Label
            dataset, // Dataset
            PlotOrientation.VERTICAL, // Plot Orientation
            true, // Show Legend
            true, // Use tooltips
            false // Configure chart to generate URLs?
    );

    // Graph window
    ChartFrame frameXY = new ChartFrame("Przystosowanie populacji",chartXY);
    frameXY.setVisible(true);
    frameXY.setSize(1000,700);
}

    public void addSeries (double iterations, double bestPath, double avgPath, double worstPath)
    {
        this.bestSeries.add(iterations,bestPath);
        this.averageSeries.add(iterations,avgPath);
        this.worstSeries.add(iterations,worstPath);
    }




}
