/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.reports.config;

import com.lease.reports.LeaseBookingForm;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.xdo.XDOException;
import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;

/**
 *
 * @author DineshkumarP
 */
public class GenericRTFReport {
    
    public static byte[]  rtfReportByte(String xmlData, String filePath,String P_FILE_TYPE){
    
    byte[] dataBytes = null;

        InputStream fiS = null;
        ByteArrayInputStream xslInStream = null;
        ByteArrayInputStream dataStream = null;
        ByteArrayOutputStream pdfOutStream = null;

        byte outFileTypeByte = 0;
        try {
            fiS = new FileInputStream(new File(filePath));
           // outFileTypeByte = FOProcessor.FORMAT_XLSX;
              if(P_FILE_TYPE.equals("pdf")){
                 outFileTypeByte = FOProcessor.FORMAT_PDF;
             }else if(P_FILE_TYPE.equals("word")){
                 outFileTypeByte = FOProcessor.FORMAT_DOCX;
             }else if(P_FILE_TYPE.equals("excel")){
                 outFileTypeByte = FOProcessor.FORMAT_XLSX;
             }else{
               outFileTypeByte = FOProcessor.FORMAT_XLSX;
             }     
              
            RTFProcessor rtfP = new RTFProcessor(fiS); 
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfP.setOutput(xslOutStream);
            rtfP.process();
            xslInStream = new ByteArrayInputStream(xslOutStream.toByteArray());

            FOProcessor processor = new FOProcessor();
            processor.setConfig("/u01/data/font/xdo.cfg");
            dataStream = new ByteArrayInputStream(xmlData.getBytes());

            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);

            processor.setOutputFormat(outFileTypeByte);
            processor.generate();
            dataBytes = pdfOutStream.toByteArray();
        } catch (XDOException | FileNotFoundException ex) {
            Logger.getLogger(LeaseBookingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return dataBytes;
    }
    
}
