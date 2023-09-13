/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.reports.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author DineshkumarP
 */
public class DbPackageCall {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static PreparedStatement ps;

        public static Connection getConnectionDS(String datasource) throws SQLException,
            NamingException {
        Connection con = null;
        DataSource data = null;
        Context initialContext = new InitialContext();
        if (initialContext == null) {

        }
        data = (DataSource) initialContext.lookup(datasource);
        if (data != null) {
            con = data.getConnection();
        } else {
            System.out.println("Failed to Find JDBC DataSource.");
        }
        return con;
    }
    
    public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.21.67.79:1533/omnipdb1.606532292.oraclecloud.internal", "xxpl_march", "Xxpl_Mar_30");
         } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return con;
    }
    
    
    
//        public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
//        Connection con = null;
//        try { 
//            Class.forName("oracle.jdbc.driver.OracleDriver"); 
//            con = DriverManager.getConnection("jdbc:oracle:thin:@144.21.67.79:1533/omnipdb1.606532292.oraclecloud.internal", "xxpldw", "Omn_tsT_dw18");
//         } catch (SQLException ex) {
//            ex.printStackTrace();
//        } 
//        return con;
//    }
    
    /*
    * DB Initializer
    */
    
    public static void dbInitialization() throws SQLException, NamingException, ClassNotFoundException {
        connection = getConnectionDS("PRISM_PL");
//        connection = getConnectionDS("PRISM_PL_XXPLDW");
//        connection=getDBConnection();     
    }

    
    
       public static void dbDestroy() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
 
       
    public static String leaseForm(String p_booking_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxlease_report_pkg.XXPL_LEASE_FORM_REPORT('"+ p_booking_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    public static String leaseContract(String p_booking_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxlease_report_pkg.XXPL_LEASE_CONTRACT_REPORT('"+ p_booking_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

        public static String bookingMsID(String p_booking_ms_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPL_NOTIFI_REPORT_PKG.XXPL_MS_NOTIFI('"+ p_booking_ms_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
    
    public static String receiptDetails(String p_receipt_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXLEASE_REPORT_PKG.XXPL_RECEIPT_DETAIL_REPORT('"+ p_receipt_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    
    public static String tenanatMaster(String p_cust_Id,String p_org_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXLEASE_REPORT_PKG.XXPL_TENANT_MASTER_REPORT('"+ p_cust_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
    
    
    
        public static String ccReceiptDBCall(String p_receipt_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPL_NOTIFI_REPORT_PKG.XXPL_CC_RECEIPT('"+ p_receipt_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
    
        public static String receiptSummary(String p_booking_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXLEASE_REPORT_PKG.XXPL_RECEIPT_SUMMARY_REPORT('"+ p_booking_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
        
     public static String oaContractAck(String P_OA_CONTRACT_ID) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPL_NOTIFI_REPORT_PKG.XXPL_CC_ACKNOWLEDGEMENT('"+ P_OA_CONTRACT_ID +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }   
        
        
       
    public static String leaseExten(String p_unit_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxlease_report_pkg.XXPL_LEASE_EXTENSION_REPORT('"+ p_unit_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
        
    
    public static String pdcDBCalling(String P_DATE ) {
            String xmlString = null;
            System.out.println("P_DATE==>"+P_DATE);
        try {
            dbInitialization();
            String sql = "select XXPL_NOTIFI_REPORT_PKG.XXPL_PDC_REMINDER('"+ P_DATE +"') xml from dual";
             System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

        public static String communityChargeDBCalling(String P_DATE ) {
            String xmlString = null;
            System.out.println("P_DATE==>"+P_DATE);
        try {
            dbInitialization();
            String sql = "select XXPL_NOTIFI_REPORT_PKG.XXPL_COMM_NOTIFI('"+ P_DATE +"') xml from dual";
             System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
     public static String pmFeeDBCalling(String P_DATE ) {
            String xmlString = null;
            System.out.println("P_DATE==>"+P_DATE);
        try {
            dbInitialization();
            String sql = "select XXPL_NOTIFI_REPORT_PKG.XXPL_PMFEE_NOTIFI('"+ P_DATE +"') xml from dual";
             System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
     public static String cashCollectionDBCalling(String P_DATE ) {
            String xmlString = null;
            System.out.println("P_DATE==>"+P_DATE);
        try {
            dbInitialization();
            String sql = "select XXPL_NOTIFI_REPORT_PKG.XXPL_CASH_COLLECTION('"+ P_DATE +"') xml from dual";
             System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
     
     
        
    public static String leaseMoveIn(String p_booking_Id) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxlease_report_pkg.XXPL_LEASE_MOVEIN_REPORT('"+ p_booking_Id +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }    
        
        
        
/*
    public static String unitStatus(String P_PROJ_NAME,String P_PROP_NAME) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_report_pkg.XXPRISM_UNIT_STATUS('"+ P_PROJ_NAME +"','"+P_PROP_NAME +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

     public static String inventoryStatus(String P_PROP_NAME,String P_BUILD_NAME) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_report_pkg.XXPRISM_ALL_INVENTORY_STATUS('"+ P_PROP_NAME +"','"+P_BUILD_NAME +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
      public static String spaReport(String P_BLOCK_NUM) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_report_pkg.XXPRISM_SPA_REPORT('"+ P_BLOCK_NUM +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
      
      public static String spaReportArabic(String P_BLOCK_NUM) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_report_pkg.XXPRISM_ARABIC_SPA_REPORT('"+ P_BLOCK_NUM +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
      
      
       public static String arSummary(String P_PROJ_NAME,String P_PROP_NAME, String P_DATE) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_report_pkg.XXPRISM_AR_SUMMARY('"+ P_PROJ_NAME +"','"+ P_PROP_NAME +"','"+P_DATE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
      public static String arDetail(String P_PROJ_NAME,String P_PROP_NAME, String P_DATE) {
        String xmlString = null;
        try {
            dbInitialization();
//            String sql = "select XXPRISM_report_pkg.XXPRISM_AR_DETAIL('"+ P_PROJ_NAME +"','"+P_PROP_NAME +"','To_DATE('"+P_DATE+"'','DD-MM-YYYY')) xml from dual";
            String sql = "select XXPRISM_report_pkg.XXPRISM_AR_DETAIL('"+ P_PROJ_NAME +"','"+P_PROP_NAME +"','"+P_DATE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
      
      public static String customerStatment(String P_PROJ_NAME,String P_DATE) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_REPORT_PKG.XXPRISM_CUSTOMER_STATEMENT('"+ P_PROJ_NAME +"','"+P_DATE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
      
     public static String customerStatmentSummary(String P_PROJ_NAME,String P_DATE) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_REPORT_PKG.XXPRISM_SOA_SUMMARY('"+ P_PROJ_NAME +"','"+P_DATE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    } 
      
      
    public static String unitwisecollection(String P_PROP_NAME,String P_FROM_DATE, String P_DATE) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_report_pkg.XXPRISM_COLLECTION_REPORT('"+ P_PROP_NAME +"','"+P_FROM_DATE +"','"+P_DATE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }  
      
      
      
        public static String receipt(String P_RECP_NUM) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_report_pkg.XXPRISM_RECEIPT_REPORT('"+P_RECP_NUM+"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
         
       
      /**====   
       * 
       * @param P_BU_NAME
       * @param P_INV_NUM
       * @param P_BOOKING_NUM
       * @return 
       */
                /*
      public static String invoiceReport(String P_BU_NAME, String P_INV_NUM, String P_BOOKING_NUM) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_REPORT_PKG.XXPRISM_TAX_INVOICE('"+ P_BU_NAME +"','"+ P_INV_NUM +"','"+ P_BOOKING_NUM +"') xml from dual";
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }   
      
      */
                /*
      public static String errorStatus() {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_REPORT_PKG.XXPRISM_ERROR_STATUS() xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
      
      */
                /*
       public static String saleReport(String ORG_ID, String UNIT_TYPE, String F_DATE, String T_DATE) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_REPORT_PKG.XXPRISM_SALES_REPORT('"+ ORG_ID +"','"+UNIT_TYPE +"','"+F_DATE +"','"+T_DATE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
       */
                /*
        public static String cancellationReport(String P_PROP_NAME, String P_DATE) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXPRISM_REPORT_PKG.XXPRISM_CANCELLATION('"+ P_PROP_NAME +"','"+ P_DATE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
  
        */

}

