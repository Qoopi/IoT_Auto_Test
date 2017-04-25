package system.constant;

/**
 * Created by Kutafin Oleg on 24.04.2017.
 */
public enum EmailINBOX implements CharSequence {
    TitleNotificationsVPV("IoT Systems - DEV"),
    SubjectNotificationRuleAbnormalVibrations("Abnormal Vibrations"),
    SubjectNotificationRuleNumberOfAlarms("Number of Alarms above threshold"),
    SubjectNotificationRuleNumberOfAborts("Number of Aborts above threshold"),

    SubjectReportListVPVMonthly("Vacuum Pump Vibration Report - Optimized for Printing - Monthly"),
    SubjectReportListVPVWeekly("Vacuum Pump Vibration Report - Optimized for Printing - Weekly"),
    SubjectReportListVPVDaily("Vacuum Pump Vibration Report - Optimized for Printing - Daily"),
    SubjectReportListGPV15minutes("GPV Smart Sensor Report (15 minutes activity)");


    private final String Message;

    EmailINBOX(String m) {Message = m;}

    public String getMessage(){
        return Message;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
