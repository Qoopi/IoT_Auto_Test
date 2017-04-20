import system.constant.Things;
import system.constant.URLs;
import org.testng.annotations.Test;

/**
 * Created by user on 19.04.2017.
 */
public class Workbench {


    @Test
    public void test1(){
        System.out.println(URLs.Dashboard.getValue());
        System.out.println(Things.ThingGPV.getValue());
    }
}
