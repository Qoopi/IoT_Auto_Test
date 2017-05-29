package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by user on 03.05.2017.
 */
@Listeners(ListenerAPI.class)
@Title("Dashboards test suite.")
public class DashboardTests {
    @Features("CRUD operations with Dashboard.")
    @Stories("VPV Smart Sensor Dashboard (with zoomable charts, Canvas).")
    @Test
    public void DashboardCRUDVPVCanvas() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateVPVCanvas());
        requestManagerAPI.checkDashboardCreated();
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Features("CRUD operations with Dashboard.")
    @Stories("VPV Smart Sensor Dashboard(Kibana).")
    @Test
    public void dashboardCRUDVPVKibana() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateVPVKibana());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Features("CRUD operations with Dashboard.")
    @Stories("General Vibrations chart - 0-255 range, Kibana.")
    @Test
    public void dashboardCRUDGPVKibana255() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVKibana0255());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Features("CRUD operations with Dashboard.")
    @Stories("General Vibrations chart - 0-25 range, Kibana.")
    @Test
    public void dashboardCRUDGPVKibana25() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVKibana025());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Features("CRUD operations with Dashboard.")
    @Stories("General Vibrations chart - 0-25 range, Canvas.")
    @Test
    public void dashboardCRUDGPVCanvas25() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVCanvas025());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();

    }

    @Features("CRUD operations with Dashboard.")
    @Stories("General Vibrations chart - 0-255 range, Canvas.")
    @Test
    public void dashboardCRUDGPVCanvas255() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVCanvas0255());
        requestManagerAPI.checkDashboardCreated();
//        requestManagerAPI.dashboardUpdate(requestManagerAPI.jsonDashboardUpdateVPVCanvas());
//        requestManagerAPI.checkDashboardUpdated(requestManagerAPI.jsonDashboardUpdatedVPVCanvas());
        requestManagerAPI.dashboardDelete();
        requestManagerAPI.checkDashboardDeleted();
    }

    @Test
    public void dashboardReceivingDataGPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentDataGPV();

    }

    @Test
    public void dashboardReceivingDataVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentDataVPV();

    }
}
