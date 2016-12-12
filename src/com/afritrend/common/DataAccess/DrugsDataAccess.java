/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.common.Interfaces.IDrugs;
import com.afritrend.common.Model.DrugsModel;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Xavier Khonje
 */
public class DrugsDataAccess implements IDrugs{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;    
    
    @Override
    public String SaveDrugs(DrugsModel drug, String user, String Pharmact, int Quantity, String Transaction) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveDrug(?,?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, drug.getDrugcode());
                stmt.setString(2, drug.getDrugclass());
                stmt.setString(3, drug.getDosageform());
                stmt.setString(4, drug.getDrugname());
                stmt.setString(5, drug.getStrength());
                stmt.setString(6, drug.getIssueunit());
                stmt.setString(7, drug.getExpirydate());
                stmt.setString(8, Pharmact);
                stmt.setInt(9, Quantity);
                stmt.setString(10, user);
                stmt.setString(11, Transaction);
                
                stmt.execute();
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            finally
            {
                return "Store Procedure Processed";
            }           
    }
    
    public String SaveWardDrugs(DrugsModel drug, String user, String Ward, int Quantity, String Transaction) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveWardDrug(?,?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, drug.getDrugcode());
                stmt.setString(2, drug.getDrugclass());
                stmt.setString(3, drug.getDosageform());
                stmt.setString(4, drug.getDrugname());
                stmt.setString(5, drug.getStrength());
                stmt.setString(6, drug.getIssueunit());
                stmt.setString(7, drug.getExpirydate());
                stmt.setString(8, Ward);
                stmt.setInt(9, Quantity);
                stmt.setString(10, user);
                stmt.setString(11, Transaction);
                
                stmt.execute();
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            finally
            {
                return "Drug Saved Successfully";
            }           
    }
        
}
