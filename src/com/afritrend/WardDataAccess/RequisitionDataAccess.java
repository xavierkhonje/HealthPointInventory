/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;

import com.afritrend.common.Model.WardNormalPharmacyApproval;
import com.afritrend.common.Model.WardNormalRequisitionFinalized;
import com.afritrend.common.Model.WardNormalRequisitionReceived;
import com.afritrend.common.Model.WardNormalRequisitionReview;
import com.afritrend.common.Model.WardNormalRequisitionsApproved;
import com.afritrend.common.Model.requisitionModel;
import com.afritrend.common.Model.voucherModel;
import com.afritrend.common.config;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Xavier Khonje
 */
public class RequisitionDataAccess {
        config config = new config();
        Connection conn = null;
//        CallableStatement stmt = null;   

        CallableStatement stmt = null;           
        
        public String SaveRequisition(List<requisitionModel> requisitionlist, voucherModel voucher)
        {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect();                 
                
                SQLServerDataTable RequisitionTable = new SQLServerDataTable(); 
                
                RequisitionTable.addColumnMetadata("ScaleUnit", java.sql.Types.NVARCHAR);
                RequisitionTable.addColumnMetadata("Amount", java.sql.Types.INTEGER);
                RequisitionTable.addColumnMetadata("ItemType", java.sql.Types.NVARCHAR);
                RequisitionTable.addColumnMetadata("CMSCODE", java.sql.Types.NVARCHAR);        
                
                //loop through the table
                Iterator<requisitionModel> reqlisit = requisitionlist.iterator();
                while(reqlisit.hasNext())
                {
                    requisitionModel requisition = new requisitionModel();
                    requisition = reqlisit.next();
                    RequisitionTable.addRow(requisition.getScaleUnit(),requisition.getAmount(),requisition.getItemType(),requisition.getCmscode());
                }                   
                
                String sql = "{CALL spHP_saveVoucher(?,?,?,?,?)}"; 
                SQLServerPreparedStatement Pstmt = (SQLServerPreparedStatement)conn.prepareStatement(sql);
                
                Pstmt.setString(1, voucher.getRequisitionService());
                Pstmt.setString(2, voucher.getWardName());
                Pstmt.setString(3, voucher.getComments());
                Pstmt.setString(4, voucher.getRequisitionTransactionType());              
                Pstmt.setStructured(5, "dbo.RequisitionTable", RequisitionTable);
                Pstmt.execute();                
                
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            finally
            {
                return "Requsition Successfully Saved";
            }            
        }
        
        public String SaveWardNormalRequisitionsApproved(List<WardNormalRequisitionsApproved> requisitionlist)
        {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect();                 
                
                SQLServerDataTable WardApproveRequisitionTable = new SQLServerDataTable(); 
                
                WardApproveRequisitionTable.addColumnMetadata("quantityRequested", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityApproved", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityReserved", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("cmscode", java.sql.Types.NVARCHAR);   
                WardApproveRequisitionTable.addColumnMetadata("drugName", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("itemtype", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("scaleunit", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("requester", java.sql.Types.NVARCHAR); 
                WardApproveRequisitionTable.addColumnMetadata("approver", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("requisitionid", java.sql.Types.INTEGER);                  
                
                //loop through the table
                Iterator<WardNormalRequisitionsApproved> reqlisit = requisitionlist.iterator();
                while(reqlisit.hasNext())
                {
                    WardNormalRequisitionsApproved requisition = new WardNormalRequisitionsApproved();
                    
                    requisition = reqlisit.next();
                    
                    WardApproveRequisitionTable.addRow(
                            requisition.getQuantityRequested(),
                            requisition.getQuantityApproved(),
                            requisition.getQuantityReserved(),
                            requisition.getCmscode(),
                            requisition.getDrugName(),
                            requisition.getItemtype(),
                            requisition.getScaleunit(),
                            requisition.getRequester(),
                            requisition.getApprover(),
                            requisition.getRequisitionid()
                    );
                }                   
                
                String sql = "{CALL spHP_saveWardNormalApproveReq(?)}"; 
                SQLServerPreparedStatement Pstmt = (SQLServerPreparedStatement)conn.prepareStatement(sql);                            
                Pstmt.setStructured(1, "dbo.UTWardNormalRequisitionsApproved", WardApproveRequisitionTable);
                Pstmt.execute();                
                
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
                return "Requsition Successfully Saved";           
        }
        public String SaveWardNormalRequisitionsReceived(List<WardNormalRequisitionReceived> requisitionlist)
        {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect();                 
                
                SQLServerDataTable WardApproveRequisitionTable = new SQLServerDataTable(); 
                
                WardApproveRequisitionTable.addColumnMetadata("quantityCollected", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityReceived", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityLost", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityExpired", java.sql.Types.INTEGER);   
                WardApproveRequisitionTable.addColumnMetadata("quantityDamaged", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("receiver", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("reqid", java.sql.Types.INTEGER);           
                
                //loop through the table
                Iterator<WardNormalRequisitionReceived> reqlisit = requisitionlist.iterator();
                while(reqlisit.hasNext())
                {
                    WardNormalRequisitionReceived requisition = new WardNormalRequisitionReceived();
                    
                    requisition = reqlisit.next();
                    WardApproveRequisitionTable.addRow(
                            requisition.getQuantityCollected(),
                            requisition.getQuantityReceived(),
                            requisition.getQuantityLost(),
                            requisition.getQuantityExpired(),
                            requisition.getQuantityDamaged(),
                            requisition.getReceiver(),
                            requisition.getReqid()
                    );
                }                   
                
                String sql = "{CALL spHP_saveWardNormalReceivedReq(?)}"; 
                SQLServerPreparedStatement Pstmt = (SQLServerPreparedStatement)conn.prepareStatement(sql);                            
                Pstmt.setStructured(1, "dbo.WardNormalRequisitionReceived", WardApproveRequisitionTable);
                Pstmt.execute();                
                
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
                return "Requsition Successfully Saved";           
        }
        public String SavePharmacyNormalRequisitionsApproved(List<WardNormalPharmacyApproval> requisitionlist)
        {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect();                 
                
                SQLServerDataTable WardApproveRequisitionTable = new SQLServerDataTable(); 
                
                WardApproveRequisitionTable.addColumnMetadata("quantityPacked", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityApproved", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("approvedBy", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("reqid", java.sql.Types.INTEGER);                    
                
                //loop through the table
                Iterator<WardNormalPharmacyApproval> reqlisit = requisitionlist.iterator();
                while(reqlisit.hasNext())
                {
                    WardNormalPharmacyApproval requisition = new WardNormalPharmacyApproval();
                    
                    requisition = reqlisit.next();
                    WardApproveRequisitionTable.addRow(
                            requisition.getQuantityPacked(),
                            requisition.getQuantityApproved(),
                            requisition.getApprovedBy(),
                            requisition.getReqid()
                    );
                }                   
                
                String sql = "{CALL spHP_saveWardNormalReviewReq(?)}"; 
                SQLServerPreparedStatement Pstmt = (SQLServerPreparedStatement)conn.prepareStatement(sql);                            
                Pstmt.setStructured(1, "dbo.UTPharmacyNormalRequisitionsReview", WardApproveRequisitionTable);
                Pstmt.execute();                
                
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
                return "Requsition Successfully Saved";           
        }
        public String SavePharmacyNormalRequisitionsReviewed(List<WardNormalRequisitionReview> requisitionlist)
        {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect();                 
                
                SQLServerDataTable WardApproveRequisitionTable = new SQLServerDataTable(); 
                
                WardApproveRequisitionTable.addColumnMetadata("quantityRequestedByward", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityPacked", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("pharmacistPacking", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("reqid", java.sql.Types.INTEGER);                   
                
                //loop through the table
                Iterator<WardNormalRequisitionReview> reqlisit = requisitionlist.iterator();
                while(reqlisit.hasNext())
                {
                    WardNormalRequisitionReview requisition = new WardNormalRequisitionReview();
                    
                    requisition = reqlisit.next();
                    WardApproveRequisitionTable.addRow(
                            requisition.getQuantityRequestedByward(),
                            requisition.getQuantityPacked(),
                            requisition.getPharmacistPacking(),
                            requisition.getReqid()
                    );
                }                   
                
                String sql = "{CALL spHP_saveWardNormalReviewReq(?)}"; 
                SQLServerPreparedStatement Pstmt = (SQLServerPreparedStatement)conn.prepareStatement(sql);                            
                Pstmt.setStructured(1, "dbo.UTPharmacyNormalRequisitionsReview", WardApproveRequisitionTable);
                Pstmt.execute();                
                
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
                return "Requsition Successfully Saved";           
        }
        public String SaveWardNormalRequisitionsFinalized(List<WardNormalRequisitionFinalized> requisitionlist)
        {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect();                 
                
                SQLServerDataTable WardApproveRequisitionTable = new SQLServerDataTable(); 
                
                WardApproveRequisitionTable.addColumnMetadata("quantityReceived", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("quantityFinalized", java.sql.Types.INTEGER);
                WardApproveRequisitionTable.addColumnMetadata("finalizer", java.sql.Types.NVARCHAR);
                WardApproveRequisitionTable.addColumnMetadata("reqid", java.sql.Types.INTEGER);                     
                
                //loop through the table
                Iterator<WardNormalRequisitionFinalized> reqlisit = requisitionlist.iterator();
                while(reqlisit.hasNext())
                {
                    WardNormalRequisitionFinalized requisition = new WardNormalRequisitionFinalized();
                    
                    requisition = reqlisit.next();
                    WardApproveRequisitionTable.addRow(
                            requisition.getQuantityReceived(),
                            requisition.getQuantityFinalized(),
                            requisition.getFinalizer(),
                            requisition.getReqid()
                    );
                }                   
                
                String sql = "{CALL spHP_saveWardNormalFinalizedReq(?)}"; 
                SQLServerPreparedStatement Pstmt = (SQLServerPreparedStatement)conn.prepareStatement(sql);                            
                Pstmt.setStructured(1, "dbo.UTWardNormalRequisitionsFinalizer", WardApproveRequisitionTable);
                Pstmt.execute();                
                
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
                return "Requsition Successfully Saved";           
        }
        
        public List<voucherModel> GETvoucherlist(String WardName, String VoucherStatus)
        {
            List<voucherModel> voucherlist = new ArrayList();
            try
            {
                conn = config.DBConnect(); 
                ResultSet rs = null;
                String sql = "{CALL spHP_GETVoucherList(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, WardName);
                stmt.setString(2, VoucherStatus);
                stmt.execute();
                rs = stmt.getResultSet();

                while(rs.next())
                {
                    voucherModel voucher = new voucherModel();

                    voucher.setVouchercode(rs.getString("vouchercode"));                
                    voucher.setRequisitionService(rs.getString("requisitionService"));                
                    voucher.setRequisitionDate(rs.getString("requisitionDate"));                
                    voucher.setLastdateRequisitionApproved(rs.getString("lastdateRequisitionApproved")); 
                    voucher.setLastreferenceapprovedrequisition(rs.getString("lastreferenceapprovedrequisition"));                
                    voucher.setComments(rs.getString("comments"));                
                    voucher.setWardName(rs.getString("wardName"));                
                    voucher.setRequisitionTransactionType(rs.getString("requisitionTransactionType"));                     
                    voucher.setVoucherstatus(rs.getString("voucherstatus"));                     

                    voucherlist.add(voucher);
                }                        
            }
            catch(Exception e)
            {

            }        
            finally
            {

            }             
            return voucherlist;
        }
        
        public List<requisitionModel> GETRequestedRequisition(String VoucherNumber)
        {
            List<requisitionModel> reqlist = new ArrayList();
            try
            {
                conn = config.DBConnect(); 
                ResultSet rs = null;
                String sql = "{CALL spHP_GETRequestedRequisition(?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, VoucherNumber);
                stmt.execute();
                rs = stmt.getResultSet();

                while(rs.next())
                {
                    requisitionModel reqprep = new requisitionModel();

                    reqprep.setScaleUnit(rs.getString("ScaleUnit"));                
                    reqprep.setAmount(rs.getInt("Amount"));                
                    reqprep.setItemType(rs.getString("Name"));                
                    reqprep.setCmscode(rs.getString("DrugName"));                   
                    reqprep.setRequisitionid(rs.getInt("FK_requisitionID"));                   

                    reqlist.add(reqprep);
                }                        
            }
            catch(Exception e)
            {

            }        
            finally
            {

            }             
            return reqlist;
        }
        
        public List<WardNormalRequisitionsApproved> GETWardApprovedRequisition(String VoucherNumber)
        {
            List<WardNormalRequisitionsApproved> reqlist = new ArrayList();
            try
            {
                conn = config.DBConnect(); 
                ResultSet rs = null;
                String sql = "{CALL spHP_GETWardNormalApproveReq(?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, VoucherNumber);
                stmt.execute();
                rs = stmt.getResultSet();

                while(rs.next())
                {
                    WardNormalRequisitionsApproved reqprep = new WardNormalRequisitionsApproved();

                    reqprep.setQuantityRequested(rs.getInt("QuantityRequested"));                
                    reqprep.setQuantityApproved(rs.getInt("QuantityApproved"));                
                    reqprep.setQuantityReserved(rs.getInt("QuantityReserved"));                
                    reqprep.setCmscode(rs.getString("Cmscode"));                   
                    reqprep.setDrugName(rs.getString("DrugName"));                   
                    reqprep.setItemtype(rs.getString("Name"));                   
                    reqprep.setScaleunit(rs.getString("ScaleUnit"));                   
                    reqprep.setRequester(rs.getString("Requester"));                   
                    reqprep.setApprover(rs.getString("Approval"));                   
                    reqprep.setRequisitionid(rs.getInt("requisitionid"));                   

                    reqlist.add(reqprep);
                }                        
            }
            catch(Exception e)
            {

            }        
            finally
            {

            }             
            return reqlist;
        }
        
        public List<voucherModel> UpdatevoucherStatus(String VoucherNumber, String UpdateInstructions)
        {
            List<voucherModel> voucherlist = new ArrayList();
            try
            {
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_UPDATEVoucherStatus(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, VoucherNumber);
                stmt.setString(2, UpdateInstructions);
                stmt.execute();                      
            }
            catch(Exception e)
            {

            }        
            finally
            {

            }             
            return voucherlist;
        }
}