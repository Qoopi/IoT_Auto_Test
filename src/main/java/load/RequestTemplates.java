package load;

import java.util.Map;

/**
 * Created by alex00x6 on 30.03.2017.
 */
public class RequestTemplates extends JSONHandler {

     void canvasVPVChartRefreshTemplate(int operatingTimeMins, String chartUpdateUrl, String dashboardInfoUrl, String notificationUnreadUrl){
        //all requests on start
        //6 chart update requests every 5 seconds
        //2 dash info requests every 30 seconds
        //2 notification requests every 1 min
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> notificationUnreadHeaders = null;
        Map<String, String> dashboardInfoHeaders = null;
        Map<String, String> chartUpdateHeaders = null;

        //2 1min requests on start here
        notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
        //2 30 sec requests on start here
        dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);

        for (int i2 = 0; i2 < operatingTimeMins; i2++) {
            for (int i1 = 0; i1 < 2; i1++) {
                for (int i = 0; i < 6; i++) {
                    //5 sec cycle
                    //6 requests every 5 sec here (1 sec cut for response)
                    chartUpdateHeaders = authHeaders("GET", chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
                    sleep(4000);
                }
                //30 sec cycle
                //2 requests every 30 sec here
                dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
            }
            //1 min cycle
            //2 requests every 1 min here
            notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
        }
    }

    void canvasVPVChartRefreshTemplateActualTime(int operatingTimeMins, String chartUpdateUrl1, String chartUpdateUrl2, String dashboardInfoUrl, String notificationUnreadUrl){
        //all requests on start
        //6 chart update requests every 5 seconds
        //2 dash info requests every 30 seconds
        //2 notification requests every 1 min
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> notificationUnreadHeaders = null;
        Map<String, String> dashboardInfoHeaders = null;
        Map<String, String> chartUpdateHeaders = null;

        //2 1min requests on start here
        notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
        //2 30 sec requests on start here
        dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);

        for (int i2 = 0; i2 < operatingTimeMins; i2++) {
            for (int i1 = 0; i1 < 2; i1++) {
                for (int i = 0; i < 6; i++) {
                    String chartUpdateUrl = chartUpdateUrl1+(System.currentTimeMillis()-10000)+chartUpdateUrl2;
                    //5 sec cycle
                    //6 requests every 5 sec here (1 sec cut for response)
                    chartUpdateHeaders = authHeaders("GET", chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
                    sleep(4000);
                }
                //30 sec cycle
                //2 requests every 30 sec here
                dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
            }
            //1 min cycle
            //2 requests every 1 min here
            notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
        }
    }

    void canvasGPVChartRefreshTemplateActualTime(int operatingTimeMins, String chartUpdateUrlNoTimestamp, String dashboardInfoUrl, String notificationUnreadUrl){
        //all requests on start
        //2 dash info requests every 30 sec
        //2 notification requests every 1 min
        //2 chart update requests every 1 min
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> notificationUnreadHeaders = null;
        Map<String, String> dashboardInfoHeaders = null;
        Map<String, String> chartUpdateHeaders = null;


        String chartUpdateUrl = chartUpdateUrlNoTimestamp+(System.currentTimeMillis()-62000);

        //
        notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
        //
        dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
        //
        chartUpdateHeaders = authHeaders("GET", chartUpdateUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);

        for (int i2 = 0; i2 < operatingTimeMins; i2++) {
            for (int i1 = 0; i1 < 2; i1++) {
                //
                dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
                sleep(29000);
            }
            //
            notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
            //
            chartUpdateUrl = chartUpdateUrlNoTimestamp+(System.currentTimeMillis()-62000);

            chartUpdateHeaders = authHeaders("GET", chartUpdateUrl);
            createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
        }

    }


    void canvasGPVChartRefreshTemplate(int operatingTimeMins, String chartUpdateUrl, String dashboardInfoUrl, String notificationUnreadUrl){
        //all requests on start
        //2 dash info requests every 30 sec
        //2 notification requests every 1 min
        //2 chart update requests every 1 min
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> notificationUnreadHeaders = null;
        Map<String, String> dashboardInfoHeaders = null;
        Map<String, String> chartUpdateHeaders = null;

        //
        notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
        //
        dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
        //
        chartUpdateHeaders = authHeaders("GET", chartUpdateUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);

        for (int i2 = 0; i2 < operatingTimeMins; i2++) {
            for (int i1 = 0; i1 < 2; i1++) {
                //
                dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
                sleep(29000);
            }
            //
            notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
            //
            chartUpdateHeaders = authHeaders("GET", chartUpdateUrl);
            createEmptyRequestWithHeaders(standardHeaders).options(chartUpdateUrl);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdateUrl);
        }

    }


    private void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
