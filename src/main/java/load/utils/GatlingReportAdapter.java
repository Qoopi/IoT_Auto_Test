package load.utils;

/**
 * Created by user on 18.04.2017.
 */
public class GatlingReportAdapter {

    public static void gatlingInfoPrintUserStart(){
        String name = "RecordedSimulation1";
        long thread = Thread.currentThread().getId();
        long timeStart = System.currentTimeMillis();
        System.out.println("USER\t"+name+"\t"+thread+"\tSTART\t"+timeStart+"\t"+timeStart);
    }
}
