package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 03.05.2017.
 */
@Listeners(ListenerAPI.class)
public class DashboardTests {

    @Test
    public void DashboardCRUDVPVCanvas(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateVPVCanvas());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Test
    public void DashboardCRUDVPVKibana(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateVPVKibana());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Test
    public void DashboardCRUDGPVKibana255(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVKibana0255());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Test
    public void DashboardCRUDGPVKibana25(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVKibana025());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }


    @Test
    public void DashboardCRUDGPVCanvas25(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVCanvas025());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();

    }

    @Test
    public void DashboardCRUDGPVCanvas255(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVCanvas0255());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }
}
