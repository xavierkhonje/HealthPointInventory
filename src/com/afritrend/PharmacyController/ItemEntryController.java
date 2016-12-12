/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyDataAccess.ItemDataAccess;
import com.afritrend.PharmacyModel.ItemModel;
import com.afritrend.common.AutoDrugSearchDataAccess;
import com.afritrend.common.Model.DrugsModel;
import com.afritrend.common.Model.Items;
import java.io.File;
import java.net.URL;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class ItemEntryController implements Initializable {

    @FXML
    ComboBox cbCode;
    
    @FXML
    ComboBox cbClass;
    
    @FXML
    ComboBox cbDrugClass;
    
    @FXML
    ComboBox cbName;
    
    @FXML
    CheckBox chkIsDrug;
    
    @FXML
    CheckBox chkIsSundry;
    
    @FXML
    TextField txtIssueUnit;
    
    @FXML
    TextField txtPrice;
    
    @FXML
    TextArea txtDescription;
    
    @FXML
    ComboBox cbDosageForm;
    
    @FXML
    ComboBox cbStrenghth;
    
    @FXML
    TextField txtQuantity;
    
    @FXML
    DatePicker dpexpirydate;
    
    @FXML
    Label lblClasserror;
    
    @FXML
    Label lblCodeError;
    
    @FXML
    Label lblIssueUnit;
    
    @FXML
    Label lblPriceError;
    
    @FXML
    Label lblDescriptionError;
    
    @FXML
    Label lblItemNameError;
    
    @FXML
    Label lblDrugClassName;
    
    @FXML
    Label lblDosageFormError;
    
    @FXML
    Label lblStrengthError;
    
    @FXML
    Label lblExpiryDateError;
    
    @FXML
    Label lblQuantityError;
    
    @FXML
    Label lblGeneralMessage;
    
    @FXML
    TableView TVitemEntry;    
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        
        List<Items> itemclasslist = AutoDrug.GetItemClass();
        List<String> item_classlist = AutoDrug.GetItem_Class();        
        List<String> itemDescriptionlist = AutoDrug.GetItemDescription();
        
        Iterator<String> itString = item_classlist.iterator();
        while(itString.hasNext())
        {
            String item = itString.next();
            cbClass.getItems().add(item);
        }     
        
        

    }    
    
    public void SaveItem(ActionEvent event)
    {
        try
        {
            lblCodeError.setText("");
            ItemModel item = new ItemModel();
            try
            {
                if(cbCode.getValue().equals("") || cbCode.getValue() == null)
                {
                    lblCodeError.setText("Please Enter Code");
                }
                else
                {
                    item.setItemCode(String.valueOf(cbCode.getValue()));
                }
            }
            catch(Exception e)
            {
                lblCodeError.setText(e.getMessage());
            }
            
            //////////////////////
            
            try
            {
                lblClasserror.setText("");
                if(cbClass.getValue().equals(""))
                {
                    lblClasserror.setText("Please Select Class");
                }
                else
                {
                    item.setItemClass(String.valueOf(cbClass.getValue()));
                }                
            }
            catch(Exception e)
            {
                lblClasserror.setText(e.getMessage());
            }

            
            /////////////////////////
            
            try
            {
                lblItemNameError.setText("");
                if(chkIsDrug.isSelected())
                {
                    if(cbName.getValue().equals(""))
                    {
                        lblItemNameError.setText("Please Select Item Name");
                    }
                    else
                    {
                        item.setItemName(String.valueOf(cbName.getValue()));
                    }

                    if(cbDosageForm.getValue().equals(""))
                    {
                        lblDosageFormError.setText("Please Select Dodage Form");
                    }
                    else
                    {
                        item.setDosageForm(String.valueOf(cbDosageForm.getValue()));
                    }
                }                
            }
            catch(Exception e)
            {
                lblItemNameError.setText(e.getMessage());
            }

            
            try
            {
                lblIssueUnit.setText("");
                if(txtIssueUnit.getText().equals(""))
                {
                    lblIssueUnit.setText("Please Enter Issue Unit");
                }
                else
                {
                    try
                    {
                        item.setIssueUnit(txtIssueUnit.getText());
                    }
                    catch(Exception e)
                    {
                        lblIssueUnit.setText(e.getMessage());
                    }
                }                
            }
            catch(Exception e)
            {
                lblIssueUnit.setText(e.getMessage());
            }

            
            
            try
            {
                lblPriceError.setText("");
                if(txtPrice.getText().equals(""))
                {
                    lblPriceError.setText("Please Enter Price");
                }
                else
                {
                    try
                    {
                        item.setPrice(Double.valueOf(txtPrice.getText()));
                    }
                    catch(Exception e)
                    {
                        lblPriceError.setText(e.getMessage());
                    }
                }                
            }
            catch(Exception e)
            {
                lblPriceError.setText(e.getMessage());
            }   
            

            
            
            try
            {
                lblDescriptionError.setText("");
                if(txtDescription.getText().equals(""))
                {
                    lblDescriptionError.setText("Please Enter Description");
                }
                else
                {
                    item.setDescription(txtDescription.getText());
                }                
            }
            catch(Exception e)
            {
                lblDescriptionError.setText(e.getMessage());
            } 
            

            
            
            try
            {
                lblStrengthError.setText("");
                if(cbStrenghth.getValue().equals(""))
                {
                    lblStrengthError.setText("Please Set Strength");
                }
                else
                {
                    try
                    {
                        item.setStrength(String.valueOf(cbStrenghth.getValue()));
                    }
                    catch(Exception e)
                    {
                        lblStrengthError.setText(e.getMessage());
                    }
                }                
            }
            catch(Exception e)
            {
                lblStrengthError.setText(e.getMessage());
            }             

            
            try
            {
                lblQuantityError.setText("");
                if(txtQuantity.getText().equals(""))
                {
                    lblQuantityError.setText("Please Enter Quantity");
                }
                else
                {
                    try
                    {
                        item.setQuantity(Integer.valueOf(txtQuantity.getText()));
                    }
                    catch(Exception e)
                    {
                        lblQuantityError.setText(e.getMessage());
                    }
                }                
            }
            catch(Exception e)
            {
                lblQuantityError.setText(e.getMessage());
            }           
            
            
            try
            {
                lblDrugClassName.setText("");
                if(cbDrugClass.getValue().equals(""))
                {
                    lblDrugClassName.setText("Please Select Drug Class");
                }
                else
                {
                    item.setDrugclass(String.valueOf(cbDrugClass.getValue()));
                }                
            }
            catch(Exception e)
            {
                lblDrugClassName.setText(e.getMessage());
            }
            

            
            try
            {
                lblExpiryDateError.setText("");
                if(dpexpirydate.getValue().equals(""))
                {
                    lblExpiryDateError.setText("Please Enter Date");
                }
                else
                {
                    item.setExpirydate(String.valueOf(dpexpirydate.getValue()));
                }                
            }
            catch(Exception e)
            {
                lblExpiryDateError.setText(e.getMessage());
            }            

            lblGeneralMessage.setText("");
            boolean validate = item.ValidateItem();
            if(validate)
            {
                ItemDataAccess itemdao = new ItemDataAccess();
                itemdao.SaveItem(item);
                lblGeneralMessage.setText("Item Saved");
                
                ObservableList<ItemModel> itemsobs = FXCollections.observableArrayList();  

                TableColumn<DrugsModel, String> CMSCODEColumn = new TableColumn<>("CMS CODE");
                CMSCODEColumn.setMinWidth (200);    
                CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));  

                TableColumn<DrugsModel, String> ItemClassColumn = new TableColumn<>("Item Class");
                ItemClassColumn.setMinWidth (200);    
                ItemClassColumn.setCellValueFactory(new PropertyValueFactory<>("itemClass"));      

                TableColumn<DrugsModel, String> ItemNameColumn = new TableColumn<>("Item Name");
                ItemNameColumn.setMinWidth (200);    
                ItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName")); 

                TableColumn<DrugsModel, String> IssueUnitColumn = new TableColumn<>("Issue Unit");        
                IssueUnitColumn.setMinWidth (200);    
                IssueUnitColumn.setCellValueFactory(new PropertyValueFactory<>("issueUnit"));         

                TableColumn<DrugsModel, String> PriceColumn = new TableColumn<>("Price");        
                PriceColumn.setMinWidth (200);    
                PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));        

                TableColumn<DrugsModel, String> DescriptionColumn = new TableColumn<>("Description");        
                DescriptionColumn.setMinWidth (200);    
                DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));           

                TableColumn<DrugsModel, String> DosageColumn = new TableColumn<>("Dosage Form");        
                DosageColumn.setMinWidth (200);    
                DosageColumn.setCellValueFactory(new PropertyValueFactory<>("dosageForm"));     

                TableColumn<DrugsModel, String> StrengthColumn = new TableColumn<>("Strength");        
                StrengthColumn.setMinWidth (200);    
                StrengthColumn.setCellValueFactory(new PropertyValueFactory<>("strength"));     

                TableColumn<DrugsModel, String> ExpiryColumn = new TableColumn<>("Exipry Date");        
                ExpiryColumn.setMinWidth (200);    
                ExpiryColumn.setCellValueFactory(new PropertyValueFactory<>("expirydate"));     

                TableColumn<DrugsModel, String> DrugClassColumn = new TableColumn<>("Drug Class");        
                DrugClassColumn.setMinWidth (200);    
                DrugClassColumn.setCellValueFactory(new PropertyValueFactory<>("drugclass"));   

                TableColumn<DrugsModel, String> QuantityColumn = new TableColumn<>("Quantity");        
                QuantityColumn.setMinWidth (200);    
                QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));             


                itemsobs.add(new ItemModel(
                        item.getItemCode(),item.getItemClass(),
                        item.getItemName(),item.getIssueUnit(),
                        item.getPrice(),item.getDescription(),
                        item.getDosageForm(),item.getStrength(),
                        item.getExpirydate(),item.getDrugclass(),
                        item.getQuantity()));

                TVitemEntry.setItems(itemsobs);
                TVitemEntry.getColumns().addAll(
                        CMSCODEColumn,ItemClassColumn,ItemNameColumn,
                        IssueUnitColumn,PriceColumn,DescriptionColumn,DosageColumn,
                        StrengthColumn,ExpiryColumn,DrugClassColumn,QuantityColumn);                    
                
            }
            else
            {
                String Msg = item.getMessage();
                lblGeneralMessage.setText(Msg);
            }                       
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }    
    
    public void IsDrug(ActionEvent event)
    {
        if(chkIsDrug.isSelected())
        {
            cbDrugClass.setDisable(false);
            cbDosageForm.setDisable(false);

            cbDrugClass.getItems().clear();
            cbDosageForm.getItems().clear();            

            //Get Drug Class
            AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();        
            List<String> itemclasslist = AutoDrug.GetDrug_Class();   
            Iterator<String> itString = itemclasslist.iterator();
            while(itString.hasNext())
            {
                String item = itString.next();
                cbDrugClass.getItems().add(item);
            }         

            //Get Dosage Class      
            List<String> itemDosagelist = AutoDrug.GetDosageForms();   
            Iterator<String> itDString = itemDosagelist.iterator();
            while(itDString.hasNext())
            {
                String Dosage = itDString.next();
                cbDosageForm.getItems().add(Dosage);
            }         
        
        }
        else
        {
            cbDrugClass.setDisable(true);
            cbDosageForm.setDisable(true);            
        }        
        
    }
    
    public void UpdateItem(ActionEvent event)
    {
        
    }
    
    public void DeleteItem(ActionEvent event)
    {
        
    }
    
    public void GetItemCode(ActionEvent event)
    {
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        List<String> itemCodelist = AutoDrug.GetItemCode(String.valueOf(cbClass.getValue()));
        Iterator<String> itCodeString = itemCodelist.iterator();
        cbCode.getItems().clear();
        while(itCodeString.hasNext())
        {
            String item = itCodeString.next();
            cbCode.getItems().add(item);
        }       
    }
    
    public void GetItemName(ActionEvent event)
    {
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        List<Items> itemCodelist = AutoDrug.GetItemName(String.valueOf(cbCode.getValue()));
        Iterator<Items> itCodeString = itemCodelist.iterator();
        
        cbName.getItems().clear();
        txtDescription.clear();
        txtIssueUnit.clear();
        
        while(itCodeString.hasNext())
        {
            Items it = new Items();
            it = itCodeString.next();
            cbName.getItems().add(it.getClassName());
            txtDescription.setText(it.getDescription());
            txtIssueUnit.setText(it.getIssueUnit());
        }    
        
        //Set the Description as a hint
    } 
    
    public void AttachFiles(ActionEvent event)
    {
        try
        {
            Stage EDMS = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/HP_EDMS.fxml"));
            Scene scene = new Scene(root);
            EDMS.initModality(Modality.APPLICATION_MODAL);
            EDMS.centerOnScreen();                
            EDMS.setScene(scene);           
            
            EDMS.showAndWait();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }        
        
    }
}
