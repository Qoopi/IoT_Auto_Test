package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alex Storm on 30.05.2017.
 */
@Listeners(ListenerAPI.class)
public class EquipmentTests {

    @Step("Check if GPV equipment data is present")
    @Test
    public void dataPresentGPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentDataGPV();
    }

    @Step("Check if VPV equipment data is present on all channels")
    @Test
    public void dataPresentVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentDataVPV("1", "0");
        requestManagerAPI.checkEquipmentDataVPV("1", "1");
        requestManagerAPI.checkEquipmentDataVPV("1", "2");
        requestManagerAPI.checkEquipmentDataVPV("1", "3");
        requestManagerAPI.checkEquipmentDataVPV("2", "0");
        requestManagerAPI.checkEquipmentDataVPV("2", "1");
        requestManagerAPI.checkEquipmentDataVPV("2", "2");
        requestManagerAPI.checkEquipmentDataVPV("2", "3");

    }

    @Step("Check if GPV equipment have data in the last 10 minutes")
    @Test
    public void newDataPresentGPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentNewDataGPV();

    }

    @Step("Check if VPV equipment have data in the last 10 minutes on all channels")
    @Test
    public void newDataPresentVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentNewDataVPV("1", "0");
        requestManagerAPI.checkEquipmentNewDataVPV("1", "1");
        requestManagerAPI.checkEquipmentNewDataVPV("1", "2");
        requestManagerAPI.checkEquipmentNewDataVPV("1", "3");
        requestManagerAPI.checkEquipmentNewDataVPV("2", "0");
        requestManagerAPI.checkEquipmentNewDataVPV("2", "1");
        requestManagerAPI.checkEquipmentNewDataVPV("2", "2");
        requestManagerAPI.checkEquipmentNewDataVPV("2", "3");
    }

    @Step("Check if equipment is not deleted")
    @Test
    public void equipmentNotDeletedGPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentNotDeletedGPV();
    }

    @Step("Check if equipment is not deleted")
    @Test
    public void equipmentNotDeletedVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentNotDeletedVPV();
    }
}
