/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.Model.WardNormalPharmacyApproval;
import com.afritrend.common.Model.WardNormalRequisitionReview;
import com.afritrend.common.Model.WardNormalRequisitionsApproved;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PharmacyReviewModalController implements Initializable {
    @FXML
    TableView ReviewModalTV;
    
    public String voucherNumber;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    
    public void initData(String VoucherNum)
    {        
        List<WardNormalRequisitionsApproved> reqlist = new ArrayList();
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqlist = reqdao.GETWardApprovedRequisition(VoucherNum);
        
        ShowReviewRequisition(reqlist);        
    }
    
    public void PackItems()
    {
        
    }
    
    public void ShowReviewRequisition(List<WardNormalRequisitionsApproved> reqlist)
    {
            ObservableList<WardNormalRequisitionsApproved> itemsobs = FXCollections.observableArrayList();  

            TableColumn<WardNormalRequisitionsApproved, String> ScaleUnitColumn = new TableColumn<>("Quantiy Requested");
            ScaleUnitColumn.setMinWidth (200);    
            ScaleUnitColumn.setSortable(false);   
            ScaleUnitColumn.setCellValueFactory(new PropertyValueFactory<>("quantityRequested"));  

            TableColumn<WardNormalRequisitionsApproved, String> AmountColumn = new TableColumn<>("Quantity Approved");
            AmountColumn.setMinWidth (200);    
            AmountColumn.setSortable(false);   
            AmountColumn.setCellValueFactory(new PropertyValueFactory<>("quantityApproved"));      

            TableColumn<WardNormalRequisitionsApproved, String> ItemTypeColumn = new TableColumn<>("Quantity Reserved");
            ItemTypeColumn.setMinWidth (200);    
            ItemTypeColumn.setSortable(false);  
            ItemTypeColumn.setCellValueFactory(new PropertyValueFactory<>("quantityReserved")); 

            TableColumn<WardNormalRequisitionsApproved, String> CMSCODEColumn = new TableColumn<>("CMS CODE");
            CMSCODEColumn.setMinWidth (200);    
            CMSCODEColumn.setSortable(false);  
            CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));                                 

            TableColumn<WardNormalRequisitionsApproved, String> DRUGColumn = new TableColumn<>("DRUG NAME");
            DRUGColumn.setMinWidth (200);    
            DRUGColumn.setSortable(false);  
            DRUGColumn.setCellValueFactory(new PropertyValueFactory<>("drugName"));                                 

            Iterator<WardNormalRequisitionsApproved> reqit = reqlist.iterator();
            while(reqit.hasNext())
            {
                WardNormalRequisitionsApproved requistion = new WardNormalRequisitionsApproved();
                requistion = reqit.next();

                itemsobs.add(new WardNormalRequisitionsApproved(
                        requistion.getQuantityRequested(),
                        requistion.getQuantityApproved(),
                        requistion.getQuantityReserved(),
                        requistion.getCmscode(),   
                        requistion.getDrugName(),
                        requistion.getItemtype(),
                        requistion.getScaleunit(),
                        requistion.getRequester(),                          
                        requistion.getApprover(),                          
                        requistion.getRequisitionid()));                    
            }
            ReviewModalTV.getColumns().clear();
            ReviewModalTV.setItems(itemsobs);
            ReviewModalTV.getColumns().addAll(
                    ScaleUnitColumn,AmountColumn,ItemTypeColumn,
                    CMSCODEColumn,DRUGColumn);        
    }    
}
