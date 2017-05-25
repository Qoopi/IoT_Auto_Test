package mechanics.system.http;

import com.google.gson.JsonObject;
import mechanics.system.aws.SignAWSv4;
import mechanics.system.constant.AssembledEquipments;
import mechanics.system.readers.Credentials;
import org.jglue.fluentjson.JsonBuilderFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class JSONHandler extends SignAWSv4 {
    private String defaultDashboardVPVName = "someAutoTestNameVPV";
    private String defaultDashboardVPVDescription = "someAutoTestDescriptionVPV";
    private String defaultDashboardGPVName = "someAutoTestNameGPV";
    private String defaultDashboardGPVDescription = "someAutoTestDescriptionGPV";

    private String testEmail = new Credentials().getCredentials().get("test_email");
    private String thingVpv = AssembledEquipments.equipmentVpv;
    private String thingGpv = AssembledEquipments.equipmentGpv;


    public JsonObject reportCreate(String templateId, String equipment, String name) {
//        String jsonBody = "{\"templateId\":\"Vacuum-Pump-Vibration-Report---Optimized-for-Printing---Daily\",\"emaillist\":\"vasya.ossystem@gmasill.com\"
// ,\"filter\":\"equipmentId:"+thingGPV+"\",\"filter_name\":\"Vacuum-Pump-Vibration-Report-List---Optimized-for-Printing---Daily\",\"excelEnabled\":false}";

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("templateId", templateId)
                .add("emaillist", testEmail)
                .add("filter", "equipmentId:" + equipment)
                .add("filter_name", name)
                .add("excelEnabled", false)
                .getJson();
        return jsonObject;
    }

    public JsonObject reportSendNow(String id, String templateId, String equipment, String name) {
        // "{\"filterId\":\""+idOfCreatedReport+"\",\"templateId\":\"GPV-Smart-Sensor-Report-15-minutes-activity-1\",\"emaillist\":\"geloksmmm@gmail.com,kov.ossystem@gmail.com\",
        // \"filter\":\"equipmentId:"+thingGPV+"\",\"filter_name\":\"GPV-Smart-Sensor-Report-List-15-minutes\",\"excelEnabled\":false}";

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("filterId", id)
                .add("templateId", templateId)
                .add("emaillist", testEmail)
                .add("filter", "equipmentId:" + equipment)
                .add("filter_name", name)
                .add("excelEnabled", false)
                .getJson();
        return jsonObject;
    }

    public JsonObject reportDelete(String name, String title, String equipments, String filterId, String emails, String userId) {
        //{"filter_name":"Vacuum-Pump-Vibration-Report-List---Optimized-for-Printing---Weekly",
        // "filterTitle":"Vacuum-Pump-Vibration-Report-List---Optimized-for-Printing---Weekly kov.ossystem@gmail.com",
        // "equipments":"Thing-000011-i1",
        // "id":null,
        // "filterId":"173ba9ae-6abb-40fa-b194-479403c58b4c",
        // "emails":"kov.ossystem@gmail.com",
        // "userId":"bbc046ce-daff-4223-a144-ae453ea8a32b",
        // "createdAt":null,
        // "excelIncluded":null}
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("filter_name", name)
                .add("filterTitle", title)
                .add("equipments", equipments)
                .add("id", "")
                .add("filterId", filterId)
                .add("emails", emails)
                .add("userId", userId)
                .add("createdAt", "")
                .add("excelIncluded", "")
                .getJson();
        return jsonObject;
    }

    public String getIdOfCreatedNotificationRule(String response) {
        JSONObject jsonObject = parseToJSONObject(response);
        String id = jsonObject.get("id").toString();
        return id;
    }

    public String getIdOfCreatedDashboard(String response) {
        JSONObject jsonObject = parseToJSONObject(response);
        JSONObject item = (JSONObject) jsonObject.get("item");
        String id = item.get("id").toString();
        return id;
    }

    //not implemented because skedler scenarios are not used
    public String getIdOfCreatedReport(String response) {
        String id = null;
        return id;
    }

    public ArrayList<String> getIdsOfAllNotifications(String response) {
        JSONArray jsonArray = parseToJSONArray(response);
        ArrayList<String> ids = new ArrayList<>();
        for (Object aJsonArray : jsonArray) {
            JSONObject jsonObject = parseToJSONObject(aJsonArray.toString());
            String id = jsonObject.get("id").toString();
            ids.add(id);
        }
        return ids;
    }

//    @Test
//    public void test(){
//        String body = "[{\"id\":\"Thing-000013-i3\",\"equipmentId\":\"VPV-013\",\"name\":\"Pump D13\",\"model\":\"r2d4\",\"equipmentGroup\":\"Aquatics\",\"equipmentType\":\"VPV Sensor\",\"equipmentTypeId\":\"manu\",\"isDataTransfer\":1,\"isConnected\":1,\"lastConnectedAt\":1495695376181,\"isActive\":1,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":88,\"plannedDownTime\":88,\"rejectedUnitCount\":88,\"idealRunRate\":88,\"idealCycleRate\":88,\"channels\":[{\"id\":1,\"maxDistanceAlarmLevel\":30,\"maxDistanceAbortLevel\":60,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]},{\"id\":2,\"maxDistanceAlarmLevel\":30,\"maxDistanceAbortLevel\":60,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]}],\"type\":1,\"topics\":{\"reset\":\"Set/U000001/MRL/Lab/ATMRobot/002/VPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/MRL/Lab/ATMRobot/002\"},\"lastAbortAlarmState\":{\"abort\":0,\"alarm\":1},\"createdAt\":1490262810728,\"updatedAt\":1495695376181},{\"id\":\"Thing-090093-0\",\"equipmentId\":\"lj\",\"name\":\"Oleg Datastream\",\"equipmentGroup\":\"klj\",\"equipmentType\":\"klj\",\"equipmentTypeId\":\"kljkl\",\"isDataTransfer\":1,\"isConnected\":1,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/jkh/kj/jh/kljkl/lj/GPV/RESET\",\"heartbeat\":\"Heartbeat/jkh/kj/jh/FGW/Thing-090173\"},\"updatedAt\":1494501818612},{\"id\":\"Thing-000011-i1\",\"equipmentId\":\"VPV-011\",\"name\":\"Pump D11\",\"equipmentGroup\":\"East2\",\"equipmentType\":\"VPV Sensor\",\"equipmentTypeId\":\"SIM\",\"isDataTransfer\":1,\"isConnected\":1,\"lastConnectedAt\":1495636101425,\"isActive\":1,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":68,\"plannedDownTime\":68,\"rejectedUnitCount\":68,\"idealRunRate\":68,\"idealCycleRate\":68,\"channels\":[{\"id\":1,\"maxDistanceAlarmLevel\":75,\"maxDistanceAbortLevel\":120,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"fre_1\",\"frequency\":1000},{\"id\":2,\"name\":\"fre_2\",\"frequency\":2000},{\"id\":3,\"name\":\"fre_3\",\"frequency\":3000},{\"id\":4,\"name\":\"fre_4\",\"frequency\":4000},{\"id\":5,\"name\":\"fre_5\",\"frequency\":5000},{\"id\":6,\"name\":\"fre_6\",\"frequency\":6000},{\"id\":7,\"name\":\"fre_7\",\"frequency\":7000},{\"id\":8,\"name\":\"fre_8\",\"frequency\":8000},{\"id\":9,\"name\":\"fre_9\",\"frequency\":9000},{\"id\":10,\"name\":\"fre_10\",\"frequency\":10000}]},{\"id\":2,\"maxDistanceAlarmLevel\":75,\"maxDistanceAbortLevel\":120,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"B.fre_1\",\"frequency\":1000},{\"id\":2,\"name\":\"5000\",\"frequency\":2000},{\"id\":3,\"name\":\"B.fre_3\",\"frequency\":3000},{\"id\":4,\"name\":\"1000\",\"frequency\":4000},{\"id\":5,\"name\":\"B.fre_5\",\"frequency\":5000},{\"id\":6,\"name\":\"B.fre_6\",\"frequency\":6000},{\"id\":7,\"name\":\"B.fre_7\",\"frequency\":7000},{\"id\":8,\"name\":\"B.fre_8\",\"frequency\":8000},{\"id\":9,\"name\":\"B.fre_9\",\"frequency\":9000},{\"id\":10,\"name\":\"B.fre_10\",\"frequency\":10000}]}],\"type\":1,\"topics\":{\"reset\":\"Set/U000001/ODS/Lab/ATMRobot/001/VPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/ODS/Lab/ATMRobot/001\"},\"lastAbortAlarmState\":{\"abort\":0,\"alarm\":0},\"updatedAt\":1495694643518},{\"id\":\"Thing-000012-i2\",\"equipmentId\":\"VPV-012\",\"name\":\"Pump D12\",\"equipmentGroup\":\"East2\",\"equipmentType\":\"VPV Sensor\",\"equipmentTypeId\":\"V001\",\"isDataTransfer\":1,\"isConnected\":1,\"lastConnectedAt\":1495695372418,\"isActive\":0,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":82,\"plannedDownTime\":13,\"rejectedUnitCount\":14,\"idealRunRate\":14,\"idealCycleRate\":5,\"channels\":[{\"id\":1,\"maxDistanceAlarmLevel\":110,\"maxDistanceAbortLevel\":146,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]},{\"id\":2,\"maxDistanceAlarmLevel\":30,\"maxDistanceAbortLevel\":90,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]}],\"type\":1,\"topics\":{\"reset\":\"Set/U000001/ODS/Lab/ATMRobot/002/VPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/ODS/Lab/ATMRobot/002\"},\"lastAbortAlarmState\":{\"abort\":1,\"alarm\":1},\"updatedAt\":1495695372418},{\"id\":\"Thing-090106-1\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611},{\"id\":\"Thing-090126-0\",\"equipmentId\":\"klj\",\"name\":\"kljl\",\"equipmentGroup\":\"ljkl\",\"equipmentType\":\"klj\",\"equipmentTypeId\":\"klj\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611},{\"id\":\"Thing-090173-0\",\"equipmentId\":\"lj\",\"name\":\"kljlk\",\"equipmentGroup\":\"klj\",\"equipmentType\":\"klj\",\"equipmentTypeId\":\"kljkl\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/jkh/kj/jh/kljkl/lj/GPV/RESET\",\"heartbeat\":\"Heartbeat/jkh/kj/jh/FGW/Thing-090173\"},\"updatedAt\":1494501818612},{\"id\":\"Thing-090136-0\",\"equipmentId\":\"kj\",\"name\":\"kjiljk\",\"equipmentGroup\":\"kljkl\",\"equipmentType\":\"kjkj\",\"equipmentTypeId\":\"klj\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611},{\"id\":\"Thing-090095-0\",\"equipmentId\":\"ABC1122\",\"name\":\"Pump 50\",\"equipmentGroup\":\"Area 4\",\"equipmentType\":\"Ebara\",\"equipmentTypeId\":\"80x24\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/customerXYZ/Austin Mill Road/Chip Building/80x24/ABC1122/GPV/RESET\",\"heartbeat\":\"Heartbeat/customerXYZ/Austin Mill Road/Chip Building/FGW/Thing-090095\"},\"updatedAt\":1494501818611},{\"id\":\"Thing-090135-0\",\"equipmentId\":\"ghhg\",\"name\":\"lk;lklk\",\"equipmentGroup\":\"kl;lk;\",\"equipmentType\":\"hg\",\"equipmentTypeId\":\"hg\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/hg/hg/hg/hg/ghhg/GPV/RESET\"},\"updatedAt\":1494501818611},{\"id\":\"Thing-090107-0\",\"equipmentId\":\"ucore\",\"name\":\"ucore\",\"equipmentGroup\":\"ucore\",\"equipmentType\":\"ucore\",\"equipmentTypeId\":\"ucore\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/ucore/ucore/ucore/ucore/ucore/GPV/RESET\",\"heartbeat\":\"Heartbeat/ucore/ucore/ucore/FGW/Thing-090107\"},\"updatedAt\":1494501818611},{\"id\":\"Thing-090175-0\",\"equipmentId\":\"Thing00099\",\"name\":\"Test OSS\",\"equipmentTypeId\":\"Misc\",\"isDataTransfer\":1,\"isConnected\":1,\"isActive\":0,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":35,\"plannedDownTime\":43,\"rejectedUnitCount\":34,\"idealRunRate\":53,\"idealCycleRate\":55,\"maxDistanceAlarmLevel\":50,\"type\":2,\"topics\":{\"reset\":\"Set/U000001/OSS/Lab/Misc/Thing00099/GPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/OSS/Lab/FGW/Thing-090175\"},\"lastAbortAlarmState\":{\"abort\":0,\"alarm\":0},\"createdAt\":1494850754985,\"updatedAt\":1495694660433},{\"id\":\"Thing-090020-1\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818597},{\"id\":\"Thing-090093-1\",\"equipmentId\":\"ABC1235\",\"name\":\"Pump 11\",\"equipmentGroup\":\"Area 4\",\"equipmentType\":\"Ebara\",\"equipmentTypeId\":\"80x24\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611}]";
//        String equip = "Thing-000011-i1";
//        String result = changeThresholdVPV(body, equip, 90, 95, 120, 125);
//        System.out.println(result);
//    }

    //костыль, переписать полностью, если нужны будут изменения
    public String changeThresholdVPV(String response, String equipmentId, int newMaxDistanceAlarmLevelMain, int newMaxDistanceAlarmLevelBlower, int newMaxDistanceAbortLevelMain, int newMaxDistanceAbortLevelBlower) {
        JSONArray array = parseToJSONArray(response);
        JSONObject object;
        String result = null;
        boolean found = false;


        for (int i = 0; i <= array.size() - 1; i++) {
            if (!found) {
                object = (JSONObject) array.get(i);
                if (object.containsValue(equipmentId)) {
                    JSONArray array1 = (JSONArray) object.get("channels");
                    for (int i1 = 0; i1 <= array1.size() - 1; i1++) {
                        if (array1.get(i1).toString().contains("maxDistanceAlarmLevel") && array1.get(i1).toString().contains("maxDistanceAbortLevel")) {
                            JSONObject obj = (JSONObject) array1.get(i1);
                            if (obj.get("id").toString().equals("1")) {
                                obj.replace("maxDistanceAlarmLevel", newMaxDistanceAlarmLevelMain);
                                obj.replace("maxDistanceAbortLevel", newMaxDistanceAbortLevelMain);
                                array1.set(i1, obj);
                            }
                            if (obj.get("id").toString().equals("2")) {

                                obj.replace("maxDistanceAlarmLevel", newMaxDistanceAlarmLevelBlower);
                                obj.replace("maxDistanceAbortLevel", newMaxDistanceAbortLevelBlower);
                                array1.set(i1, obj);
                            }
                        }
                    }
                    object.replace("channels", array1);

                    result = "{\"items\": [" + object.toJSONString() + "]}";
                }
            }
        }
        return result;
    }

//    @Test
//    public void test1(){
//        String payload = "[{\"id\":\"Thing-000013-i3\",\"equipmentId\":\"VPV-013\",\"name\":\"Pump D13\",\"model\":\"r2d4\",\"equipmentGroup\":\"Aquatics\",\"equipmentType\":\"VPV Sensor\",\"equipmentTypeId\":\"manu\",\"isDataTransfer\":1,\"isConnected\":1,\"lastConnectedAt\":1495702247760,\"isActive\":1,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":88,\"plannedDownTime\":88,\"rejectedUnitCount\":88,\"idealRunRate\":88,\"idealCycleRate\":88,\"channels\":[{\"id\":1,\"maxDistanceAlarmLevel\":30,\"maxDistanceAbortLevel\":60,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]},{\"id\":2,\"maxDistanceAlarmLevel\":30,\"maxDistanceAbortLevel\":60,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]}],\"type\":1,\"topics\":{\"reset\":\"Set/U000001/MRL/Lab/ATMRobot/002/VPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/MRL/Lab/ATMRobot/002\"},\"lastAbortAlarmState\":{\"abort\":0,\"alarm\":1},\"createdAt\":1490262810728,\"updatedAt\":1495702247761},{\"id\":\"Thing-090093-0\",\"equipmentId\":\"lj\",\"name\":\"Oleg Datastream\",\"equipmentGroup\":\"klj\",\"equipmentType\":\"klj\",\"equipmentTypeId\":\"kljkl\",\"isDataTransfer\":1,\"isConnected\":1,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/jkh/kj/jh/kljkl/lj/GPV/RESET\",\"heartbeat\":\"Heartbeat/jkh/kj/jh/FGW/Thing-090173\"},\"updatedAt\":1494501818612},{\"id\":\"Thing-000011-i1\",\"equipmentId\":\"VPV-011\",\"name\":\"Pump D11\",\"equipmentGroup\":\"East2\",\"equipmentType\":\"VPV Sensor\",\"equipmentTypeId\":\"SIM\",\"isDataTransfer\":1,\"isConnected\":1,\"lastConnectedAt\":1495636101425,\"isActive\":1,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":68,\"plannedDownTime\":68,\"rejectedUnitCount\":68,\"idealRunRate\":68,\"idealCycleRate\":68,\"channels\":[{\"id\":1,\"maxDistanceAlarmLevel\":90,\"maxDistanceAbortLevel\":120,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"fre_1\",\"frequency\":1000},{\"id\":2,\"name\":\"fre_2\",\"frequency\":2000},{\"id\":3,\"name\":\"fre_3\",\"frequency\":3000},{\"id\":4,\"name\":\"fre_4\",\"frequency\":4000},{\"id\":5,\"name\":\"fre_5\",\"frequency\":5000},{\"id\":6,\"name\":\"fre_6\",\"frequency\":6000},{\"id\":7,\"name\":\"fre_7\",\"frequency\":7000},{\"id\":8,\"name\":\"fre_8\",\"frequency\":8000},{\"id\":9,\"name\":\"fre_9\",\"frequency\":9000},{\"id\":10,\"name\":\"fre_10\",\"frequency\":10000}]},{\"id\":2,\"maxDistanceAlarmLevel\":95,\"maxDistanceAbortLevel\":125,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"B.fre_1\",\"frequency\":1000},{\"id\":2,\"name\":\"bloo_2000\",\"frequency\":2000},{\"id\":3,\"name\":\"B.fre_3\",\"frequency\":3000},{\"id\":4,\"name\":\"blow_4000\",\"frequency\":4000},{\"id\":5,\"name\":\"B.fre_5\",\"frequency\":5000},{\"id\":6,\"name\":\"B.fre_6\",\"frequency\":6000},{\"id\":7,\"name\":\"B.fre_7\",\"frequency\":7000},{\"id\":8,\"name\":\"B.fre_8\",\"frequency\":8000},{\"id\":9,\"name\":\"B.fre_9\",\"frequency\":9000},{\"id\":10,\"name\":\"B.fre_10\",\"frequency\":10000}]}],\"type\":1,\"topics\":{\"reset\":\"Set/U000001/ODS/Lab/ATMRobot/001/VPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/ODS/Lab/ATMRobot/001\"},\"lastAbortAlarmState\":{\"abort\":0,\"alarm\":0},\"updatedAt\":1495702103295},{\"id\":\"Thing-000012-i2\",\"equipmentId\":\"VPV-012\",\"name\":\"Pump D12\",\"equipmentGroup\":\"East2\",\"equipmentType\":\"VPV Sensor\",\"equipmentTypeId\":\"V001\",\"isDataTransfer\":1,\"isConnected\":1,\"lastConnectedAt\":1495702244003,\"isActive\":0,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":82,\"plannedDownTime\":13,\"rejectedUnitCount\":14,\"idealRunRate\":14,\"idealCycleRate\":5,\"channels\":[{\"id\":1,\"maxDistanceAlarmLevel\":110,\"maxDistanceAbortLevel\":146,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]},{\"id\":2,\"maxDistanceAlarmLevel\":30,\"maxDistanceAbortLevel\":90,\"filteredMaxDistanceAlarmLevel\":0,\"filteredMaxDistanceAbortLevel\":0,\"rmsDistanceAlarmLevel\":0,\"rmsDistanceAbortLevel\":0,\"filteredRmsDistanceAlarmLevel\":0,\"filteredRmsDistanceAbortLevel\":0,\"freqs\":[{\"id\":1,\"name\":\"frequency_1\",\"frequency\":1000},{\"id\":2,\"name\":\"frequency_2\",\"frequency\":2000},{\"id\":3,\"name\":\"frequency_3\",\"frequency\":3000},{\"id\":4,\"name\":\"frequency_4\",\"frequency\":4000},{\"id\":5,\"name\":\"frequency_5\",\"frequency\":5000},{\"id\":6,\"name\":\"frequency_6\",\"frequency\":6000},{\"id\":7,\"name\":\"frequency_7\",\"frequency\":7000},{\"id\":8,\"name\":\"frequency_8\",\"frequency\":8000},{\"id\":9,\"name\":\"frequency_9\",\"frequency\":9000},{\"id\":10,\"name\":\"frequency_10\",\"frequency\":10000}]}],\"type\":1,\"topics\":{\"reset\":\"Set/U000001/ODS/Lab/ATMRobot/002/VPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/ODS/Lab/ATMRobot/002\"},\"lastAbortAlarmState\":{\"abort\":1,\"alarm\":0},\"updatedAt\":1495702244003},{\"id\":\"Thing-090106-1\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611},{\"id\":\"Thing-090126-0\",\"equipmentId\":\"klj\",\"name\":\"kljl\",\"equipmentGroup\":\"ljkl\",\"equipmentType\":\"klj\",\"equipmentTypeId\":\"klj\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611},{\"id\":\"Thing-090173-0\",\"equipmentId\":\"lj\",\"name\":\"kljlk\",\"equipmentGroup\":\"klj\",\"equipmentType\":\"klj\",\"equipmentTypeId\":\"kljkl\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/jkh/kj/jh/kljkl/lj/GPV/RESET\",\"heartbeat\":\"Heartbeat/jkh/kj/jh/FGW/Thing-090173\"},\"updatedAt\":1494501818612},{\"id\":\"Thing-090136-0\",\"equipmentId\":\"kj\",\"name\":\"kjiljk\",\"equipmentGroup\":\"kljkl\",\"equipmentType\":\"kjkj\",\"equipmentTypeId\":\"klj\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611},{\"id\":\"Thing-090095-0\",\"equipmentId\":\"ABC1122\",\"name\":\"Pump 50\",\"equipmentGroup\":\"Area 4\",\"equipmentType\":\"Ebara\",\"equipmentTypeId\":\"80x24\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/customerXYZ/Austin Mill Road/Chip Building/80x24/ABC1122/GPV/RESET\",\"heartbeat\":\"Heartbeat/customerXYZ/Austin Mill Road/Chip Building/FGW/Thing-090095\"},\"updatedAt\":1494501818611},{\"id\":\"Thing-090135-0\",\"equipmentId\":\"ghhg\",\"name\":\"lk;lklk\",\"equipmentGroup\":\"kl;lk;\",\"equipmentType\":\"hg\",\"equipmentTypeId\":\"hg\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/hg/hg/hg/hg/ghhg/GPV/RESET\"},\"updatedAt\":1494501818611},{\"id\":\"Thing-090107-0\",\"equipmentId\":\"ucore\",\"name\":\"ucore\",\"equipmentGroup\":\"ucore\",\"equipmentType\":\"ucore\",\"equipmentTypeId\":\"ucore\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"type\":2,\"topics\":{\"reset\":\"Set/ucore/ucore/ucore/ucore/ucore/GPV/RESET\",\"heartbeat\":\"Heartbeat/ucore/ucore/ucore/FGW/Thing-090107\"},\"updatedAt\":1494501818611},{\"id\":\"Thing-090175-0\",\"equipmentId\":\"Thing00099\",\"name\":\"Test OSS\",\"equipmentTypeId\":\"Misc\",\"isDataTransfer\":1,\"isConnected\":1,\"isActive\":0,\"monitor\":0,\"isDeleted\":0,\"plannedProductionTime\":35,\"plannedDownTime\":43,\"rejectedUnitCount\":34,\"idealRunRate\":53,\"idealCycleRate\":55,\"maxDistanceAlarmLevel\":50,\"type\":2,\"topics\":{\"reset\":\"Set/U000001/OSS/Lab/Misc/Thing00099/GPV/RESET\",\"heartbeat\":\"Heartbeat/U000001/OSS/Lab/FGW/Thing-090175\"},\"lastAbortAlarmState\":{\"abort\":0,\"alarm\":0},\"createdAt\":1494850754985,\"updatedAt\":1495702047905},{\"id\":\"Thing-090020-1\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818597},{\"id\":\"Thing-090093-1\",\"equipmentId\":\"ABC1235\",\"name\":\"Pump 11\",\"equipmentGroup\":\"Area 4\",\"equipmentType\":\"Ebara\",\"equipmentTypeId\":\"80x24\",\"isDataTransfer\":1,\"isConnected\":0,\"isDeleted\":0,\"topics\":{},\"updatedAt\":1494501818611}]";
//        String equip = "";
//        String result = changeThresholdGPV(payload, "Thing-090175-0", 666);
//        System.out.println(result);
//    }

    public String changeThresholdGPV(String response, String equipmentId, int newMaxDistanceAlarmLevel) {
        JSONArray array = parseToJSONArray(response);
        JSONObject object;
        String result = null;
        boolean found = false;


        for (int i = 0; i <= array.size() - 1; i++) {
            if (!found) {
                object = (JSONObject) array.get(i);
                if (object.containsValue(equipmentId) && object.containsKey("maxDistanceAlarmLevel")) {
                    object.replace("maxDistanceAlarmLevel", newMaxDistanceAlarmLevel);
                    result = "{\"items\": [" + object.toJSONString() + "]}";
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private JSONArray parseToJSONArray(String jsonString) {
        JSONParser parser = new JSONParser();
        JSONArray jsonObject = null;
        try {
            jsonObject = (JSONArray) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private JSONObject parseToJSONObject(String jsonString) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public String notificationListAcknowledgeAllJSON(ArrayList<String> arrayList) {
        String jsonString = "{\"items\":[";
        for (int i = 0; i < arrayList.size(); i++) {
            jsonString = jsonString + "{\"id\":\"" + arrayList.get(i) + "\",\"status\":1}";
            if (arrayList.size() > i + 1) {
                jsonString = jsonString + ",";

            }
        }
        return jsonString + "]}";
    }

    public String notificationListDeleteAllJSON(ArrayList<String> arrayList) {
        String jsonString = "{\"items\":[";
        for (int i = 0; i < arrayList.size(); i++) {
            jsonString = jsonString + "{\"id\":\"" + arrayList.get(i) + "\"}";
            if (arrayList.size() > i + 1) {
                jsonString = jsonString + ",";
            }
        }
        return jsonString + "]}";
    }

    public String notificationRuleCreateJSONDefault() {
        String name = "Abnormal auto-test rule";
        String description = "some description";
        int type = 0;
        int channel = 0;
        String equipment = "Thing-90094-0";
        int threshold = 0;
        String trigger = "";
        String operation = ">=";
        int value = 0;
        int period = 0;
        int sensor = 1;
        return notificationRuleCreateJSON(name, description, type, channel, equipment, threshold, trigger, operation, value, period, sensor).toString();
    }


    public JsonObject notificationRuleCreateJSON(String name, String description, int type, int channel, String equipment, int threshold, String trigger, String operation, int value, int period, int sensor) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("active", true)
                .add("name", name)
                .add("description", description)
                .add("notificationType", 0)
                .add("type", type)
                .addArray("phones")
                .addObject().add("value", "+380634953177").add("name", "My Lifecell").end().end()
                .addArray("emails")
                .addObject().add("value", testEmail).add("name", "hhhhhhhhhhhhh").end().end()
                .addObject("notifications").add("alwaysSend", false).add("triggered", 10).add("acknowledged", 0).add("sms", false).add("emails", true).end()
                .addArray("equipmentIds").add(equipment).end()
                .add("channel", channel)
                .add("frq", 0)
                .add("threshold", threshold)
                .add("trigger", trigger)
                .add("operation", operation)
                .add("value", value)
                .add("period", period)
                .add("sensor", sensor).getJson();
        return jsonObject;
    }

    public JsonObject notificationRuleCreateJSON(String name, String description, int type, String channel, String equipment, String threshold, String trigger, String operation, int value, int period, int sensor) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("active", true)
                .add("name", name)
                .add("description", description)
                .add("notificationType", 0)
                .add("type", type)
                .addArray("phones")
                .addObject().add("value", "+380634953177").add("name", "My Lifecell").end().end()
                .addArray("emails")
                .addObject().add("value", testEmail).add("name", "hhhhhhhhhhhhh").end().end()
                .addObject("notifications").add("alwaysSend", false).add("triggered", 10).add("acknowledged", 0).add("sms", false).add("emails", true).end()
                .addArray("equipmentIds").add(equipment).end()
                .add("channel", channel)
                .add("frq", 0)
                .add("threshold", threshold)
                .add("trigger", trigger)
                .add("operation", operation)
                .add("value", value)
                .add("period", period)
                .add("sensor", sensor).getJson();
        return jsonObject;
    }


    public String notificationRuleUpdateJSON(String id) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items")
                .addObject()
                .add("id", id)
                .add("active", 1)
                .add("name", "Abnormal auto-test rule")
                .add("description", "some description")
                .add("notificationType", 0)
                .add("type", 0)
                .addArray("phones").addObject().add("value", "+380634953177").add("name", "My Lifecell").end().end()
                .addArray("emails").addObject().add("value", testEmail).add("name", "hhhhhhhhhhhhh").end().end()
                .addObject("notifications").add("alwaysSend", false).add("triggered", 10).add("acknowledged", 15).add("globalSettings", 0).add("sms", false).add("emails", false).end()
                .addArray("equipmentIds").add("Thing-090011-0").end()
                .add("channel", 0)
                .add("frq", 0)
                .add("threshold", 0)
                .add("trigger", "")
                .add("operation", ">=")
                .add("value", 30)
                .add("period", 0).add("sensor", 1).getJson();
        return jsonObject.toString();
    }

    public String notificationRuleDeleteJSON(String id) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id", id).getJson();
        return jsonObject.toString();
    }

    public String dashboardCreateCanvasVPVJSONDefault() {
        String thingVPV1 = thingVpv;
        String name = defaultDashboardVPVName;
        String description = defaultDashboardVPVDescription;

        return dashboardCreateCanvasVPVJSON(thingVPV1, name, description).toString();
    }

    private JsonObject dashboardCreateCanvasVPVJSON(String thingVPV1, String name, String description) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 7)
                .addArray("equipmentIds").add(thingVPV1).end()
                .add("name", name)
                .add("description", description).getJson();
        return jsonObject;
    }

    public String dashboardCreateCanvasGPVJSONDefault() {
        String thingGPV = thingGpv;
        String name = defaultDashboardGPVName;
        String description = defaultDashboardGPVDescription;

        return dashboardCreateCanvasGPVJSON(thingGPV, name, description).toString();
    }

    public String dashboardCreateCanvasGPVJSONDefault(String equipmentId) {
        String name = defaultDashboardGPVName;
        String description = defaultDashboardGPVDescription;

        return dashboardCreateCanvasGPVJSON(equipmentId, name, description).toString();
    }

    public String dashboardCreateCanvasGPVJSONDefault(String equipmentId, String description) {
        String name = defaultDashboardGPVName;

        return dashboardCreateCanvasGPVJSON(equipmentId, name, description).toString();
    }

    private JsonObject dashboardCreateCanvasGPVJSON(String thingGPV, String name, String description) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 9)
                .addArray("equipmentIds").add(thingGPV).end()
                .add("name", name).add("description", description).getJson();
        return jsonObject;
    }

    public JsonObject dashboardCreate(int dashboardType, String equipmentId, String name, String description) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", dashboardType)
                .addArray("equipmentIds").add(equipmentId).end()
                .add("name", name).add("description", description).getJson();
        return jsonObject;

    }

    public String dashboardDeleteJSON(String id) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id", id).getJson();
        return jsonObject.toString();
    }

    public String equipmentOnOff(String id, Boolean active) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id", id).add("isDataTransfer", active).getJson();

        return jsonObject.toString();
    }

}
