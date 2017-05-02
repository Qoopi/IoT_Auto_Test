import org.testng.annotations.Test;
import system.constant.Things;
import system.constant.URLs;

/**
 * Created by user on 19.04.2017.
 */
public class Workbench {


    @Test
    public void test1(){
        System.out.println(URLs.DevDashboardApp.getValue());
        System.out.println(Things.ThingGPV.getValue());
    }
}
