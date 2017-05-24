package mechanics.system.http;

import com.google.gson.JsonObject;
import mechanics.system.aws.SignAWSv4;
import mechanics.system.constant.AssembledEquipments;
import org.jglue.fluentjson.JsonBuilderFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class JSONHandler extends SignAWSv4 {
    private String defaultDashboardVPVName = "someAutoTestNameVPV";
    private String defaultDashboardVPVDescription = "someAutoTestDescriptionVPV";
    private String defaultDashboardGPVName = "someAutoTestNameGPV";
    private String defaultDashboardGPVDescription = "someAutoTestDescriptionGPV";

    private String testEmail = "kov.iot.sys@gmail.com";
    private String thingVpv = AssembledEquipments.equipmentVpv;
    private String thingGpv = AssembledEquipments.equipmentGpv;


    public JsonObject reportCreate(String templateId, String equipment, String name){
//        String jsonBody = "{\"templateId\":\"Vacuum-Pump-Vibration-Report---Optimized-for-Printing---Daily\",\"emaillist\":\"vasya.ossystem@gmasill.com\"
// ,\"filter\":\"equipmentId:"+thingGPV+"\",\"filter_name\":\"Vacuum-Pump-Vibration-Report-List---Optimized-for-Printing---Daily\",\"excelEnabled\":false}";

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("templateId", templateId)
                .add("emaillist", testEmail)
                .add("filter", "equipmentId:"+equipment)
                .add("filter_name", name)
                .add("excelEnabled", false)
                .getJson();
        return jsonObject;
    }

    public JsonObject reportSendNow(String id, String templateId, String equipment, String name){
        // "{\"filterId\":\""+idOfCreatedReport+"\",\"templateId\":\"GPV-Smart-Sensor-Report-15-minutes-activity-1\",\"emaillist\":\"geloksmmm@gmail.com,kov.ossystem@gmail.com\",
        // \"filter\":\"equipmentId:"+thingGPV+"\",\"filter_name\":\"GPV-Smart-Sensor-Report-List-15-minutes\",\"excelEnabled\":false}";

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("filterId" , id)
                .add("templateId", templateId)
                .add("emaillist", testEmail)
                .add("filter", "equipmentId:"+equipment)
                .add("filter_name", name)
                .add("excelEnabled", false)
                .getJson();
        return jsonObject;
    }

    public JsonObject reportDelete(String name, String title, String equipments, String filterId, String emails, String userId){
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

    public ArrayList<String> getIdsOfAllNotifications(String response){
        JSONArray jsonArray = parseToJSONArray(response);
        ArrayList<String> ids = new ArrayList<>();
        for (Object aJsonArray : jsonArray) {
            JSONObject jsonObject = parseToJSONObject(aJsonArray.toString());
            String id = jsonObject.get("id").toString();
            ids.add(id);
        }
        return ids;
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
            jsonString = jsonString+"{\"id\":\""+arrayList.get(i)+"\",\"status\":1}";
            if (arrayList.size()>i+1){
                jsonString = jsonString+",";

            }
        }
        return jsonString+"]}";
    }

    public String notificationListDeleteAllJSON(ArrayList<String> arrayList){
        String jsonString = "{\"items\":[";
        for (int i = 0; i < arrayList.size(); i++) {
            jsonString = jsonString+"{\"id\":\""+arrayList.get(i)+"\"}";
            if (arrayList.size()>i+1){
                jsonString = jsonString+",";
            }
        }
        return jsonString+"]}";
    }

    public String notificationRuleCreateJSONDefault(){
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


    public JsonObject notificationRuleCreateJSON(String name, String description, int type,int channel, String equipment, int threshold, String trigger, String operation, int value, int period, int sensor) {
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

    public JsonObject notificationRuleCreateJSON(String name, String description, int type,String channel, String equipment, String threshold, String trigger, String operation, int value, int period, int sensor) {
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


    public String notificationRuleUpdateJSON(String id){
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

    public String dashboardCreateCanvasVPVJSONDefault(){
        String thingVPV1 = thingVpv;
        String name = defaultDashboardVPVName;
        String description = defaultDashboardVPVDescription;

        return dashboardCreateCanvasVPVJSON(thingVPV1, name, description).toString();
    }

    private JsonObject dashboardCreateCanvasVPVJSON(String thingVPV1, String name, String description){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 7)
                .addArray("equipmentIds").add(thingVPV1).end()
                .add("name", name)
                .add("description", description).getJson();
        return jsonObject;
    }

    public String dashboardCreateCanvasGPVJSONDefault(){
        String thingGPV = thingGpv;
        String name = defaultDashboardGPVName;
        String description = defaultDashboardGPVDescription;

        return dashboardCreateCanvasGPVJSON(thingGPV, name, description).toString();
    }

    public String dashboardCreateCanvasGPVJSONDefault(String equipmentId){
        String name = defaultDashboardGPVName;
        String description = defaultDashboardGPVDescription;

        return dashboardCreateCanvasGPVJSON(equipmentId, name, description).toString();
    }

    public String dashboardCreateCanvasGPVJSONDefault(String equipmentId, String description){
        String name = defaultDashboardGPVName;

        return dashboardCreateCanvasGPVJSON(equipmentId, name, description).toString();
    }

    private JsonObject dashboardCreateCanvasGPVJSON(String thingGPV, String name, String description){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 9)
                .addArray("equipmentIds").add(thingGPV).end()
                .add("name", name).add("description", description).getJson();
        return jsonObject;
    }

    public JsonObject dashboardCreate(int dashboardType, String equipmentId, String name, String description){
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

    public String equipmentOnOff(String id, Boolean active){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id",id).add("isDataTransfer",active).getJson();

        return jsonObject.toString();
    }

}
