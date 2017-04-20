package system.http;

import com.google.gson.JsonObject;
import org.jglue.fluentjson.JsonBuilderFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import system.aws.SignAWSv4;
import system.constant.Things;

public class JSONHandler extends SignAWSv4 {
    private String defaultDashboardVPVName = "someAutoTestNameVPV";
    private String defaultDashboardVPVDescription = "someAutoTestDescriptionVPV";
    private String defaultDashboardGPVName = "someAutoTestNameGPV";
    private String defaultDashboardGPVDescription = "someAutoTestDescriptionGPV";


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

    public String notificationRuleCreateJSON() {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("active", true)
                .add("name", "Abnormal auto-test rule")
                .add("description", "some description")
                .add("notificationType", 0)
                .add("type", 0)
                .addArray("phones").addObject().add("value", "+380634953177").add("name", "My Lifecell").end().end()
                .addArray("emails").addObject().add("value", "TestUser.Israil@mail.ru").add("name", "hhhhhhhhhhhhh").end().end()
                .addObject("notifications").add("alwaysSend", false).add("triggered", 10).add("acknowledged", 15).add("sms", false).add("emails", false).end()
                .addArray("equipmentIds").add("Thing-090011-0").end()
                .add("channel", 0)
                .add("frq", 0)
                .add("threshold", 0)
                .add("trigger", "")
                .add("operation", ">=")
                .add("value", 0)
                .add("period", 0).add("sensor", 1).getJson();
        return jsonObject.toString();
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
                .addArray("emails").addObject().add("value", "TestUser.Israil@mail.ru").add("name", "hhhhhhhhhhhhh").end().end()
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
        String thingVPV1 = Things.ThingVPV13.getValue();
        String thingVPV2 = Things.ThingVPV12.getValue();
        String thingVPV3 = Things.ThingVPV11.getValue();
        String name = defaultDashboardVPVName;
        String description = defaultDashboardVPVDescription;

        return dashboardCreateCanvasVPVJSON(thingVPV1, thingVPV2, thingVPV3, name, description).toString();
    }

    private JsonObject dashboardCreateCanvasVPVJSON(String thingVPV1, String thingVPV2, String thingVPV3, String name, String description){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 7)
                .addArray("equipmentIds").add(thingVPV1).add(thingVPV2).add(thingVPV3).end()
                .add("name", name)
                .add("description", description).getJson();
        return jsonObject;
    }

    public String dashboardCreateCanvasGPVJSONDefault(){
        String thingGPV = Things.ThingGPV.getValue();
        String name = defaultDashboardGPVName;
        String description = defaultDashboardGPVDescription;

        return dashboardCreateCanvasGPVJSON(thingGPV, name, description).toString();
    }

    private JsonObject dashboardCreateCanvasGPVJSON(String thingGPV, String name, String description){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 9)
                .addArray("equipmentIds").add(thingGPV).end()
                .add("name", name).add("description", description).getJson();
        return jsonObject;
    }

    public String dashboardDeleteJSON(String id) {
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id", id).getJson();
        return jsonObject.toString();
    }
}
