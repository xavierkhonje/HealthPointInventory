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
public class WardNormalRequisitionReview implements Serializable, Cloneable{
    private int quantityRequestedByward;
    private int quantityPacked;
    private String pharmacistPacking;
    private int reqid;

    public WardNormalRequisitionReview() {
    }

    public WardNormalRequisitionReview(int quantityRequestedByward, int quantityPacked, String pharmacistPacking, int reqid) {
        this.quantityRequestedByward = quantityRequestedByward;
        this.quantityPacked = quantityPacked;
        this.pharmacistPacking = pharmacistPacking;
        this.reqid = reqid;
    }

    public int getQuantityRequestedByward() {
        return quantityRequestedByward;
    }

    public void setQuantityRequestedByward(int quantityRequestedByward) {
        this.quantityRequestedByward = quantityRequestedByward;
    }

    public int getQuantityPacked() {
        return quantityPacked;
    }

    public void setQuantityPacked(int quantityPacked) {
        this.quantityPacked = quantityPacked;
    }

    public String getPharmacistPacking() {
        return pharmacistPacking;
    }

    public void setPharmacistPacking(String pharmacistPacking) {
        this.pharmacistPacking = pharmacistPacking;
    }

    public int getReqid() {
        return reqid;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    @Override
    public String toString() {
        return "WardNormalRequisitionReview{" + "quantityRequestedByward=" + quantityRequestedByward + ", quantityPacked=" + quantityPacked + ", pharmacistPacking=" + pharmacistPacking + ", reqid=" + reqid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
