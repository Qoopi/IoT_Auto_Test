package load.utils;

import com.google.gson.JsonObject;
import org.jglue.fluentjson.JsonBuilderFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONHandler extends SignAWSv4 {


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
        //"{\"active\":true,\"name\":\"Abnormal auto-test rule\",\"description\":\"some description\",\"notificationType\":0,\"type\":0,\"phones\":[{\"value\":\"+380634953177\",\"name\":\"My Lifecell\"}],
        // \"emails\":[{\"value\":\"TestUser.Israil@mail.ru\",\"name\":\"hhhhhhhhhhhhh\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":10,\"acknowledged\":15,\"sms\":false,\"emails\":false},
        // \"equipmentIds\":[\"Thing-090011-0\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":0,\"period\":0,\"sensor\":1}";

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
//        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    public String notificationRuleUpdateJSON(String id){
//                "{\"items\":[{\"id\":\""+idOfCreatedNotificationRule+"\",\"active\":1,\"name\":\"Abnormal edited auto-test rule\",\"description\":\"edited description\"," +
//                "\"notificationType\":0,\"type\":0,\"phones\":[{\"value\":\"+380634953177\",\"name\":\"My Lifecell\"}]," +
//                "\"emails\":[{\"value\":\"TestUser.Israil@mail.ru\",\"name\":\"hhhhhhhhhhhhh\"}]," +
//                "\"notifications\":{\"alwaysSend\":false,\"triggered\":10,\"acknowledged\":15,\"globalSettings\":0,\"sms\":false,\"emails\":false}," +
//                "\"equipmentIds\":[\"Thing-090011-0\"]," +
//                "\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":30,\"period\":0,\"sensor\":1}]}";

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
        //"{\"items\":[{\"id\":\""+ idOfCreatedNotificationRule.get() +"\"}]}"

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id", id).getJson();
        return jsonObject.toString();
    }

    public String dashboardCreateCanvasVPVJSON(){
//        "{\"type\":7,\"equipmentIds\":[\"Thing-000013-i3\",\"Thing-000011-i1\",\"Thing-000012-i2\"],\"name\":\"someAutoTestNameVPV\",\"description\":\"someAutoTestDescriptionVPV\"}";

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 7)
                .addArray("equipmentIds").add("Thing-000013-i3").add("Thing-000011-i1").add("Thing-000012-i2").end()
                .add("name", "someAutoTestNameVPV")
                .add("description", "someAutoTestDescriptionVPV").getJson();
        return jsonObject.toString();
    }

    public String dashboardCreateCanvasGPVJSON(){
//        "{\"type\":9,\"equipmentIds\":[\""+thingGPV+"\"],\"name\":\"someAutoTestNameGPV\",\"description\":\"someAutoTestDescriptionGPV\"}";

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("type", 9)
                .addArray("equipmentIds").add("Thing-090035-0").end()
                .add("name", "someAutoTestNameVPV").add("description", "someAutoTestDescriptionVPV").getJson();
        return jsonObject.toString();
    }

    public String dashboardDeleteJSON(String id) {
        //"{\"items\":[{\"id\":\""+ idOfCreatedNotificationRule.get() +"\"}]}"

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id", id).getJson();
        return jsonObject.toString();
    }
}
