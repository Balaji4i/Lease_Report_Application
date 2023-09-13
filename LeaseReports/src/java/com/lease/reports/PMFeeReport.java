/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.reports;
import javax.ws.rs.Path;
import com.lease.reports.config.BasicInfo;
import com.lease.reports.config.DbPackageCall;
import com.lease.reports.config.GenericRTFReport;
//import oracle.xdo.XDOException;
//import oracle.xdo.template.FOProcessor;
//import oracle.xdo.template.RTFProcessor;

//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


/**
 *
 * @author DineshkumarP
 */
@Path("/pmfee")
public class PMFeeReport {
    
    DbPackageCall dbPackageCall = new DbPackageCall();
        
    @Path("/report")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response pmFeeProcess(
             @QueryParam(value = "P_DATE") String P_DATE,
             @QueryParam(value = "P_FILE_TYPE") String P_FILE_TYPE
             ) throws ParseException{
        
        String fileName = BasicInfo.getSysdate()+" "+" PM Fee Report";
        
        if(P_FILE_TYPE.equals("pdf")){
            fileName = fileName +".pdf";
        }else if(P_FILE_TYPE.equals("word")){
            fileName = fileName +".doc";
        }else if(P_FILE_TYPE.equals("excel")){
            fileName = fileName +".xlsx";
        }else{
            fileName = fileName +".xlsx";
        }
        
//        //-- Date
//        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
//        java.util.Date date = parser.parse(P_DATE);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
//        String dateParam = formatter.format(date);
//        SimpleDateFormat pkgFormatter = new SimpleDateFormat("dd-MMM-yyyy");
//        String dateFormat = pkgFormatter.format(date);
//        System.out.println("Date--"+dateParam);
       // String fileName = P_PROJ_NAME +".xlsx";
        
        String xmlData = DbPackageCall.pmFeeDBCalling(P_DATE);
        String filePath = "/u01/data/reports/lease/PM_FEE.rtf";
        
        if(xmlData!=null){
            Response.ResponseBuilder builder = Response.ok(GenericRTFReport.rtfReportByte(xmlData, filePath, P_FILE_TYPE));
            builder.header("Content-Disposition", "attachment; filename=" + fileName);
            return builder.build();            
        }else{
            Response.ResponseBuilder builder = Response.ok(BasicInfo.responseToRest("No data found"));
            return builder.build();
        }
    }
    
}
