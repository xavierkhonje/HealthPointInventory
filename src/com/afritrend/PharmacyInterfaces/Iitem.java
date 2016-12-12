/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyInterfaces;

import com.afritrend.PharmacyModel.ItemModel;
/**
 *
 * @author Xavier Khonje
 */
public interface Iitem {
    
    String SaveItem(ItemModel item);
    String GetItem(ItemModel item);
}
