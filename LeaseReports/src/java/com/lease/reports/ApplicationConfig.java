/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.reports;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author DineshkumarP
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.lease.reports.CCReceipt.class);
        resources.add(com.lease.reports.CashCollectionReport.class);
        resources.add(com.lease.reports.CommunityChargeAcknowledgement.class);
        resources.add(com.lease.reports.CommunityChargeReport.class);
        resources.add(com.lease.reports.GenericResource.class);
        resources.add(com.lease.reports.LeaseBookingForm.class);
        resources.add(com.lease.reports.LeaseContract.class);
        resources.add(com.lease.reports.LeaseExtensionReport.class);
        resources.add(com.lease.reports.LeaseInvoice.class);
        resources.add(com.lease.reports.MoveInForm.class);
        resources.add(com.lease.reports.PDCReport.class);
        resources.add(com.lease.reports.PMFeeReport.class);
        resources.add(com.lease.reports.ReceiptDetails.class);
        resources.add(com.lease.reports.ReceiptSummary.class);
        resources.add(com.lease.reports.TenantMaster.class);
    }
    
}
