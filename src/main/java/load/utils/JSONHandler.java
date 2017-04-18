package load.utils;

import com.google.gson.JsonObject;
import org.jglue.fluentjson.JsonBuilderFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JSONHandler extends SignAWSv4{



    public String getIdOfCreatedNotificationRule(String response){
        JSONObject jsonObject = parseToJSONObject(response);
        String id = jsonObject.get("id").toString();
        return id;
    }

    public String getIdOfCreatedDashboard(String response){
        JSONObject jsonObject = parseToJSONObject(response);
        JSONObject item = (JSONObject) jsonObject.get("item");
        String id = item.get("id").toString();
        return id;
    }

    public String getIdOfCreatedReport(String response){
        String id = null;
        return id;
    }

    private JSONObject parseToJSONObject(String jsonString){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    //"{\"active\":true,\"name\":\"Abnormal auto-test rule\",\"description\":\"some description\",\"notificationType\":0,\"type\":0,\"phones\":[{\"value\":\"+380634953177\",\"name\":\"My Lifecell\"}],
    // \"emails\":[{\"value\":\"TestUser.Israil@mail.ru\",\"name\":\"hhhhhhhhhhhhh\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":10,\"acknowledged\":15,\"sms\":false,\"emails\":false},
    // \"equipmentIds\":[\"Thing-090011-0\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":0,\"period\":0,\"sensor\":1}";
    @Test
    public void notificationRuleCreateJSON(){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("active", "true")
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
                .add("trigger","")
                .add("operation", ">=")
                .add("value", 0)
                .add("period", 0).add("sensor",1).getJson();
        System.out.println(jsonObject.toString());
    }

    //"{\"items\":[{\"id\":\""+ idOfCreatedNotificationRule.get() +"\"}]}"
    public String notificationRuleDeleteJSON(){
        String idOfRule = "254254532";

        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addArray("items").addObject().add("id", idOfRule)
                .getJson();
        return jsonObject.toString();
    }
}
