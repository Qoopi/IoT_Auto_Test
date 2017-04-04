package load;

/**
 * Created by user on 04.04.2017.
 */
public class ThreadLaunchDelayer {
    static int countOfInvocations = 0;

    public static void delay(int delayForEachThreadMs){
        countOfInvocations++;
        int resultSleepTime = countOfInvocations*delayForEachThreadMs;
        try {
            Thread.sleep(resultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
