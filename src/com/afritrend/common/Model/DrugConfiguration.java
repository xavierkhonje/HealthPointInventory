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
public class DrugConfiguration implements Serializable, Cloneable{
    private String cmscode;
    private int minmumLevel;
    private int maximumLevel;
    private int ewd;    

    public DrugConfiguration() {
    }

    public DrugConfiguration(String cmscode, int minmumLevel, int maximumLevel, int ewd) {
        this.cmscode = cmscode;
        this.minmumLevel = minmumLevel;
        this.maximumLevel = maximumLevel;
        this.ewd = ewd;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public int getMinmumLevel() {
        return minmumLevel;
    }

    public void setMinmumLevel(int minmumLevel) {
        this.minmumLevel = minmumLevel;
    }

    public int getMaximumLevel() {
        return maximumLevel;
    }

    public void setMaximumLevel(int maximumLevel) {
        this.maximumLevel = maximumLevel;
    }

    public int getEwd() {
        return ewd;
    }

    public void setEwd(int ewd) {
        this.ewd = ewd;
    }


    
    
}
