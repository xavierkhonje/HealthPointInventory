/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.common.AutoDrugSearchDataAccess;
import com.afritrend.common.DataAccess.DrugSettingsDataAccess;
import com.afritrend.common.Model.DrugConfiguration;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class DrugSettingsController implements Initializable {

    @FXML
    ComboBox cbItemCode;   
    
    @FXML
    TextField txtMinmumLevel;
    
    @FXML
    TextField txtMaxLevel;
    
    @FXML
    TextField txtEWP;
    
    @FXML
    TableView TVItemConfig;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Getting the Dosage Forms
        List<String> Drugcmscodeslist = new ArrayList();        
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();             
        
        Drugcmscodeslist = drugautodao.GetHPItemCode();
        
        Iterator<String> itCodes = Drugcmscodeslist.iterator();
        while(itCodes.hasNext())
        {
            String Code = itCodes.next();
            cbItemCode.getItems().add(Code);
        }
        
        DrugSettingsDataAccess drugSettingdao = new DrugSettingsDataAccess();
        DrugConfiguration drugconfig = new DrugConfiguration();
        List<DrugConfiguration> druglist = new ArrayList();
        druglist = drugSettingdao.GetDrugConfigurations();
        
        ObservableList<DrugConfiguration> configs = FXCollections.observableArrayList();  
        
        TableColumn<DrugConfiguration, String> CMSCODEColumn = new TableColumn<>("CMS CODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));  
                
        TableColumn<DrugConfiguration, String> MaxColumn = new TableColumn<>("Maximum Level");
        MaxColumn.setMinWidth (200);    
        MaxColumn.setCellValueFactory(new PropertyValueFactory<>("maximumLevel"));      
        
        TableColumn<DrugConfiguration, String> MinColumn = new TableColumn<>("MiniMum Level");
        MinColumn.setMinWidth (200);    
        MinColumn.setCellValueFactory(new PropertyValueFactory<>("minmumLevel")); 
        
        TableColumn<DrugConfiguration, String> EWPColumn = new TableColumn<>("Exipry Waiting Period");        
        EWPColumn.setMinWidth (200);    
        EWPColumn.setCellValueFactory(new PropertyValueFactory<>("ewd"));             
        
        Iterator<DrugConfiguration> configit = druglist.iterator();
        while(configit.hasNext())
        {
            DrugConfiguration conf = new DrugConfiguration();
            conf = configit.next();
            configs.add(new DrugConfiguration(conf.getCmscode(),conf.getMinmumLevel(),conf.getMaximumLevel(),conf.getEwd()));
        }
                
        TVItemConfig.setItems(configs);
        TVItemConfig.getColumns().addAll(CMSCODEColumn,MaxColumn,MinColumn,EWPColumn);        
    }    
    
    public void SaveConfiguration(ActionEvent event)
    {
        DrugSettingsDataAccess drugSettingdao = new DrugSettingsDataAccess();
        
        String cmscode = String.valueOf(cbItemCode.getValue());
        int MinLevel = Integer.valueOf(txtMinmumLevel.getText());
        int MaxLevel = Integer.valueOf(txtMaxLevel.getText());
        int EWP = Integer.valueOf(txtEWP.getText());
        
        DrugConfiguration drugconfig = new DrugConfiguration();
        drugconfig.setCmscode(cmscode);
        drugconfig.setMinmumLevel(MinLevel);
        drugconfig.setMaximumLevel(MaxLevel);
        drugconfig.setEwd(EWP);
        
        String MSG = drugSettingdao.SaveDrugSettings(drugconfig);
        
        ObservableList<DrugConfiguration> configs = FXCollections.observableArrayList();  
        
        TableColumn<DrugConfiguration, String> CMSCODEColumn = new TableColumn<>("CMS CODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));  
                
        TableColumn<DrugConfiguration, String> MaxColumn = new TableColumn<>("Maximum Level");
        MaxColumn.setMinWidth (200);    
        MaxColumn.setCellValueFactory(new PropertyValueFactory<>("maximumLevel"));      
        
        TableColumn<DrugConfiguration, String> MinColumn = new TableColumn<>("MiniMum Level");
        MinColumn.setMinWidth (200);    
        MinColumn.setCellValueFactory(new PropertyValueFactory<>("minmumLevel")); 
        
        TableColumn<DrugConfiguration, String> EWPColumn = new TableColumn<>("Exipry Waiting Period");        
        EWPColumn.setMinWidth (200);    
        EWPColumn.setCellValueFactory(new PropertyValueFactory<>("ewd"));             
        

        configs.add(new DrugConfiguration(drugconfig.getCmscode(),drugconfig.getMinmumLevel(),drugconfig.getMaximumLevel(),drugconfig.getEwd()));
                
        TVItemConfig.setItems(configs);
        TVItemConfig.getColumns().addAll(CMSCODEColumn,MaxColumn,MinColumn,EWPColumn);                    
    }
    
}
