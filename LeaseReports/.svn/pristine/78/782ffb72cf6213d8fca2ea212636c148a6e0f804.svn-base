/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.reports.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DineshkumarP
 */
public class BasicInfo {
 
    public static String getSysdate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
    
    public static String responseToRest(String result) {
        org.json.simple.JSONObject json = new org.json.simple.JSONObject();
        json.put("result", result);
        return json.toJSONString();

}
    
    
}
