package APIrequests;

import api.utils.AWS;
import api.utils.RequestSender;
import org.testng.annotations.Test;

public class API {
    @Test
    public void getEquips(){
        AWS aws = new AWS();
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequest();
        aws.getEquipment();
    }


}

