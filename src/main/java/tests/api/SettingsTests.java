package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Listeners;


@Listeners(ListenerAPI.class)
public class SettingsTests {

    public void globalTimeTriggered(){

    }

    public void globalAcknowledged(){
//        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
//        GlobalSettings globalSettings = new GlobalSettings();
//        String before = requestManagerAPI.getGlobalSettings().asString();
//        int ack = globalSettings.parseAcknowledged(before);


    }

    public void equipmentThresholds(){
        //взять запрос с тест старта устанавливающий пороговые значения и улучшить и запилить тест
    }

    public void equipmentFrequencyLabels(){
        //запилить запрос на конкретный экип, запрос на изменение экипа, чек конкретного экипа после
    }
}
