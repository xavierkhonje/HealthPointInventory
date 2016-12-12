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
public class DrugsModel implements Serializable, Cloneable{
    private String drugcode;
    private String drugclass;
    private String dosageform;
    private String drugname;
    private String strength;
    private String issueunit;
    private String expirydate;

    public DrugsModel() {
    }

    public DrugsModel(String drugcode, String drugclass, String dosageform, String drugname, String strength, String issueunit, String expirydate) {
        this.drugcode = drugcode;
        this.drugclass = drugclass;
        this.dosageform = dosageform;
        this.drugname = drugname;
        this.strength = strength;
        this.issueunit = issueunit;
        this.expirydate = expirydate;
    }

    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode;
    }

    public String getDrugclass() {
        return drugclass;
    }

    public void setDrugclass(String drugclass) {
        this.drugclass = drugclass;
    }

    public String getDosageform() {
        return dosageform;
    }

    public void setDosageform(String dosageform) {
        this.dosageform = dosageform;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getIssueunit() {
        return issueunit;
    }

    public void setIssueunit(String issueunit) {
        this.issueunit = issueunit;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }
    
    
}
