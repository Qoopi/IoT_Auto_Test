package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by user on 03.05.2017.
 */
@Listeners(ListenerAPI.class)
public class DashboardTests {
    @Features("CRUD operations with VPV Canvas Dashboard")
    @Test
    public void DashboardCRUDVPVCanvas(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateVPVCanvas());
        requestManagerAPI.checkDashboardCreated();
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }
    @Features("CRUD operations with VPV Kibana Dashboard")
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
    @Features("CRUD operations with GPV Kibana 0,255 Dashboard")
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
    @Features("CRUD operations with GPV Kibana 0,25 Dashboard")
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

    @Features("CRUD operations with GPV Canvas 0,25 Dashboard")
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
    @Features("CRUD operations with GPV Canvas 0,255 Dashboard")
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
