/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.common.DataAccess.ItemSummaryDataAccess;
import com.afritrend.common.Model.itemAmount;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class HomeController implements Initializable {

    @FXML
    AnchorPane MainWindowStage;
    
    @FXML
    AnchorPane AnchChartArea;
    
    @FXML
    ComboBox cbVisualization;
    
    @FXML
    TextArea TxtStatistics;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {            
            cbVisualization.getItems().clear();
            cbVisualization.getItems().addAll("Chart","Graph","HorizontalGraph");
            
            PieChart piechart = new PieChart();
            
            List<itemAmount> itemlist = new ArrayList<>();
            
            ItemSummaryDataAccess itemsummarydao = new ItemSummaryDataAccess();
            itemlist = itemsummarydao.GetItems();            
            
            ObservableList<PieChart.Data> Items = FXCollections.observableArrayList();
            
            Iterator<itemAmount> itemit = itemlist.iterator();
            while(itemit.hasNext())
            {
                itemAmount item = new itemAmount();   
                item = itemit.next();
                Items.add(new PieChart.Data(item.getItemName(), item.getAmount()));
            }
            piechart.setData(Items);
            piechart.setTitle("Drugs");            
            
            AnchChartArea.getChildren().add(piechart);                    
        }
        catch(Exception e)
        {
            
        }  
    }   
    
    public void ShowVisualization(ActionEvent event)
    {
        String visualisationtype = String.valueOf(cbVisualization.getValue());
        if(visualisationtype.equals("Chart"))
        {
            ShowChart();
        }
        if(visualisationtype.equals("Graph"))
        {
            ShowGraph();
        }
        if(visualisationtype.equals("HorizontalGraph"))
        {
            HorizontalBarChart();
        }
    }
    
    public void ShowChart()
    {
        try
        {                         
            PieChart piechart = new PieChart();
            
            List<itemAmount> itemlist = new ArrayList<>();
            
            ItemSummaryDataAccess itemsummarydao = new ItemSummaryDataAccess();
            itemlist = itemsummarydao.GetItems();            
            
            ObservableList<PieChart.Data> Items = FXCollections.observableArrayList();
            
            Iterator<itemAmount> itemit = itemlist.iterator();
            while(itemit.hasNext())
            {
                itemAmount item = new itemAmount();   
                item = itemit.next();
                Items.add(new PieChart.Data(item.getItemName(), item.getAmount()));
            }
            piechart.setData(Items);
            piechart.setTitle("Drug Classes");            
            
            AnchChartArea.getChildren().clear();
            AnchChartArea.getChildren().add(piechart);                    
        }
        catch(Exception e)
        {
            
        }          
    }
    
    public void ShowGraph()
    {
        try
        {                        
            NumberAxis lineYAxis = new NumberAxis(0,100,10);
            CategoryAxis lineXAxis = new CategoryAxis();

            lineYAxis.setLabel("Amount");
            lineXAxis.setLabel("Drug");              
            
            final BarChart<Number, String> barChart = new BarChart<Number, String>(lineYAxis, lineXAxis);
            
//            BarChart barChart = new BarChart(lineXAxis,lineYAxis);         
            
            XYChart.Series series1 = new XYChart.Series();
            
            series1.setName("Drugs Level Amount");
            series1.getData().add(new XYChart.Data(2, "Parapain"));
            series1.getData().add(new XYChart.Data(20, "Panado"));
            series1.getData().add(new XYChart.Data(10, "Aspirin"));            
            barChart.getData().add(series1);
            
            AnchChartArea.getChildren().clear();            
            AnchChartArea.getChildren().add(barChart);                    
        }
        catch(Exception e)
        {
            
        }          
    }  
    
    public void HorizontalBarChart()
    {
        final  String itemA = "Panado";
        final  String itemB = "Aspirin";
        final  String itemC = "Parapain";        
        
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        bc.setTitle("Drugs Levels");
        xAxis.setLabel("Level");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Drug");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Drugs Level Amount");
        series1.getData().add(new XYChart.Data(2, itemA));
        series1.getData().add(new XYChart.Data(20, itemB));
        series1.getData().add(new XYChart.Data(10, itemC));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Drug Expiry");
        series2.getData().add(new XYChart.Data(50, itemA));
        series2.getData().add(new XYChart.Data(41, itemB));
        series2.getData().add(new XYChart.Data(45, itemC));
//
//        XYChart.Series series3 = new XYChart.Series();
//        series3.setName("2005");
//        series3.getData().add(new XYChart.Data(45, itemA));
//        series3.getData().add(new XYChart.Data(44, itemB));
//        series3.getData().add(new XYChart.Data(18, itemC));

//        Timeline tl = new Timeline();
//        tl.getKeyFrames().add(new KeyFrame(Duration.millis(500), 
//            new EventHandler<ActionEvent>() {
//                @Override public void handle(ActionEvent actionEvent) {
//                for (XYChart.Series<Number, String> series : bc.getData()) {
//                    for (XYChart.Data<Number, String> data : series.getData()) {
//                        data.setXValue(Math.random() * 100);
//                    }
//                }
//            }
//        }));
//        tl.setCycleCount(Animation.INDEFINITE);
//        tl.play();  
        
        bc.getData().addAll(series1,series2);
        
        AnchChartArea.getChildren().clear();            
        AnchChartArea.getChildren().add(bc);         
    }
    
}
