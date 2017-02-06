package chartsshowoff;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author jeppe
 */
public class LineChartController implements Initializable
{

    @FXML
    private Button button;
    @FXML
    private AnchorPane topPane;

    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
   

    @FXML
    private void handleButtonAction(ActionEvent event)
    {

        int year = 1960;
        xAxis.setLabel("Month Number");
        yAxis.setLabel("Rainfall");

        lineChart.setTitle("Rainfall per month");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("" + year);
        year++;

        Random r = new Random();
        for (int i = 1; i <= 12; i++)
        {

            series.getData().add(new XYChart.Data<>(i, r.nextInt()));
        }

//
//        XYChart.Series<Number, Number> series2015 = new XYChart.Series<>();
//        series2015.setName("2015");
//
//        series2015.getData().add(new XYChart.Data<>(1, 5));
//        series2015.getData().add(new XYChart.Data<>(2, 4));
//        series2015.getData().add(new XYChart.Data<>(3, 12));
//        series2015.getData().add(new XYChart.Data<>(4, 10));
//        series2015.getData().add(new XYChart.Data<>(5, 1));
//        series2015.getData().add(new XYChart.Data<>(6, 5));
//        series2015.getData().add(new XYChart.Data<>(7, 20));
//        series2015.getData().add(new XYChart.Data<>(8, 4));
//        series2015.getData().add(new XYChart.Data<>(9, 5));
//        series2015.getData().add(new XYChart.Data<>(10, 30));
//        series2015.getData().add(new XYChart.Data<>(11, 6));
//        series2015.getData().add(new XYChart.Data<>(12, 6));
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(12);
        xAxis.setAutoRanging(false);
        xAxis.setTickUnit(1);
        lineChart.getData().add(series);
        //lineChart.getData().add(series2015);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        topPane.getChildren().add(lineChart);
    }

}
