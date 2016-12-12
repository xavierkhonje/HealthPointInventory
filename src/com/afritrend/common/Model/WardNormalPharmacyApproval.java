/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class WardNormalPharmacyApproval implements Serializable, Cloneable{
    private int quantityPacked;
    private int quantityApproved;
    private String approvedBy;
    private int reqid;

    public WardNormalPharmacyApproval() {
    }

    public WardNormalPharmacyApproval(int quantityPacked, int quantityApproved, String approvedBy, int reqid) {
        this.quantityPacked = quantityPacked;
        this.quantityApproved = quantityApproved;
        this.approvedBy = approvedBy;
        this.reqid = reqid;
    }

    public int getQuantityPacked() {
        return quantityPacked;
    }

    public void setQuantityPacked(int quantityPacked) {
        this.quantityPacked = quantityPacked;
    }

    public int getQuantityApproved() {
        return quantityApproved;
    }

    public void setQuantityApproved(int quantityApproved) {
        this.quantityApproved = quantityApproved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public int getReqid() {
        return reqid;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    @Override
    public String toString() {
        return "WardNormalPharmacyApproval{" + "quantityPacked=" + quantityPacked + ", quantityApproved=" + quantityApproved + ", approvedBy=" + approvedBy + ", reqid=" + reqid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
