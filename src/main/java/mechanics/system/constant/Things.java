package mechanics.system.constant;

/**
 * Created by user on 19.04.2017.
 */
public enum Things {
    ThingGPV("Thing-090035-0"),
    ThingGPVBUC("Thing-090175-0"),
    ThingVPV11("Thing-000011-i1"),
    ThingVPV12("Thing-000012-i2"),
    ThingVPV13("Thing-000013-i4"),

    LoadThingGPV("Thing-000021-0"),
    LoadThingVPV("Thing-000023-0"),

    ThingVPVForDashboard(ThingVPV11.getValue()),
    ThingGPVForDashboard(ThingGPVBUC.getValue()),

    ChannelVPV("channelIdx=1");

    private final String value;

    Things(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }
}
