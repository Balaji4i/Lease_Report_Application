/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.reports;
import com.lease.reports.config.BasicInfo;
import com.lease.reports.config.DbPackageCall;
import com.lease.reports.config.GenericRTFReport;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
import java.text.ParseException;
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
//import oracle.xdo.XDOException;
//import oracle.xdo.template.FOProcessor;
//import oracle.xdo.template.RTFProcessor;
/**
 *
 * @author DineshkumarP
 */
@Path("/tenant")
public class TenantMaster {
 
    @Context
    private UriInfo context;
    DbPackageCall dbPackageCall = new DbPackageCall();
    
    @Path("/master")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response TenantMasterDetails(
                            @QueryParam(value = "P_CUST_ID") String P_CUST_ID,
                            @QueryParam(value = "P_ORG_ID") String P_ORG_ID,
                            @QueryParam(value = "P_FILE_TYPE") String P_FILE_TYPE,
                            @QueryParam(value = "P_CUST_NUMBER") String P_CUST_NUMBER
    )throws ParseException{
        
        String fileName = BasicInfo.getSysdate()+"Tenant Master"+P_CUST_NUMBER;
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
    
        String xmlData = DbPackageCall.tenanatMaster(P_CUST_ID, P_ORG_ID);
        String filePath = "/u01/data/reports/lease/Tenant_detail.rtf";
        
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
