package load;

/**
 * Created by user on 19.04.2017.
 */
public enum Things {
    ThingGPV("Thing-090035-0"),
    ThingVPV11("Thing-000011-i1"),
    ThingVPV12("Thing-000012-i2"),
    ThingVPV13("Thing-000013-i4"),
    ChannelVPV("channelIdx=1");

    private final String value;

    Things(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }
}
