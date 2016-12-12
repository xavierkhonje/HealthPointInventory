/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.afritrend.common.Model.itemAmount;
import com.afritrend.common.DataAccess.ItemSummaryDataAccess;
import com.afritrend.common.Model.requisitionModel;
import com.afritrend.common.Model.voucherModel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PharmacyMainController implements Initializable {

    @FXML
    BorderPane MainBorderPane;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {
            
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/Home.fxml"));
            MainBorderPane.setCenter(root);             
        }
        catch(Exception e)
        {
            
        }         
    }    
    
    public void ItemEntry(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ItemEntry.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void LogOutHealthPoint(ActionEvent event)
    {
        try
        {
            Stage LoginStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/healthpointinventory/HealthPoint.fxml"));
            Scene scene = new Scene(root);
            LoginStage.setMaximized(true);
            LoginStage.centerOnScreen();        
            LoginStage.initStyle(StageStyle.UNDECORATED);            
            LoginStage.setScene(scene);
            
            Stage stage = (Stage)MainBorderPane.getScene().getWindow();
            stage.close();
            
            LoginStage.show();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }        
    }
    
    public void ShowDrugSettings(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugSettings.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void ShowDrugSummary(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugSummaryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void ShowSundrySummaryReport(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/SundrySummaryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }        
    }
    
    

       public void ShowDrugStockCard(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugStockCard.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
       
    public void ShowSundryStockCard(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/SundryStockCard.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
       
   public void GoHome(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/Home.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowDrugsEntry(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/HospitalItemEntry.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowSundriesEntry(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/HospitalSundriesEntry.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowDrugsLostReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugsLostReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowSundriesLostReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/SundriesLostReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   public void ShowDrugsExpiryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugsExpiryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowSundriesExpiryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugsSundryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   public void ReviewRequisition(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ReviewRequisition.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ApproveRequisition(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ApproveRequisition.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void NewRequisition(ActionEvent event)
   {
       RequisitionDataAccess requidao = new RequisitionDataAccess();
       requisitionModel req = new requisitionModel();
       List<requisitionModel> requilist = new ArrayList();
       voucherModel voucher = new voucherModel();
       
       voucher.setRequisitionService("QuantityBeingRequested");
       voucher.setWardName("4AWard");
       voucher.setComments("Testing from App");
       voucher.setRequisitionTransactionType("QuantityBeingRequested");
       
       req.setScaleUnit("6656");
       req.setAmount(23344);
       req.setItemType("Drug");
       req.setCmscode("AA007500");

       requilist.add(req);
       
       String MSG = requidao.SaveRequisition(requilist, voucher);       
       
        Notifications notification = Notifications.create()
                .title("Drug Saved")
                .text(MSG)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event)
                    {
                        System.out.println("Clicked on Notification");
                    }
                });
        
        notification.showConfirm();              
   }
    
}
