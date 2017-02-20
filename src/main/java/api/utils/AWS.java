package api.utils;


import api.enums.Url;

public class AWS {

    public RequestSender getEquipment(){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequest().get(Url.Equipment.getUri());
        return requestSender;
    }
}
