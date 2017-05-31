package mechanics.api.json;

import com.google.gson.JsonObject;
import mechanics.system.constant.AssembledUrls;
import org.jglue.fluentjson.JsonBuilderFactory;

/**
 * Created by Alex Storm on 30.05.2017.
 */
public class GlobalSettingsRequest {
    private String adminReportUrl = AssembledUrls.skedlerEndpoint;
    private int OEEglobal = 0;
    private int acknowledged = 30;
    private int fredInterval = 0;
    private int triggered = 300;

    public String initialize(){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .add("OEEglobal", OEEglobal)
                .add("acknowledged", acknowledged)
                .add("adminReportUrl", adminReportUrl)
                .add("fredInterval", fredInterval)
                .add("triggered", triggered)
                .getJson();
        return jsonObject.toString();
    }


    public static GlobalSettingsRequest.Builder newBuilder() {
        return new GlobalSettingsRequest().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setAdminReportUrl(String adminReportUrl){
            GlobalSettingsRequest.this.adminReportUrl = adminReportUrl;
            return this;
        }

        public Builder setOEEglobal(int OEEglobal){
            GlobalSettingsRequest.this.OEEglobal = OEEglobal;
            return this;
        }

        public Builder setAcknowledged(int acknowledged){
            GlobalSettingsRequest.this.acknowledged = acknowledged;
            return this;
        }

        public Builder setFredInterval(int fredInterval){
            GlobalSettingsRequest.this.fredInterval = fredInterval;
            return this;
        }

        public Builder setTriggered(int triggered){
            GlobalSettingsRequest.this.triggered = triggered;
            return this;
        }

        public String initialize(){
            GlobalSettingsRequest globalSettingsRequest = new GlobalSettingsRequest();
            globalSettingsRequest.adminReportUrl=GlobalSettingsRequest.this.adminReportUrl;
            globalSettingsRequest.OEEglobal=GlobalSettingsRequest.this.OEEglobal;
            globalSettingsRequest.acknowledged=GlobalSettingsRequest.this.acknowledged;
            globalSettingsRequest.fredInterval=GlobalSettingsRequest.this.fredInterval;
            globalSettingsRequest.triggered=GlobalSettingsRequest.this.triggered;

            return globalSettingsRequest.initialize();
        }
    }
}
