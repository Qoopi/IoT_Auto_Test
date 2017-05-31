package mechanics.api.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Alex Storm on 30.05.2017.
 */
public class GlobalSettingsResponse {
    private String adminReportUrl;
    private int OEEglobal;
    private int acknowledged;
    private int fredInterval;
    private int triggered;



    public void parse(String jsonString) {
        JsonObject jsonObject = parseToJsonObject(jsonString);
        JsonObject global = jsonObject.getAsJsonObject("globalSettings");
        adminReportUrl = global.get("adminReportUrl").getAsString();
        OEEglobal = global.get("OEEglobal").getAsInt();
        acknowledged = global.get("acknowledged").getAsInt();
        fredInterval = global.get("fredInterval").getAsInt();
        triggered = global.get("triggered").getAsInt();
    }


    private JsonObject parseToJsonObject(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(jsonString);
        return jsonObject;
    }

    public String getAdminReportUrl() {
        return adminReportUrl;
    }

    public int getOEEglobal() {
        return OEEglobal;
    }

    public int getAcknowledged() {
        return acknowledged;
    }

    public int getFredInterval() {
        return fredInterval;
    }

    public int getTriggered() {
        return triggered;
    }
}
