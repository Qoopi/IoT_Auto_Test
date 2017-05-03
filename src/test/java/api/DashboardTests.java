package api;

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

    }

    @Test
    public void DashboardCRUDGPVKibana255(){

    }

    @Test
    public void DashboardCRUDGPVKibana25(){

    }

    @Test
    public void DashboardCRUDGPVCanvas25(){

    }

    @Test
    public void DashboardCRUDGPVCanvas255(){

    }
}
